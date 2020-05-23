package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.CourseChapter;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 21:14
 */
public interface CourseChapterAdminService extends IService<CourseChapter> {
    /**
     * 列表
     * @param courseId
     * @return
     */
    List<CourseChapter> listCourseChapterByCourseId(Long courseId);
}
