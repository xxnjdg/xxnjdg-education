package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseChapterPeriodBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriod;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课时信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseChapterPeriodService extends IService<CourseChapterPeriod> {

    /**
     * 通过 chapterId 获取 CourseChapterPeriod
     * @param chapterId chapterId
     * @return CourseChapterPeriodBO
     */
    List<CourseChapterPeriodBO> listCourseChapterPeriodByChapterId(Long chapterId);

}
