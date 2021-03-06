package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 23:18
 */
public interface CourseAuditAdminService extends IService<CourseAudit> {
    /**
     * 分頁查询CourseAudit列表
     * @param courseAuditDTO
     * @return
     */
    PageResult<CourseAuditBO> listCourseAuditByPage(CourseAuditDTO courseAuditDTO);

    /**
     * 更新
     * @param courseAuditDTO
     * @return
     */
    Boolean updateCourseAudit(CourseAuditDTO courseAuditDTO);

    /**
     * 更新
     * @param courseAuditDTO
     * @return
     */
    Boolean updateCourseAuditById(CourseAuditDTO courseAuditDTO);

    /**
     * 查询
     * @param courseAuditDTO
     * @return
     */
    CourseAuditBO getCourseAuditById(CourseAuditDTO courseAuditDTO);


    /**
     * 查询
     * @param id
     * @return
     */
    CourseAudit getCourseAuditById(Long id);

    /**
     * 审核
     * @param courseAuditDTO
     * @return
     */
    Boolean auditCourseAudit(CourseAuditDTO courseAuditDTO);
}
