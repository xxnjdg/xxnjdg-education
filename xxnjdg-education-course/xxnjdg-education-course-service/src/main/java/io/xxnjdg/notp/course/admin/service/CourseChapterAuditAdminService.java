package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 21:11
 */
public interface CourseChapterAuditAdminService extends IService<CourseChapterAudit> {

    /**
     * 查询
     * @param courseId
     * @return
     */
    List<CourseChapterAudit> listCourseChapterAuditByCourseId(Long courseId);
}
