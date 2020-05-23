package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.admin.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseAuditMapStruct;
import io.xxnjdg.notp.course.admin.object.convert.CourseChapterAuditMapStruct;
import io.xxnjdg.notp.course.admin.object.convert.CourseChapterPeriodAuditMapStruct;
import io.xxnjdg.notp.course.admin.object.convert.CourseIntroduceAuditMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseIntroduceAuditDTO;
import io.xxnjdg.notp.course.admin.object.error.CourseAuditEnum;
import io.xxnjdg.notp.course.admin.service.*;
import io.xxnjdg.notp.course.mapper.CourseAuditMapper;
import io.xxnjdg.notp.course.object.persistent.*;
import io.xxnjdg.notp.user.apis.LecturerControllerApi;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import io.xxnjdg.notp.utils.constant.AuditStatus;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 23:19
 */
@Service
public class CourseAuditAdminServiceImpl extends ServiceImpl<CourseAuditMapper, CourseAudit> implements CourseAuditAdminService {

    @Autowired
    private CourseIntroduceAuditAdminService courseIntroduceAuditAdminService;

    @Autowired
    private CourseCategoryAdminService courseCategoryAdminService;

    @Autowired
    private CourseAdminService courseAdminService;

    @Autowired
    private CourseChapterPeriodAuditAdminService courseChapterPeriodAuditAdminService;

    @Autowired
    private CourseChapterPeriodAdminService courseChapterPeriodAdminService;

    @Autowired
    private CourseIntroduceAdminService courseIntroduceAdminService;

    @Autowired
    private CourseChapterAdminService courseChapterAdminService;

    @Autowired
    private CourseChapterAuditAdminService courseChapterAuditAdminService;

    // TODO: 2020/5/23 偷懒，直接用了门户的接口
    @Autowired
    private LecturerControllerApi lecturerControllerApi;

    @Override
    public PageResult<CourseAuditBO> listCourseAuditByPage(CourseAuditDTO courseAuditDTO) {
        PageResult<CourseAuditBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<CourseAudit> wrapper = new QueryWrapper<CourseAudit>()
                .lambda();

        Integer statusId = courseAuditDTO.getStatusId();
        Integer isPutaway = courseAuditDTO.getIsPutaway();
        Integer auditStatus = courseAuditDTO.getAuditStatus();
        Integer isFree = courseAuditDTO.getIsFree();
        String courseName = null;

        if (StrUtil.isNotBlank(courseAuditDTO.getCourseName())) {
            courseName = courseAuditDTO.getCourseName();
            wrapper.like(CourseAudit::getCourseName, courseName);
        }

        if (statusId != null) {
            wrapper.eq(CourseAudit::getStatusId, statusId);
        }

        if (isPutaway != null) {
            wrapper.eq(CourseAudit::getIsPutaway, isPutaway);
        }

        if (isFree != null) {
            wrapper.eq(CourseAudit::getIsFree, isFree);
        }

        if (auditStatus != null) {
            wrapper.eq(CourseAudit::getAuditStatus, auditStatus);
        } else {
            wrapper.ne(CourseAudit::getAuditStatus, AuditStatus.PASS);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                courseAuditDTO.getPageCurrent(), courseAuditDTO.getPageSize(), count);

        //查询
        List<CourseAudit> courseAuditList =
                this.baseMapper.listCourseAuditAdminByPage(statusId, isPutaway, auditStatus, isFree, courseName, pageObject.getOffset(), pageObject.getSize());

        List<CourseAuditBO> courseAuditBOList = CourseAuditMapStruct.INSTANCE.P2B(courseAuditList);

        List<CourseCategoryBO> courseCategoryBOList = courseCategoryAdminService.listCourseCategory();

        for (CourseAuditBO courseAuditBO : courseAuditBOList) {
            if (CollUtil.isNotEmpty(courseCategoryBOList)) {
                courseAuditBO.setCategoryName1(getCategoryName(courseCategoryBOList, courseAuditBO.getCategoryId1()));
                courseAuditBO.setCategoryName2(getCategoryName(courseCategoryBOList, courseAuditBO.getCategoryId2()));
                courseAuditBO.setCategoryName3(getCategoryName(courseCategoryBOList, courseAuditBO.getCategoryId3()));
            }
        }

        return result
                .setCurrentList(courseAuditBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) courseAuditList.size());
    }

    @Override
    @Transactional
    public Boolean updateCourseAudit(CourseAuditDTO courseAuditDTO) {

        CourseAudit courseAudit = this.getById(courseAuditDTO.getId());
        if (courseAudit == null) {
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }

        Integer isFree = courseAuditDTO.getIsFree();
        if (isFree != null) {
            if (ObjectUtil.equal(isFree, 1)) {
                courseAuditDTO.setCourseOriginal("0");
                courseAuditDTO.setCourseDiscount("0");
            }

            // 如果课程收费，价格不能为空
            if (ObjectUtil.equal(isFree, 0) && courseAuditDTO.getCourseOriginal() == null) {
                throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
            }
        } else {
            if (ObjectUtil.equal(courseAudit.getIsFree(), 1)) {
                courseAuditDTO.setCourseOriginal("0");
                courseAuditDTO.setCourseDiscount("0");
            }
        }

        List<CourseCategoryBO> courseCategoryBOList = courseCategoryAdminService.listCourseCategory();

        if (CollUtil.isNotEmpty(courseCategoryBOList)) {
            verifyCategory(courseCategoryBOList, courseAuditDTO.getCategoryId1(), 1);
            verifyCategory(courseCategoryBOList, courseAuditDTO.getCategoryId2(), 2);
            verifyCategory(courseCategoryBOList, courseAuditDTO.getCategoryId3(), 3);
        }

        if (StrUtil.isNotBlank(courseAuditDTO.getIntroduce())) {
            courseIntroduceAuditAdminService.updateCourseIntroduceAuditById(
                    new CourseIntroduceAuditDTO()
                            .setId(courseAudit.getIntroduceId())
                            .setIntroduce(courseAuditDTO.getIntroduce()));
        }

        courseAuditDTO.setAuditStatus(AuditStatus.PENDING_APPROVAL);

        boolean update = this.updateById(CourseAuditMapStruct.INSTANCE.DT2P(courseAuditDTO));
        if (!update) {
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }

        return true;
    }

    @Override
    public Boolean updateCourseAuditById(CourseAuditDTO courseAuditDTO) {
        CourseAudit courseAudit = CourseAuditMapStruct.INSTANCE.DT2P(courseAuditDTO);
        boolean update = this.updateById(courseAudit);
        if (!update) {
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public CourseAuditBO getCourseAuditById(CourseAuditDTO courseAuditDTO) {
        CourseAudit courseAudit = this.getById(courseAuditDTO.getId());
        if (courseAudit == null) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }
        CourseAuditBO courseAuditBO = CourseAuditMapStruct.INSTANCE.P2B(courseAudit);

        //查询分类名字
        List<CourseCategoryBO> courseCategoryBOList = courseCategoryAdminService.listCourseCategory();

        if (CollUtil.isNotEmpty(courseCategoryBOList)) {
            courseAuditBO.setCategoryName1(getCategoryName(courseCategoryBOList, courseAuditBO.getCategoryId1()));
            courseAuditBO.setCategoryName2(getCategoryName(courseCategoryBOList, courseAuditBO.getCategoryId2()));
            courseAuditBO.setCategoryName3(getCategoryName(courseCategoryBOList, courseAuditBO.getCategoryId3()));
        }

        //课程简介
        CourseIntroduceAudit courseIntroduceAudit = courseIntroduceAuditAdminService
                .getById(courseAuditBO.getIntroduceId());
        if (courseIntroduceAudit == null) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }
        courseAuditBO.setIntroduce(courseIntroduceAudit.getIntroduce());

        //授课老师
        ResponseResult<LecturerVO> lecturerByLecturerUserNo = lecturerControllerApi
                .getLecturerByLecturerUserNo(courseAuditBO.getLecturerUserNo());


        if (!ObjectUtil.equal(lecturerByLecturerUserNo.getStatus(), HttpStatus.SUCCESS.getStatus())
                || lecturerByLecturerUserNo.getData() == null){
            throw new BaseException(lecturerByLecturerUserNo.getStatus(),lecturerByLecturerUserNo.getStatusText());
        }
        //设置老师名字
        courseAuditBO.setLecturerName(
                lecturerByLecturerUserNo.getData().getLecturerName());

        //课程章节列表
        List<CourseChapterAudit> courseChapterAuditList = courseChapterAuditAdminService
                .listCourseChapterAuditByCourseId(courseAuditBO.getId());

        //为空直接返回
        if (CollUtil.isEmpty(courseChapterAuditList)){
            return courseAuditBO;
        }

        List<CourseChapterAuditBO> courseChapterAuditBOList =
                CourseChapterAuditMapStruct.INSTANCE.P2B(courseChapterAuditList);

        //课程课时
        List<CourseChapterPeriodAudit> courseChapterPeriodAuditList =
                courseChapterPeriodAuditAdminService
                        .listCourseChapterPeriodAuditByCourseId(courseAuditBO.getId());

        //为空直接返回
        if (CollUtil.isEmpty(courseChapterPeriodAuditList)){
            return courseAuditBO.setCourseChapterAuditList(courseChapterAuditBOList);
        }

        List<CourseChapterPeriodAuditBO> courseChapterPeriodAuditBOList =
                CourseChapterPeriodAuditMapStruct.INSTANCE.P2B(courseChapterPeriodAuditList);

        //递归处理
        List<CourseChapterPeriodAuditBO> list = new ArrayList<>();
        for (CourseChapterAuditBO courseChapterAuditBO : courseChapterAuditBOList) {
            for (CourseChapterPeriodAuditBO courseChapterPeriodAuditBO : courseChapterPeriodAuditBOList) {
                if (ObjectUtil.equal(courseChapterAuditBO.getId(),courseChapterPeriodAuditBO.getChapterId())){
                    list.add(courseChapterPeriodAuditBO);
                }
            }

            if (CollUtil.isNotEmpty(list)){
                courseChapterAuditBO.setCourseChapterPeriodAuditList(new ArrayList<>(list));
                list.clear();
            }
        }

        return courseAuditBO.setCourseChapterAuditList(courseChapterAuditBOList);
    }

    @Override
    public CourseAudit getCourseAuditById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Boolean auditCourseAudit(CourseAuditDTO courseAuditDTO) {
        //审核不通过
        if (!ObjectUtil.equal(AuditStatus.PASS, courseAuditDTO.getAuditStatus())) {
            return this.updateCourseAuditById(courseAuditDTO);
        }

        Long id = courseAuditDTO.getId();
        //查询courseAudit
        CourseAudit courseAudit = this.getById(id);
        if (courseAudit == null) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        //courseAudit -> Course
        Course newCourse = CourseAuditMapStruct.INSTANCE.CA2C(courseAudit)
                .setGmtCreate(null)
                .setGmtModified(null)
                .setPeriodTotal(0);

        //设置setPeriodTotal
        List<CourseChapterPeriodAudit> courseChapterPeriodAuditList =
                courseChapterPeriodAuditAdminService.listCourseChapterPeriodAuditByCourseId(id);

        if (CollUtil.isNotEmpty(courseChapterPeriodAuditList)) {
            newCourse.setPeriodTotal(courseChapterPeriodAuditList.size());
        }
        //插入或更新Course
        boolean result = true;
        if (courseAdminService.getById(id) == null) {
            //插入
            result = courseAdminService.save(newCourse);
        } else {
            //更新
            result = courseAdminService.updateById(newCourse
                    .setGmtModified(LocalDateTime.now()));
        }

        //处理结果
        if (!result) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        Long introduceId = courseAudit.getIntroduceId();
        //查询 courseIntroduceAudit
        CourseIntroduceAudit courseIntroduceAudit = courseIntroduceAuditAdminService
                .getById(introduceId);

        if (courseIntroduceAudit == null) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        //CourseIntroduceAudit -> CourseIntroduce
        CourseIntroduce courseIntroduce = CourseIntroduceAuditMapStruct.INSTANCE
                .CIA2CI(courseIntroduceAudit)
                .setGmtCreate(null)
                .setGmtModified(null);

        if (courseIntroduceAdminService.getById(introduceId) == null) {
            //插入
            result = courseIntroduceAdminService.save(courseIntroduce);
        } else {
            result = courseIntroduceAdminService.updateById(courseIntroduce
                    .setGmtModified(LocalDateTime.now()));
        }
        //处理结果
        if (!result) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        chapter(id);
        period(courseChapterPeriodAuditList);

        boolean update = this.updateById(new CourseAudit()
                .setId(id).setAuditStatus(AuditStatus.PASS));

        //处理结果
        if (!update) {
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        return true;
    }

    private void period(List<CourseChapterPeriodAudit> courseChapterPeriodAuditList) {
        if (CollUtil.isEmpty(courseChapterPeriodAuditList)) {
            return;
        }

        for (CourseChapterPeriodAudit courseChapterPeriodAudit : courseChapterPeriodAuditList) {

            CourseChapterPeriod courseChapterPeriod =
                    CourseChapterPeriodAuditMapStruct.INSTANCE.A2NA(courseChapterPeriodAudit)
                            .setGmtCreate(null)
                            .setGmtModified(null);

            boolean result = true;
            if (courseChapterPeriodAdminService.getById(courseChapterPeriodAudit.getId()) == null) {
                result = courseChapterPeriodAdminService.save(courseChapterPeriod);
            } else {
                // TODO: 2020/5/22 IsDoc没有删除
                result = courseChapterPeriodAdminService.updateById(courseChapterPeriod
                        .setGmtModified(LocalDateTime.now()));
            }

            if (!result) {
                throw new BaseException(CourseAuditEnum.GET_ERROR);
            }

            boolean update = courseChapterPeriodAuditAdminService.updateById(
                    new CourseChapterPeriodAudit()
                            .setId(courseChapterPeriodAudit.getId())
                            .setAuditStatus(AuditStatus.PASS));

            if (!update) {
                throw new BaseException(CourseAuditEnum.GET_ERROR);
            }
        }
    }

    private void chapter(Long id) {
        List<CourseChapterAudit> courseChapterAuditList = courseChapterAuditAdminService
                .listCourseChapterAuditByCourseId(id);

        if (CollUtil.isEmpty(courseChapterAuditList)) {
            return;
        }

        boolean result = true;
        for (CourseChapterAudit courseChapterAudit : courseChapterAuditList) {
            CourseChapter courseChapter = CourseChapterAuditMapStruct.INSTANCE.CCA2CC(courseChapterAudit)
                    .setGmtCreate(null)
                    .setGmtModified(null);


            if (courseChapterAdminService.getById(courseChapterAudit.getId()) == null) {
                result = courseChapterAdminService.save(courseChapter);
            } else {
                result = courseChapterAdminService.updateById(courseChapter
                        .setGmtModified(LocalDateTime.now()));
            }

            if (!result) {
                throw new BaseException(CourseAuditEnum.GET_ERROR);
            }


            boolean update = courseChapterAuditAdminService.updateById(
                    new CourseChapterAudit()
                            .setId(courseChapterAudit.getId())
                            .setAuditStatus(AuditStatus.PASS));

            if (!update) {
                throw new BaseException(CourseAuditEnum.GET_ERROR);
            }
        }

    }

    private void verifyCategory(List<CourseCategoryBO> courseCategoryBOList, Long categoryId, Integer floor) {
        if (categoryId != null &&
                categoryId != 0L &&
                !ObjectUtil.equal(this.getFloor(courseCategoryBOList, categoryId), floor)) {
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }
    }

    private String getCategoryName(List<CourseCategoryBO> courseCategoryBOList, Long categoryId) {
        if (categoryId != null && categoryId != 0L) {
            for (CourseCategoryBO courseCategoryBO : courseCategoryBOList) {
                if (ObjectUtil.equal(courseCategoryBO.getId(), categoryId)) {
                    return courseCategoryBO.getCategoryName();
                }
            }
        }
        return null;
    }

    private Integer getFloor(List<CourseCategoryBO> courseCategoryBOList, Long categoryId) {
        for (CourseCategoryBO courseCategoryBO : courseCategoryBOList) {
            if (ObjectUtil.equal(courseCategoryBO.getId(), categoryId)) {
                return courseCategoryBO.getFloor();
            }
        }
        return null;
    }
}
