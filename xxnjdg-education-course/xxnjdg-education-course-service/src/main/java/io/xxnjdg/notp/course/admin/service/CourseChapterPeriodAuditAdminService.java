package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 18:56
 */
public interface CourseChapterPeriodAuditAdminService extends IService<CourseChapterPeriodAudit> {
    /**
     * 列表
     * @param courseId
     * @return
     */
    List<CourseChapterPeriodAudit> listCourseChapterPeriodAuditByCourseId(Long courseId);
}
