package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseAuditMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.admin.service.CourseAuditAdminService;
import io.xxnjdg.notp.course.admin.service.CourseCategoryAdminService;
import io.xxnjdg.notp.course.mapper.CourseAuditMapper;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.utils.constant.AuditStatus;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 23:19
 */
@Service
public class CourseAuditAdminServiceImpl extends ServiceImpl<CourseAuditMapper, CourseAudit> implements CourseAuditAdminService {

    @Autowired
    private CourseCategoryAdminService courseCategoryAdminService;

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

        if (StrUtil.isNotBlank(courseAuditDTO.getCourseName())){
            courseName = courseAuditDTO.getCourseName();
            wrapper.like(CourseAudit::getCourseName,courseName);
        }

        if (statusId!=null){
            wrapper.eq(CourseAudit::getStatusId,statusId);
        }

        if (isPutaway!=null){
            wrapper.eq(CourseAudit::getIsPutaway,isPutaway);
        }

        if (isFree!=null){
            wrapper.eq(CourseAudit::getIsFree,isFree);
        }

        if (auditStatus!=null){
            wrapper.eq(CourseAudit::getAuditStatus,auditStatus);
        }else {
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
                this.baseMapper.listCourseAuditAdminByPage(statusId, isPutaway,auditStatus,isFree,courseName, pageObject.getOffset(), pageObject.getSize());

        List<CourseAuditBO> courseAuditBOList = CourseAuditMapStruct.INSTANCE.P2B(courseAuditList);

        List<CourseCategoryBO> courseCategoryBOList = courseCategoryAdminService.listCourseCategory();

        for (CourseAuditBO courseAuditBO : courseAuditBOList) {
            if (CollUtil.isNotEmpty(courseCategoryBOList)){
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
