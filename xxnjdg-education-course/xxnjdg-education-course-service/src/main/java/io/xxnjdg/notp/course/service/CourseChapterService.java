package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseChapterBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.view.CourseChapterLevelVO;

import java.util.List;

/**
 * <p>
 * 章节信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseChapterService extends IService<CourseChapter> {


    /**
     * 使用courseId 查找CourseChapterLevelVO列表
     * @param courseId courseId
     * @return CourseChapterLevelVO
     */
    List<CourseChapterLevelVO> queryCourseChapterLevelListByCourseId(Long courseId);

    /**
     * 使用 courseId 查询 CourseChapterBO 列表
     * @param courseId courseId
     * @return
     */
    List<CourseChapterBO> listCourseChapterByCourseId(Long courseId);

}
