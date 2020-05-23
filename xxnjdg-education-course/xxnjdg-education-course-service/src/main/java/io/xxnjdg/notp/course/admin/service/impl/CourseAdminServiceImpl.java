package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.CourseBO;
import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.business.CourseChapterBO;
import io.xxnjdg.notp.course.admin.object.business.CourseChapterPeriodBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseChapterMapStruct;
import io.xxnjdg.notp.course.admin.object.convert.CourseChapterPeriodMapStruct;
import io.xxnjdg.notp.course.admin.object.convert.CourseMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseDTO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseIntroduceAuditDTO;
import io.xxnjdg.notp.course.admin.object.error.CourseEnum;
import io.xxnjdg.notp.course.admin.service.*;
import io.xxnjdg.notp.course.mapper.CourseMapper;
import io.xxnjdg.notp.course.object.persistent.*;
import io.xxnjdg.notp.user.admin.api.LecturerAdminControllerApi;
import io.xxnjdg.notp.user.admin.object.view.LecturerVO;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 16:23
 */
@Service
public class CourseAdminServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseAdminService {

    @Autowired
    private CourseCategoryAdminService courseCategoryAdminService;

    @Autowired
    private LecturerAdminControllerApi lecturerAdminControllerApi;

    @Autowired
    private ZoneCourseAdminService zoneCourseAdminService;

    @Autowired
    private CourseAuditAdminService courseAuditAdminService;

    @Autowired
    private CourseIntroduceAuditAdminService courseIntroduceAuditAdminService;

    @Autowired
    private CourseIntroduceAdminService courseIntroduceAdminService;

    @Autowired
    private CourseChapterPeriodAdminService courseChapterPeriodAdminService;

    @Autowired
    private CourseChapterAdminService courseChapterAdminService;

    @Override
    public List<CourseBO> getCourseByCourseName(CourseDTO courseDTO) {
        LambdaQueryWrapper<Course> wrapper = new QueryWrapper<Course>()
                .lambda()
                .like(Course::getCourseName, courseDTO.getCourseName());

        return CourseMapStruct.INSTANCE.P2B(this.list(wrapper));
    }

    @Override
    public CourseBO getCourseById(CourseDTO courseDTO) {
        Course course = this.getById(courseDTO.getId());
        if (course == null){
            throw new BaseException(CourseEnum.GET_ERROR);
        }
        return CourseMapStruct.INSTANCE.P2B(course);
    }

    @Override
    public List<CourseBO> getCourseByMap(CourseDTO courseDTO) {
        Course course = CourseMapStruct.INSTANCE.DT2P(courseDTO);
        Map<String, Object> map = BeanUtil.beanToMap(course, true, true);
        List<Course> courses = this.baseMapper.selectByMap(map);
        if (CollUtil.isEmpty(courses)){
            throw new BaseException(CourseEnum.GET_ERROR);
        }
        return CourseMapStruct.INSTANCE.P2B(courses);
    }

    @Override
    public PageResult<CourseBO> listCourseByPage(CourseDTO courseDTO) {

        PageResult<CourseBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<Course> wrapper = new QueryWrapper<Course>()
                .lambda();

        Integer statusId = courseDTO.getStatusId();
        Integer isPutaway = courseDTO.getIsPutaway();
        Integer isFree = courseDTO.getIsFree();
        Long categoryId1 = courseDTO.getCategoryId1();

        String courseName = null;


        if (statusId != null) {
            wrapper.eq(Course::getStatusId, statusId);
        }

        if (isPutaway != null) {
            wrapper.eq(Course::getIsPutaway, isPutaway);
        }

        if (isFree != null) {
            wrapper.eq(Course::getIsFree, isFree);
        }

        if (categoryId1 != null) {
            wrapper.eq(Course::getCategoryId1, categoryId1);
        }

        if (StrUtil.isNotBlank(courseDTO.getCourseName())) {
            courseName = courseDTO.getCourseName();
            wrapper.like(Course::getCourseName, courseName);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                courseDTO.getPageCurrent(), courseDTO.getPageSize(), count);

        //查询分类
        List<Course> courseList =
                this.baseMapper.listCourseByPage(statusId, isPutaway, categoryId1, isFree, courseName, pageObject.getOffset(), pageObject.getSize());

        List<CourseBO> courseBOList = CourseMapStruct.INSTANCE.P2B(courseList);

        List<CourseCategoryBO> courseCategoryBOList = courseCategoryAdminService.listCourseCategory();

        Set<Long> lecturerIds = courseBOList.stream().map(CourseBO::getLecturerUserNo).collect(Collectors.toSet());

        //查询老师
        ResponseResult<List<LecturerVO>> lecturerListResult = lecturerAdminControllerApi.getLecturerByIds(lecturerIds);

        if (!ObjectUtil.equal(lecturerListResult.getStatus(), HttpStatus.SUCCESS.getStatus())
                || CollUtil.isEmpty(lecturerListResult.getData())){
            throw new BaseException(lecturerListResult.getStatus(),lecturerListResult.getStatusText());
        }

        List<LecturerVO> lecturerList = lecturerListResult.getData();

        List<ZoneCourse> zoneCourseList = null;
        if (courseDTO.getZoneId()!=null) {
            Set<Long> courseIds = courseBOList.stream().map(CourseBO::getId).collect(Collectors.toSet());
            zoneCourseList = zoneCourseAdminService
                    .listZoneCourseByCourseIdsAndZoneId(courseDTO.getZoneId(), courseIds);
        }

        for (CourseBO courseBO : courseBOList) {

            if (CollUtil.isNotEmpty(zoneCourseList)) {
                for (ZoneCourse zoneCourse : zoneCourseList) {
                    if (ObjectUtil.equal(zoneCourse.getCourseId(),courseBO.getId())){
                        courseBO.setIsAddZoneCourse(1);
                    }
                }
            }

            //设置老师名字
            for (LecturerVO lecturerVO : lecturerList) {
                if (ObjectUtil.equal(courseBO.getLecturerUserNo(),lecturerVO.getId())){
                    courseBO.setLecturerName(lecturerVO.getLecturerName());
                }
            }

            //设置分类名
            if (CollUtil.isNotEmpty(courseCategoryBOList)) {
                courseBO.setCategoryName1(getCategoryName(courseCategoryBOList, courseBO.getCategoryId1()));
                courseBO.setCategoryName2(getCategoryName(courseCategoryBOList, courseBO.getCategoryId2()));
                courseBO.setCategoryName3(getCategoryName(courseCategoryBOList, courseBO.getCategoryId3()));
            }
        }

        return result
                .setCurrentList(courseBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) courseList.size());
    }

    @Override
    @Transactional
    public Boolean updateCourse(CourseDTO courseDTO) {

        Course course = this.getById(courseDTO.getId());
        if (course == null) {
            throw new BaseException(CourseEnum.UPDATE_ERROR);
        }

        Integer isFree = courseDTO.getIsFree();
        if (isFree != null) {
            if (ObjectUtil.equal(isFree, 1)) {
                courseDTO.setCourseOriginal("0");
                courseDTO.setCourseDiscount("0");
            }

            // 如果课程收费，价格不能为空
            if (ObjectUtil.equal(isFree, 0) && courseDTO.getCourseOriginal() == null) {
                throw new BaseException(CourseEnum.UPDATE_ERROR);
            }
        } else {
            if (ObjectUtil.equal(courseDTO.getIsFree(), 1)) {
                courseDTO.setCourseOriginal("0");
                courseDTO.setCourseDiscount("0");
            }
        }

        List<CourseCategoryBO> courseCategoryBOList = courseCategoryAdminService.listCourseCategory();

        if (CollUtil.isNotEmpty(courseCategoryBOList)) {
            verifyCategory(courseCategoryBOList, courseDTO.getCategoryId1(), 1);
            verifyCategory(courseCategoryBOList, courseDTO.getCategoryId2(), 2);
            verifyCategory(courseCategoryBOList, courseDTO.getCategoryId3(), 3);
        }

        Course newCourse = CourseMapStruct.INSTANCE.DT2P(courseDTO);
        boolean update = this.updateById(newCourse);
        if (!update){
            throw new BaseException(CourseEnum.UPDATE_ERROR);
        }

        CourseAudit courseAudit = CourseMapStruct.INSTANCE.NATA(newCourse)
                .setGmtModified(LocalDateTime.now());

        update = courseAuditAdminService.updateById(courseAudit);
        if (!update){
            throw new BaseException(CourseEnum.UPDATE_ERROR);
        }

        if (StrUtil.isNotBlank(courseDTO.getIntroduce())) {

            update = courseIntroduceAdminService.updateById(
                    new CourseIntroduce()
                            .setId(course.getLecturerUserNo())
                            .setGmtModified(LocalDateTime.now())
                            .setIntroduce(courseDTO.getIntroduce()));

            if (!update){
                throw new BaseException(CourseEnum.UPDATE_ERROR);
            }

            update = courseIntroduceAuditAdminService.updateById(
                    new CourseIntroduceAudit()
                            .setId(course.getLecturerUserNo())
                            .setGmtModified(LocalDateTime.now())
                            .setIntroduce(courseDTO.getIntroduce()));

            if (!update){
                throw new BaseException(CourseEnum.UPDATE_ERROR);
            }
        }

        return true;
    }

    @Override
    public CourseBO viewCourse(CourseDTO courseDTO) {
        CourseBO courseBO = getViewCourseBO(courseDTO);

        Long id = courseBO.getId();

        //课程章节列表
        List<CourseChapter> courseChapterList =
                courseChapterAdminService.listCourseChapterByCourseId(id);

        //为空直接返回
        if (CollUtil.isEmpty(courseChapterList)){
            return courseBO;
        }

        List<CourseChapterBO> courseChapterBOList =
                CourseChapterMapStruct.INSTANCE.P2B(courseChapterList);

        //课程课时
        List<CourseChapterPeriod> courseChapterPeriodList =
                courseChapterPeriodAdminService.listCourseChapterPeriodByCourseId(id);

        //为空直接返回
        if (CollUtil.isEmpty(courseChapterPeriodList)){
            return courseBO.setCourseChapterList(courseChapterBOList);
        }

        List<CourseChapterPeriodBO> courseChapterPeriodBOList =
                CourseChapterPeriodMapStruct.INSTANCE.P2B(courseChapterPeriodList);

        //递归处理
        List<CourseChapterPeriodBO> list = new ArrayList<>();
        for (CourseChapterBO courseChapterBO : courseChapterBOList) {
            for (CourseChapterPeriodBO courseChapterPeriodBO : courseChapterPeriodBOList) {
                if (ObjectUtil.equal(courseChapterBO.getId(),courseChapterPeriodBO.getChapterId())){
                    list.add(courseChapterPeriodBO);
                }
            }

            if (CollUtil.isNotEmpty(list)){
                courseChapterBO.setCourseChapterPeriodList(new ArrayList<>(list));
                list.clear();
            }
        }

        return courseBO.setCourseChapterList(courseChapterBOList);
    }

    @Override
    public CourseBO getCourse(CourseDTO courseDTO) {

        CourseBO courseBO = getViewCourseBO(courseDTO);

        CourseIntroduce courseIntroduce =
                courseIntroduceAdminService.getById(courseBO.getIntroduceId());
        if (courseIntroduce == null) {
            throw new BaseException(CourseEnum.GET_ERROR);
        }

        return courseBO.setIntroduce(courseIntroduce.getIntroduce());
    }

    private CourseBO getViewCourseBO(CourseDTO courseDTO) {
        Course course = this.getById(courseDTO.getId());
        if (course == null) {
            throw new BaseException(CourseEnum.GET_ERROR);
        }
        CourseBO courseBO = CourseMapStruct.INSTANCE.P2B(course);

        //查询分类名字
        List<CourseCategoryBO> courseCategoryBOList = courseCategoryAdminService.listCourseCategory();

        if (CollUtil.isNotEmpty(courseCategoryBOList)) {
            courseBO.setCategoryName1(getCategoryName(courseCategoryBOList, courseBO.getCategoryId1()));
            courseBO.setCategoryName2(getCategoryName(courseCategoryBOList, courseBO.getCategoryId2()));
            courseBO.setCategoryName3(getCategoryName(courseCategoryBOList, courseBO.getCategoryId3()));
        }
        return courseBO;
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

    private void verifyCategory(List<CourseCategoryBO> courseCategoryBOList, Long categoryId, Integer floor) {
        if (categoryId != null &&
                categoryId != 0L &&
                !ObjectUtil.equal(this.getFloor(courseCategoryBOList, categoryId), floor)) {
            throw new BaseException(CourseEnum.UPDATE_ERROR);
        }
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
