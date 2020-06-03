package io.xxnjdg.notp.course.portal.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.mapper.CourseAuditMapper;
import io.xxnjdg.notp.course.object.persistent.*;
import io.xxnjdg.notp.course.portal.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.portal.object.convert.CourseAuditMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.autdit.*;
import io.xxnjdg.notp.course.portal.object.error.CourseAuditEnum;
import io.xxnjdg.notp.course.portal.service.*;
import io.xxnjdg.notp.course.util.CourseLock;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.AuditStatus;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.LockTime;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 4:06
 */
@Service
public class CourseAuditPortalServiceImpl extends ServiceImpl<CourseAuditMapper, CourseAudit> implements CourseAuditPortalService {

    @Autowired
    private CoursePortalService coursePortalService;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Autowired
    private CourseChapterAuditPortalService courseChapterAuditPortalService;

    @Autowired
    private CourseChapterPeriodAuditPortalService courseChapterPeriodAuditPortalService;

    @Autowired
    private CourseIntroduceAuditPortalService courseIntroduceAuditPortalService;

    @Override
    public PageResult<CourseAuditBO> listCourseAuditByPage(CourseAuditPageDTO courseAuditPageDTO) {
        Long lecturerUserNo = courseAuditPageDTO.getLecturerUserNo();
        Integer auditStatus = courseAuditPageDTO.getAuditStatus();
        PageResult<CourseAuditBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<CourseAudit> wrapper = new QueryWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getLecturerUserNo, lecturerUserNo)
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE);

        if (auditStatus != null) {
            wrapper.eq(CourseAudit::getAuditStatus, auditStatus);
        } else {
            wrapper.lt(CourseAudit::getAuditStatus, 3);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                courseAuditPageDTO.getPageCurrent(), courseAuditPageDTO.getPageSize(), count);

        //查询
        List<CourseAudit> courseAuditList =
                this.baseMapper.listCourseAuditPortalByPage(lecturerUserNo, auditStatus, pageObject.getOffset(), pageObject.getSize());

        List<CourseAuditBO> courseAuditBOList = CourseAuditMapStruct.INSTANCE.P2B(courseAuditList);

        //设置 isDelete 字段
        List<Long> ids = courseAuditBOList.stream().map(CourseAuditBO::getId)
                .collect(Collectors.toList());

        courseAuditBOList.forEach(courseAuditBO -> courseAuditBO.setIsDelete(1));

        List<Course> courseList = coursePortalService.listByIds(ids);

        //只要是有一次审核通过了,即course表存在记录,不管statusId是什么，那么就不能删除了
        if (CollUtil.isNotEmpty(courseList)) {
            courseAuditBOList.forEach(courseAuditBO -> courseList.forEach(course -> {
                if (ObjectUtil.equal(courseAuditBO.getId(), course.getId())) {
                    courseAuditBO.setIsDelete(0);
                }
            }));
        }

        return result
                .setCurrentList(courseAuditBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) courseAuditBOList.size());
    }

    @Override
    public CourseAuditBO getCourseAudit(CourseAuditViewDTO courseAuditViewDTO) {

        CourseAudit courseAudit = this.getCourseAuditById(courseAuditViewDTO.getId());

        if (courseAudit == null) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        //查询CourseIntroduceAudit
        CourseIntroduceAudit courseIntroduceAudit = courseIntroduceAuditPortalService
                .getById(courseAudit.getIntroduceId());

        if (courseIntroduceAudit == null) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        return CourseAuditMapStruct.INSTANCE.P2B(courseAudit)
                .setIntroduce(courseIntroduceAudit.getIntroduce());
    }

    @Override
    @Transactional
    public CourseAuditBO saveCourseAudit(CourseAuditSaveDTO courseAuditSaveDTO) {

        // 如果课程收费，价格不能为空
        if (ObjectUtil.equal(courseAuditSaveDTO.getIsFree(), 0) && courseAuditSaveDTO.getCourseOriginal() == null) {
            throw new BaseException(CourseAuditEnum.SAVE_ERROR);
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        ReentrantLock lock = CourseLock.getInstance().getLock(id);

        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {
                    // TODO: 2020/5/30 判断lecturerUserNo是否是老师

                    //插入简介
                    CourseIntroduceAudit courseIntroduceAudit = new CourseIntroduceAudit()
                            .setId(snowflake.nextId())
                            .setIntroduce(courseAuditSaveDTO.getIntroduce());
                    boolean save1 = courseIntroduceAuditPortalService.save(courseIntroduceAudit);
                    if (!save1) {
                        throw new BaseException(CourseAuditEnum.SAVE_ERROR);
                    }

                    CourseAudit courseAudit = CourseAuditMapStruct.INSTANCE.DT2P(courseAuditSaveDTO);

                    if (ObjectUtil.equal(courseAudit.getIsFree(), 1)) {
                        courseAudit.setCourseOriginal(BigDecimal.valueOf(0));
                    }

                    courseAudit
                            .setId(id)
                            .setIntroduceId(courseIntroduceAudit.getId())
                            .setCourseDiscount(courseAudit.getCourseOriginal());

                    //插入
                    boolean save = this.save(courseAudit);

                    if (!save) {
                        throw new BaseException(CourseAuditEnum.SAVE_ERROR);
                    }

                    return CourseAuditMapStruct.INSTANCE.P2B(courseAudit);
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(), e.getMessage());
        }

        throw new BaseException(CourseAuditEnum.LOCK_ERROR);
    }

    @Override
    @Transactional
    public Boolean updateCourseAudit(CourseAuditUpdateDTO courseAuditUpdateDTO) {
        // 如果课程收费，价格不能为空
        if (ObjectUtil.equal(courseAuditUpdateDTO.getIsFree(), 0) &&
                courseAuditUpdateDTO.getCourseOriginal() == null) {
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }

        ReentrantLock lock = CourseLock.getInstance().getLock(courseAuditUpdateDTO.getId());

        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {

                    CourseAudit oldCourseAudit = checkIdAndLecturer(courseAuditUpdateDTO.getId(),
                            courseAuditUpdateDTO.getLecturerUserNo());

                    //更新描述
                    boolean update1 = courseIntroduceAuditPortalService.updateById(
                            new CourseIntroduceAudit()
                                    .setId(oldCourseAudit.getIntroduceId())
                                    .setIntroduce(courseAuditUpdateDTO.getIntroduce())
                                    .setGmtModified(LocalDateTime.now()));

                    if (!update1) {
                        throw new BaseException(CourseAuditEnum.SAVE_ERROR);
                    }

                    if (ObjectUtil.equal(courseAuditUpdateDTO.getIsFree(), 1)) {
                        courseAuditUpdateDTO.setCourseOriginal(String.valueOf(0));
                    }

                    if (courseAuditUpdateDTO.getCategoryId1() == null) {
                        courseAuditUpdateDTO.setCategoryId1(0L);
                    }
                    if (courseAuditUpdateDTO.getCategoryId2() == null) {
                        courseAuditUpdateDTO.setCategoryId2(0L);
                    }
                    if (courseAuditUpdateDTO.getCategoryId3() == null) {
                        courseAuditUpdateDTO.setCategoryId3(0L);
                    }

                    CourseAudit courseAudit =
                            CourseAuditMapStruct.INSTANCE.DT2P(courseAuditUpdateDTO)
                                    .setGmtModified(LocalDateTime.now())
                                    .setAuditStatus(AuditStatus.PENDING_APPROVAL)
                                    .setCourseDiscount(new BigDecimal(courseAuditUpdateDTO.getCourseOriginal()));

                    boolean update = this.updateCourseAudit(courseAudit);

                    if (!update) {
                        throw new BaseException(CourseAuditEnum.SAVE_ERROR);
                    }

                    return true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(), e.getMessage());
        }

        throw new BaseException(CourseAuditEnum.LOCK_ERROR);
    }

    @Override
    public Boolean updateCourseAuditByPutaway(CourseAuditPutawayDTO courseAuditPutawayDTO) {

        Long id = courseAuditPutawayDTO.getId();
        ReentrantLock lock = CourseLock.getInstance().getLock(id);
        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {
                    checkIdAndLecturer(id, courseAuditPutawayDTO.getLecturerUserNo());

                    CourseAudit courseAudit = CourseAuditMapStruct.INSTANCE
                            .DT2P(courseAuditPutawayDTO)
                            .setAuditStatus(AuditStatus.PENDING_APPROVAL);

                    boolean update = this.updateCourseAudit(courseAudit);

                    if (!update) {
                        throw new BaseException(CourseAuditEnum.SAVE_ERROR);
                    }

                    return true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(), e.getMessage());
        }

        throw new BaseException(CourseAuditEnum.LOCK_ERROR);
    }

    @Override
    @Transactional
    public Boolean deleteCourseAudit(CourseAuditDeleteDTO courseAuditDeleteDTO) {
        Long id = courseAuditDeleteDTO.getId();
        ReentrantLock lock = CourseLock.getInstance().getLock(id);
        try {
            if (lock.tryLock(LockTime.LOCK_TIME, LockTime.LOCK_TIME_UNIT)) {
                try {
                    //检查
                    CourseAudit courseAudit = this.checkIdAndLecturer(id,
                            courseAuditDeleteDTO.getLecturerUserNo());

                    //审核通过就不能删除了
                    Course course = coursePortalService.getById(courseAudit.getId());
                    if (course != null) {
                        throw new BaseException(CourseAuditEnum.DELETE_ERROR);
                    }

                    //没有去查询statusId,既这次全部删除
                    List<CourseChapterPeriodAudit> courseChapterPeriodAuditList =
                            courseChapterPeriodAuditPortalService.listCourseChapterPeriodAuditByCourseId(id);

                    if (CollUtil.isNotEmpty(courseChapterPeriodAuditList)){
                        //1 删除课时
                        Boolean remove = courseChapterPeriodAuditPortalService
                                .deleteCourseChapterPeriodAuditByCourseId(id);

                        if (!remove) {
                            throw new BaseException(CourseAuditEnum.DELETE_ERROR);
                        }
                    }

                    //没有去查询statusId,既这次全部删除
                    List<CourseChapterAudit> courseChapterAuditList =
                            courseChapterAuditPortalService.listCourseChapterAuditByCourseId(id);

                    if (CollUtil.isNotEmpty(courseChapterAuditList)){
                        //2 删除章节
                        Boolean remove1 = courseChapterAuditPortalService
                                .deleteCourseChapterAuditByCourseId(id);
                        if (!remove1) {
                            throw new BaseException(CourseAuditEnum.DELETE_ERROR);
                        }
                    }

                    //3 删除课程信息
                    boolean remove2 = courseIntroduceAuditPortalService.removeById(
                            courseAudit.getIntroduceId());

                    if (!remove2) {
                        throw new BaseException(CourseAuditEnum.DELETE_ERROR);
                    }

                    //4 删除课程
                    //只能删除没有审核(没有course)且statusId为1
                    //存在course代表要删除发表课程，该删除是删除未发表，statusId为0代表逻辑删除了，既执行了删除发表课程
                    boolean remove3 = this.removeById(id);

                    if (!remove3) {
                        throw new BaseException(CourseAuditEnum.DELETE_ERROR);
                    }

                    return true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(), e.getMessage());
        }

        throw new BaseException(CourseAuditEnum.LOCK_ERROR);
    }

    @Override
    public boolean updateCourseAudit(CourseAudit courseAudit) {
        //更新
        LambdaUpdateWrapper<CourseAudit> wrapper = new UpdateWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseAudit::getId, courseAudit.getId());

        return this.update(courseAudit, wrapper);
    }

    @Override
    public CourseAudit checkIdAndLecturer(Long id, Long lecturerUserNo) {
        //查询课程 和 参数 lecturerUserNo 是否一致
        CourseAudit oldCourseAudit = this.getCourseAuditById(id);

        if (oldCourseAudit == null) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        if (!ObjectUtil.equal(oldCourseAudit.getLecturerUserNo(), lecturerUserNo)) {
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }

        return oldCourseAudit;
    }

    private CourseAudit getCourseAuditById(Long id) {
        //查询CourseAudit
        LambdaQueryWrapper<CourseAudit> wrapper = new QueryWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseAudit::getId, id);

        return this.getOne(wrapper);
    }

}
