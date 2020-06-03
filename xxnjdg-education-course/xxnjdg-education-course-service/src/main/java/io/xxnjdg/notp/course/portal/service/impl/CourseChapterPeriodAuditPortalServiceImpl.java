package io.xxnjdg.notp.course.portal.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.mapper.CourseChapterPeriodAuditMapper;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import io.xxnjdg.notp.course.portal.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.portal.object.convert.CourseChapterPeriodAuditMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditDeleteDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditPageDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditSaveDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditUpdateDTO;
import io.xxnjdg.notp.course.portal.object.error.CourseChapterAuditEnum;
import io.xxnjdg.notp.course.portal.object.error.CourseChapterPeriodAuditEnum;
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
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 16:06
 */
@Service
public class CourseChapterPeriodAuditPortalServiceImpl extends ServiceImpl<CourseChapterPeriodAuditMapper, CourseChapterPeriodAudit> implements CourseChapterPeriodAuditPortalService {

    @Autowired
    private CourseChapterAuditPortalService courseChapterAuditPortalService;

    @Autowired
    private CourseAuditPortalService courseAuditPortalService;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Autowired
    private CoursePortalService coursePortalService;

    @Override
    public Boolean deleteCourseChapterPeriodAuditByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getCourseId, courseId);

        return this.remove(wrapper);
    }

    @Override
    public List<CourseChapterPeriodAudit> listCourseChapterPeriodAuditByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getCourseId, courseId);
        return this.list(wrapper);
    }

    @Override
    public List<CourseChapterPeriodAudit> listCourseChapterPeriodAuditByChapterIds(Collection<Long> chapterIds) {
        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE)
                .in(CourseChapterPeriodAudit::getChapterId, chapterIds);
        return this.list(wrapper);
    }

    @Override
    public List<CourseChapterPeriodAuditBO> listCourseChapterPeriodAudit(CourseChapterPeriodAuditPageDTO courseChapterPeriodAuditPageDTO) {

        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getChapterId, courseChapterPeriodAuditPageDTO.getChapterId())
                .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE)
                .orderByAsc(CourseChapterPeriodAudit::getSort)
                .orderByAsc(CourseChapterPeriodAudit::getId);

        return CourseChapterPeriodAuditMapStruct.INSTANCE.P2B(this.list(wrapper));
    }

    @Override
    @Transactional
    public CourseChapterPeriodAuditBO saveCourseChapterPeriodAudit(CourseChapterPeriodAuditSaveDTO courseChapterPeriodAuditSaveDTO) {
        Long chapterId = courseChapterPeriodAuditSaveDTO.getChapterId();
        Long userNo = courseChapterPeriodAuditSaveDTO.getUserNo();

        //查询章节
        CourseChapterAudit courseChapterAudit =
                courseChapterAuditPortalService.getCourseChapterAuditById(chapterId);

        if (courseChapterAudit == null) {
            throw new BaseException(CourseChapterPeriodAuditEnum.SAVE_ERROR);
        }


        //查询 CourseAudit
        Long courseId = courseChapterAudit.getCourseId();
        ReentrantLock lock = CourseLock.getInstance().getLock(courseId);
        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {

                    //检查权限
                    courseAuditPortalService.checkIdAndLecturer(courseId, userNo);

                    //生成主键id
                    Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
                    long id = snowflake.nextId();

                    //BTO -> PO
                    CourseChapterPeriodAudit courseChapterPeriodAudit =
                            CourseChapterPeriodAuditMapStruct.INSTANCE.DT2P(courseChapterPeriodAuditSaveDTO);

                    //设置 setIsDoc
                    if (StrUtil.isNotBlank(courseChapterPeriodAudit.getDocUrl())) {
                        courseChapterPeriodAudit.setIsDoc(1);
                    }

                    //设置 主键 课程id 待审核状态
                    courseChapterPeriodAudit
                            .setId(id)
                            .setCourseId(courseId)
                            .setAuditStatus(AuditStatus.PENDING_APPROVAL);

                    //插入
                    boolean save = this.save(courseChapterPeriodAudit);
                    if (!save) {
                        throw new BaseException(CourseChapterPeriodAuditEnum.SAVE_ERROR);
                    }

                    //更新 courseChapterAudit 待审核状态
                    boolean update = this.updateCourseChapterAuditStatus(chapterId);

                    if (!update) {
                        throw new BaseException(CourseChapterPeriodAuditEnum.SAVE_ERROR);
                    }

                    //更新 courseAudit 待审核状态
                    boolean update1 = updateCourseAuditStatus(courseId);

                    if (!update1) {
                        throw new BaseException(CourseChapterPeriodAuditEnum.SAVE_ERROR);
                    }

                    return CourseChapterPeriodAuditMapStruct.INSTANCE.P2B(courseChapterPeriodAudit);
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
    public Boolean updateCourseChapterPeriodAudit(CourseChapterPeriodAuditUpdateDTO courseChapterPeriodAuditUpdateDTO) {
        Long id = courseChapterPeriodAuditUpdateDTO.getId();
        Long userNo = courseChapterPeriodAuditUpdateDTO.getUserNo();

        //查询自己
        CourseChapterPeriodAudit courseChapterPeriodAudit = this.getCourseChapterPeriodAuditById(id);

        if (courseChapterPeriodAudit == null) {
            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
        }

        Long courseId = courseChapterPeriodAudit.getCourseId();
        Long chapterId = courseChapterPeriodAudit.getChapterId();

        ReentrantLock lock = CourseLock.getInstance().getLock(courseId);
        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {

                    //检查权限
                    courseAuditPortalService.checkIdAndLecturer(courseId, userNo);


                    CourseChapterPeriodAudit one = CourseChapterPeriodAuditMapStruct.INSTANCE
                            .DT2P(courseChapterPeriodAuditUpdateDTO);

                    if (StrUtil.isNotBlank(courseChapterPeriodAuditUpdateDTO.getDocUrl())) {
                        one.setIsDoc(1);
                    } else {
                        one
                                .setDocUrl(null)
                                .setDocName(null)
                                .setIsDoc(0);
                    }

                    //更新
                    LambdaUpdateWrapper<CourseChapterPeriodAudit> wrapper = new UpdateWrapper<CourseChapterPeriodAudit>()
                            .lambda()
                            .eq(CourseChapterPeriodAudit::getId, id)
                            .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE);

                    boolean update = this.update(one, wrapper);

                    if (!update) {
                        throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
                    }

                    //更新 courseChapterAudit 待审核状态
                    boolean update1 = this.updateCourseChapterAuditStatus(chapterId);

                    if (!update1) {
                        throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
                    }

                    //更新 courseAudit 待审核状态
                    boolean update2 = updateCourseAuditStatus(courseId);

                    if (!update2) {
                        throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
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
    public Boolean deleteCourseChapterPeriodAudit(CourseChapterPeriodAuditDeleteDTO courseChapterPeriodAuditDeleteDTO) {
        Long id = courseChapterPeriodAuditDeleteDTO.getId();
        Long userNo = courseChapterPeriodAuditDeleteDTO.getUserNo();

        //查询自己
        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getId, id)
                .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE);

        CourseChapterPeriodAudit courseChapterPeriodAudit = this.getOne(wrapper);

        if (courseChapterPeriodAudit == null) {
            throw new BaseException(CourseChapterPeriodAuditEnum.DELETE_ERROR);
        }

        Long courseId = courseChapterPeriodAudit.getCourseId();
        Long chapterId = courseChapterPeriodAudit.getChapterId();

        ReentrantLock lock = CourseLock.getInstance().getLock(courseId);
        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {
                    //检查权限
                    courseAuditPortalService.checkIdAndLecturer(courseId, userNo);

                    Course course = coursePortalService.getById(courseId);
                    boolean remove = false;

                    if (course == null) {
                        //直接删除
                        remove = this.remove(wrapper);

                        if (!remove) {
                            throw new BaseException(CourseChapterPeriodAuditEnum.DELETE_ERROR);
                        }
                    } else {
                        //逻辑删除
                        CourseChapterPeriodAudit one = new CourseChapterPeriodAudit()
                                .setId(id)
                                .setGmtModified(LocalDateTime.now())
                                .setStatusId(RowStatus.DISABLED)
                                .setAuditStatus(AuditStatus.PENDING_APPROVAL);


                        remove = this.update(one, wrapper);

                        if (!remove) {
                            throw new BaseException(CourseChapterPeriodAuditEnum.DELETE_ERROR);
                        }

                        //更新 courseChapterAudit 待审核状态
                        boolean update1 = this.updateCourseChapterAuditStatus(chapterId);

                        if (!update1) {
                            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
                        }

                        //更新 courseAudit 待审核状态
                        boolean update2 = updateCourseAuditStatus(courseId);

                        if (!update2) {
                            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
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

    private boolean updateCourseAuditStatus(Long courseId) {
        //更新 courseAudit 待审核状态
        CourseAudit courseAudit = new CourseAudit()
                .setId(courseId)
                .setGmtModified(LocalDateTime.now())
                .setAuditStatus(AuditStatus.PENDING_APPROVAL);

        return courseAuditPortalService.updateCourseAudit(courseAudit);
    }

    private boolean updateCourseChapterAuditStatus(Long chapterId) {
        //更新 courseChapterAudit 待审核状态
        CourseChapterAudit courseChapterAudit = new CourseChapterAudit()
                .setId(chapterId)
                .setAuditStatus(AuditStatus.PENDING_APPROVAL)
                .setGmtModified(LocalDateTime.now());

        return courseChapterAuditPortalService.updateCourseChapterAudit(courseChapterAudit);
    }

    private CourseChapterPeriodAudit getCourseChapterPeriodAuditById(Long id) {

        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getId, id)
                .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE);

        return this.getOne(wrapper);
    }
}
