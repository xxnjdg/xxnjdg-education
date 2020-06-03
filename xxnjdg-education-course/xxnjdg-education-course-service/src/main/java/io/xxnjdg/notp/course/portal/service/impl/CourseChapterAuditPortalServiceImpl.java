package io.xxnjdg.notp.course.portal.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.mapper.CourseChapterAuditMapper;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import io.xxnjdg.notp.course.portal.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.portal.object.convert.CourseChapterAuditMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.audit.*;
import io.xxnjdg.notp.course.portal.object.error.CourseChapterAuditEnum;
import io.xxnjdg.notp.course.portal.service.CourseAuditPortalService;
import io.xxnjdg.notp.course.portal.service.CourseChapterAuditPortalService;
import io.xxnjdg.notp.course.portal.service.CourseChapterPeriodAuditPortalService;
import io.xxnjdg.notp.course.portal.service.CoursePortalService;
import io.xxnjdg.notp.course.util.CourseLock;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.AuditStatus;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.LockTime;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 16:04
 */
@Service
public class CourseChapterAuditPortalServiceImpl extends ServiceImpl<CourseChapterAuditMapper, CourseChapterAudit> implements CourseChapterAuditPortalService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Autowired
    private CourseChapterPeriodAuditPortalService courseChapterPeriodAuditPortalService;

    @Autowired
    private CourseAuditPortalService courseAuditPortalService;

    @Autowired
    private CoursePortalService coursePortalService;

    @Override
    public Boolean deleteCourseChapterAuditByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapterAudit> wrapper = new QueryWrapper<CourseChapterAudit>()
                .lambda()
                .eq(CourseChapterAudit::getCourseId, courseId);
        return this.remove(wrapper);
    }

    @Override
    public List<CourseChapterAudit> listCourseChapterAuditByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapterAudit> wrapper = new QueryWrapper<CourseChapterAudit>()
                .lambda()
                .eq(CourseChapterAudit::getCourseId, courseId);
        return this.list(wrapper);
    }

    @Override
    public List<CourseChapterAuditBO> listCourseChapterAudit(CourseChapterAuditPageDTO courseChapterAuditPageDTO) {
        LambdaQueryWrapper<CourseChapterAudit> wrapper = new QueryWrapper<CourseChapterAudit>()
                .lambda()
                .eq(CourseChapterAudit::getCourseId, courseChapterAuditPageDTO.getCourseId())
                .eq(CourseChapterAudit::getStatusId, RowStatus.ENABLE)
                .orderByAsc(CourseChapterAudit::getSort);

        List<CourseChapterAuditBO> courseChapterAuditBOList =
                CourseChapterAuditMapStruct.INSTANCE.P2B(this.list(wrapper));

        if (CollUtil.isEmpty(courseChapterAuditBOList)) {
            return courseChapterAuditBOList;
        }

        List<Long> ids = courseChapterAuditBOList.stream()
                .map(CourseChapterAuditBO::getId).collect(Collectors.toList());

        List<CourseChapterPeriodAudit> courseChapterPeriodAuditList =
                courseChapterPeriodAuditPortalService.listCourseChapterPeriodAuditByChapterIds(ids);

        if (CollUtil.isEmpty(courseChapterPeriodAuditList)) {
            return courseChapterAuditBOList;
        }

        Map<Long, List<CourseChapterPeriodAudit>> collect = courseChapterPeriodAuditList
                .stream().collect(Collectors.groupingBy(CourseChapterPeriodAudit::getChapterId));

        courseChapterAuditBOList.forEach(courseChapterAuditBO -> {
            List<CourseChapterPeriodAudit> chapterPeriodAuditList = collect.get(courseChapterAuditBO.getId());
            if (CollUtil.isNotEmpty(chapterPeriodAuditList)) {
                courseChapterAuditBO.setPeriodNum(chapterPeriodAuditList.size());
            }
        });

        return courseChapterAuditBOList;
    }

    @Override
    @Transactional
    public CourseChapterAuditBO saveCourseChapterAudit(CourseChapterAuditSaveDTO courseChapterAuditSaveDTO) {

        Long courseId = courseChapterAuditSaveDTO.getCourseId();
        Long userNo = courseChapterAuditSaveDTO.getUserNo();

        ReentrantLock lock = CourseLock.getInstance().getLock(courseId);
        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {
                    courseAuditPortalService.checkIdAndLecturer(courseId, userNo);

                    //生成主键id
                    Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
                    long id = snowflake.nextId();

                    //dto -> po
                    //构造剩余字段
                    CourseChapterAudit courseChapterAudit =
                            CourseChapterAuditMapStruct.INSTANCE.DT2P(courseChapterAuditSaveDTO)
                                    .setId(id)
                                    .setAuditStatus(AuditStatus.PENDING_APPROVAL);

                    //插入
                    boolean save = this.save(courseChapterAudit);
                    if (!save) {
                        throw new BaseException(CourseChapterAuditEnum.SAVE_ERROR);
                    }

                    //同时更新 CourseAudit AuditStatus 为0
                    boolean update = courseAuditPortalService.updateCourseAudit(
                            new CourseAudit()
                                    .setId(courseId)
                                    .setGmtModified(LocalDateTime.now())
                                    .setAuditStatus(AuditStatus.PENDING_APPROVAL));

                    if (!update) {
                        throw new BaseException(CourseChapterAuditEnum.SAVE_ERROR);
                    }

                    return CourseChapterAuditMapStruct.INSTANCE.P2B(courseChapterAudit);
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(), e.getMessage());
        }

        throw new BaseException(CourseChapterAuditEnum.LOCK_ERROR);
    }

    @Override
    @Transactional
    public CourseChapterAuditBO updateCourseChapterAudit(CourseChapterAuditUpdateDTO courseChapterAuditUpdateDTO) {

        Long id = courseChapterAuditUpdateDTO.getId();
        Long userNo = courseChapterAuditUpdateDTO.getUserNo();

        CourseChapterAudit one = this.getCourseChapterAuditById(id);

        if (one == null) {
            throw new BaseException(CourseChapterAuditEnum.SAVE_ERROR);
        }

        Long courseId = one.getCourseId();

        ReentrantLock lock = CourseLock.getInstance().getLock(courseId);
        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {

                    //检测权限
                    courseAuditPortalService.checkIdAndLecturer(courseId, userNo);

                    //更新自己
                    CourseChapterAudit courseChapterAudit = CourseChapterAuditMapStruct
                            .INSTANCE.DT2P(courseChapterAuditUpdateDTO)
                            .setAuditStatus(AuditStatus.PENDING_APPROVAL)
                            .setGmtModified(LocalDateTime.now());


                    boolean update = updateCourseChapterAudit(courseChapterAudit);
                    if (!update) {
                        throw new BaseException(CourseChapterAuditEnum.UPDATE_ERROR);
                    }

                    //同时更新 CourseAudit AuditStatus 为0
                    boolean update1 = courseAuditPortalService.updateCourseAudit(
                            new CourseAudit()
                                    .setId(courseId)
                                    .setGmtModified(LocalDateTime.now())
                                    .setAuditStatus(AuditStatus.PENDING_APPROVAL));

                    if (!update1) {
                        throw new BaseException(CourseChapterAuditEnum.SAVE_ERROR);
                    }

                    return CourseChapterAuditMapStruct.INSTANCE.P2B(courseChapterAudit);
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(), e.getMessage());
        }

        throw new BaseException(CourseChapterAuditEnum.LOCK_ERROR);
    }

    @Override
    @Transactional
    public Boolean deleteCourseChapterAudit(CourseChapterAuditDeleteDTO courseChapterAuditDeleteDTO) {
        Long id = courseChapterAuditDeleteDTO.getId();
        Long userNo = courseChapterAuditDeleteDTO.getUserNo();

        LambdaQueryWrapper<CourseChapterAudit> wrapper = new QueryWrapper<CourseChapterAudit>()
                .lambda()
                .eq(CourseChapterAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseChapterAudit::getId, id);

        CourseChapterAudit courseChapterAudit = this.getOne(wrapper);

        if (courseChapterAudit == null) {
            throw new BaseException(CourseChapterAuditEnum.DELETE_ERROR);
        }

        Long courseId = courseChapterAudit.getCourseId();
        ReentrantLock lock = CourseLock.getInstance().getLock(courseId);
        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {

                    //检测权限
                    courseAuditPortalService.checkIdAndLecturer(courseId, userNo);

                    List<CourseChapterPeriodAudit> courseChapterPeriodAuditList = courseChapterPeriodAuditPortalService
                            .listCourseChapterPeriodAuditByChapterIds(Collections.singletonList(id));

                    //课时不为空不能删除
                    if (CollUtil.isNotEmpty(courseChapterPeriodAuditList)) {
                        throw new BaseException(CourseChapterAuditEnum.DELETE_ERROR);
                    }

                    Course course = coursePortalService.getById(courseId);
                    boolean remove = false;
                    if (course == null) {
                        //直接删除
                        remove = this.remove(wrapper);

                        if (!remove) {
                            throw new BaseException(CourseChapterAuditEnum.DELETE_ERROR);
                        }
                    } else {
                        //逻辑删除
                        remove = this.updateCourseChapterAudit(
                                new CourseChapterAudit()
                                        .setId(id)
                                        .setGmtModified(LocalDateTime.now())
                                        .setStatusId(RowStatus.DISABLED)
                                        .setAuditStatus(AuditStatus.PENDING_APPROVAL));

                        if (!remove) {
                            throw new BaseException(CourseChapterAuditEnum.DELETE_ERROR);
                        }

                        //同时更新 CourseAudit AuditStatus 为0
                        boolean update = courseAuditPortalService.updateCourseAudit(
                                new CourseAudit()
                                        .setId(courseId)
                                        .setGmtModified(LocalDateTime.now())
                                        .setAuditStatus(AuditStatus.PENDING_APPROVAL));

                        if (!update) {
                            throw new BaseException(CourseChapterAuditEnum.SAVE_ERROR);
                        }
                    }

                    return true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(), e.getMessage());
        }

        throw new BaseException(CourseChapterAuditEnum.LOCK_ERROR);
    }

    @Override
    public Boolean sortCourseChapterAudit(CourseChapterAuditSortDTO setUserNo) {

        return null;
    }

    @Override
    public CourseChapterAudit getCourseChapterAuditById(Long id) {
        //查询 CourseChapterAudit 的 courseId
        LambdaQueryWrapper<CourseChapterAudit> wrapper = new QueryWrapper<CourseChapterAudit>()
                .lambda()
                .eq(CourseChapterAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseChapterAudit::getId, id);

        return this.getOne(wrapper);
    }

    @Override
    public boolean updateCourseChapterAudit(CourseChapterAudit courseChapterAudit) {
        LambdaUpdateWrapper<CourseChapterAudit> updateWrapper = new UpdateWrapper<CourseChapterAudit>()
                .lambda()
                .eq(CourseChapterAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseChapterAudit::getId, courseChapterAudit.getId());

        return this.update(courseChapterAudit, updateWrapper);
    }
}
