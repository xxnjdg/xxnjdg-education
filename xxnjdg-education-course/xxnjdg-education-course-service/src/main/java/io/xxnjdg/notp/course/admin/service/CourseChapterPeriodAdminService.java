package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriod;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 21:16
 */
public interface CourseChapterPeriodAdminService extends IService<CourseChapterPeriod> {
    /**
     * 列表
     * @param courseId
     * @return
     */
    List<CourseChapterPeriod> listCourseChapterPeriodByCourseId(Long courseId);
}
