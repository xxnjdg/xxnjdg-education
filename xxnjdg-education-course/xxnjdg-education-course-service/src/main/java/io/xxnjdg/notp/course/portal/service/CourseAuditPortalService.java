package io.xxnjdg.notp.course.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.course.portal.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.autdit.*;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 4:05
 */
public interface CourseAuditPortalService extends IService<CourseAudit> {
    /**
     * 分页列表查询
     * @param courseAuditPageDTO
     * @return
     */
    PageResult<CourseAuditBO> listCourseAuditByPage(CourseAuditPageDTO courseAuditPageDTO);

    /**
     * 查询
     * @param courseAuditViewDTO
     * @return
     */
    CourseAuditBO getCourseAudit(CourseAuditViewDTO courseAuditViewDTO);

    /**
     * 插入
     * @param courseAuditSaveDTO
     * @return
     */
    CourseAuditBO saveCourseAudit(CourseAuditSaveDTO courseAuditSaveDTO);

    /**
     * 更新
     * @param courseAuditUpdateDTO
     * @return
     */
    Boolean updateCourseAudit(CourseAuditUpdateDTO courseAuditUpdateDTO);

    /**
     * 更新
     * @param courseAuditPutawayDTO
     * @return
     */
    Boolean updateCourseAuditByPutaway(CourseAuditPutawayDTO courseAuditPutawayDTO);

    /**
     * 删除
     * @param courseAuditDeleteDTO
     * @return
     */
    Boolean deleteCourseAudit(CourseAuditDeleteDTO courseAuditDeleteDTO);


    /**
     * 查询老师是否有权力crud课程
     * @param id
     * @param lecturerUserNo
     * @return
     */
    CourseAudit checkIdAndLecturer(Long id, Long lecturerUserNo);

    /**
     * 更新
     * @param courseAudit
     * @return
     */
    boolean updateCourseAudit(CourseAudit courseAudit);
}
