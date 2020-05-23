package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.CourseBO;
import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.business.ZoneCourseBO;
import io.xxnjdg.notp.course.admin.object.convert.ZoneCourseMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseDTO;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneCourseDTO;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.admin.object.error.ZoneCourseEnum;
import io.xxnjdg.notp.course.admin.service.CourseAdminService;
import io.xxnjdg.notp.course.admin.service.CourseCategoryAdminService;
import io.xxnjdg.notp.course.admin.service.ZoneAdminService;
import io.xxnjdg.notp.course.admin.service.ZoneCourseAdminService;
import io.xxnjdg.notp.course.mapper.ZoneCourseMapper;
import io.xxnjdg.notp.course.object.persistent.ZoneCourse;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 14:38
 */
@Service
public class ZoneCourseAdminServiceImpl extends ServiceImpl<ZoneCourseMapper, ZoneCourse> implements ZoneCourseAdminService {

    @Autowired
    private CourseAdminService courseAdminService;

    @Autowired
    private ZoneAdminService zoneAdminService;

    @Autowired
    private CourseCategoryAdminService courseCategoryAdminService;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public PageResult<ZoneCourseBO> listZoneCourseByPage(ZoneCourseDTO zoneCourseDTO) {
        PageResult<ZoneCourseBO> result = new PageResult<>();

        Long zoneId = zoneCourseDTO.getZoneId();

        //算总数
        LambdaQueryWrapper<ZoneCourse> wrapper = new QueryWrapper<ZoneCourse>()
                .lambda()
                .eq(ZoneCourse::getZoneId, zoneId);

        List<Long> courseIds = null;

        if (StrUtil.isNotBlank(zoneCourseDTO.getCourseName())) {
            List<CourseBO> courseBOList = courseAdminService.getCourseByCourseName(
                    new CourseDTO().setCourseName(zoneCourseDTO.getCourseName()));

            if (CollUtil.isNotEmpty(courseBOList)) {

                courseIds = courseBOList.stream().map(CourseBO::getId)
                        .collect(Collectors.toList());

                wrapper.in(ZoneCourse::getCourseId, courseIds);
            } else {
                wrapper.eq(ZoneCourse::getCourseId, 0L);
            }
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                zoneCourseDTO.getPageCurrent(), zoneCourseDTO.getPageSize(), count);

        //查询
        List<ZoneCourse> zoneCourseList =
                this.baseMapper.listZoneCourseByPage(zoneId, courseIds, pageObject.getOffset(), pageObject.getSize());

        List<ZoneCourseBO> zoneCourseBOList = ZoneCourseMapStruct.INSTANCE.P2B(zoneCourseList);

        List<CourseCategoryBO> courseCategoryBOList = courseCategoryAdminService.listCourseCategory();


        for (ZoneCourseBO zoneCourseBO : zoneCourseBOList) {
            CourseBO courseBO = null;
            try {
                courseBO = courseAdminService.getCourseById(
                        new CourseDTO().setId(zoneCourseBO.getCourseId()));
            } catch (Exception e) {
                continue;
            }

            if (CollUtil.isNotEmpty(courseCategoryBOList)){
                zoneCourseBO.setCategoryName1(getCategoryName(courseCategoryBOList, courseBO.getCategoryId1()));
                zoneCourseBO.setCategoryName2(getCategoryName(courseCategoryBOList, courseBO.getCategoryId2()));
                zoneCourseBO.setCategoryName3(getCategoryName(courseCategoryBOList, courseBO.getCategoryId3()));
            }

            zoneCourseBO.setCourseName(courseBO.getCourseName());
        }


        return result
                .setCurrentList(zoneCourseBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) zoneCourseList.size());
    }

    @Override
    public Boolean saveZoneCourse(ZoneCourseDTO zoneCourseDTO) {
        Long zoneId = zoneCourseDTO.getZoneId();
        zoneAdminService.getZoneById(new ZoneDTO()
                .setId(zoneId));

        Long courseId = zoneCourseDTO.getCourseId();
        courseAdminService.getCourseById(new CourseDTO()
                .setId(courseId));

        LambdaQueryWrapper<ZoneCourse> wrapper = new QueryWrapper<ZoneCourse>()
                .lambda()
                .eq(ZoneCourse::getZoneId, zoneId)
                .eq(ZoneCourse::getCourseId, courseId);

        ZoneCourse one = this.getOne(wrapper);
        if (one!=null){
            throw new BaseException(ZoneCourseEnum.SAVE_ERROR);
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        ZoneCourse zoneCourse = new ZoneCourse()
                .setCourseId(courseId)
                .setId(id)
                .setSort(1)
                .setZoneId(zoneId);

        boolean save = this.save(zoneCourse);
        if (!save){
            throw new BaseException(ZoneCourseEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean updateZoneCourseById(ZoneCourseDTO zoneCourseDTO) {
        ZoneCourse zoneCourse = ZoneCourseMapStruct.INSTANCE.DT2P(zoneCourseDTO);
        boolean update = this.updateById(zoneCourse);
        if (!update){
            throw new BaseException(ZoneCourseEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean deleteZoneCourseById(ZoneCourseDTO zoneCourseDTO) {
        boolean remove = this.removeById(zoneCourseDTO.getId());
        if (!remove){
            throw new BaseException(ZoneCourseEnum.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public List<ZoneCourse> listZoneCourseByCourseIdsAndZoneId(Long zoneId, Collection<Long> courseIds) {
        LambdaQueryWrapper<ZoneCourse> wrapper = new QueryWrapper<ZoneCourse>()
                .lambda()
                .eq(ZoneCourse::getZoneId, zoneId)
                .in(ZoneCourse::getCourseId, courseIds);

        return this.list(wrapper);
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


}
