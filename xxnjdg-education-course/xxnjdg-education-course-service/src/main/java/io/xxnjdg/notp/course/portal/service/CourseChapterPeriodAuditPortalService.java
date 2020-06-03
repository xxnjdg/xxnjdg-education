package io.xxnjdg.notp.course.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import io.xxnjdg.notp.course.portal.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditDeleteDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditPageDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditSaveDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditUpdateDTO;

import java.util.Collection;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 16:06
 */
public interface CourseChapterPeriodAuditPortalService extends IService<CourseChapterPeriodAudit> {

    /**
     * 删除
     * @param courseId
     * @return
     */
    Boolean deleteCourseChapterPeriodAuditByCourseId(Long courseId);

    /**
     * 查询
     * @param courseId
     * @return
     */
    List<CourseChapterPeriodAudit> listCourseChapterPeriodAuditByCourseId(Long courseId);

    /**
     * 查询
     * @param chapterIds
     * @return
     */
    List<CourseChapterPeriodAudit> listCourseChapterPeriodAuditByChapterIds(Collection<Long> chapterIds);

    /**
     * 查询
     * @param courseChapterPeriodAuditPageDTO
     * @return
     */
    List<CourseChapterPeriodAuditBO> listCourseChapterPeriodAudit(CourseChapterPeriodAuditPageDTO courseChapterPeriodAuditPageDTO);

    /**
     * 插入
     * @param courseChapterPeriodAuditSaveDTO
     * @return
     */
    CourseChapterPeriodAuditBO saveCourseChapterPeriodAudit(CourseChapterPeriodAuditSaveDTO courseChapterPeriodAuditSaveDTO);

    /**
     * 更新
     * @param courseChapterPeriodAuditUpdateDTO
     * @return
     */
    Boolean updateCourseChapterPeriodAudit(CourseChapterPeriodAuditUpdateDTO courseChapterPeriodAuditUpdateDTO);

    /**
     * 删除
     * @param courseChapterPeriodAuditDeleteDTO
     * @return
     */
    Boolean deleteCourseChapterPeriodAudit(CourseChapterPeriodAuditDeleteDTO courseChapterPeriodAuditDeleteDTO);
}
