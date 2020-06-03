package io.xxnjdg.notp.course.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import io.xxnjdg.notp.course.portal.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.audit.*;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 16:03
 */
public interface CourseChapterAuditPortalService extends IService<CourseChapterAudit> {

    /**
     * 删除
     * @param courseId
     * @return
     */
    Boolean deleteCourseChapterAuditByCourseId(Long courseId);

    /**
     * 查询
     * @param courseId
     * @return
     */
    List<CourseChapterAudit> listCourseChapterAuditByCourseId(Long courseId);

    /**
     * 查询列表
     * @param courseChapterAuditPageDTO
     * @return
     */
    List<CourseChapterAuditBO> listCourseChapterAudit(CourseChapterAuditPageDTO courseChapterAuditPageDTO);

    /**
     * 插入
     * @param courseChapterAuditSaveDTO
     * @return
     */
    CourseChapterAuditBO saveCourseChapterAudit(CourseChapterAuditSaveDTO courseChapterAuditSaveDTO);

    /**
     * 更新
     * @param courseChapterAuditUpdateDTO
     * @return
     */
    CourseChapterAuditBO updateCourseChapterAudit(CourseChapterAuditUpdateDTO courseChapterAuditUpdateDTO);

    /**
     * 删除
     * @param courseChapterAuditDeleteDTO
     * @return
     */
    Boolean deleteCourseChapterAudit(CourseChapterAuditDeleteDTO courseChapterAuditDeleteDTO);

    /**
     * 更新
     * @param setUserNo
     * @return
     */
    Boolean sortCourseChapterAudit(CourseChapterAuditSortDTO setUserNo);

    /**
     * 查询
     * @param id
     * @return
     */
    CourseChapterAudit getCourseChapterAuditById(Long id);

    /**
     * 更新
     * @param courseChapterAudit
     * @return
     */
    boolean updateCourseChapterAudit(CourseChapterAudit courseChapterAudit);
}
