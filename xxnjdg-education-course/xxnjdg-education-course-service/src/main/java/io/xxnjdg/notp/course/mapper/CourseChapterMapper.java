package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.persistent.CourseChapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.course.object.view.CourseChapterLevelVO;

import java.util.List;

/**
 * <p>
 * 章节信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseChapterMapper extends BaseMapper<CourseChapter> {

    /**
     * 使用courseId 查找CourseChapterLevelVO列表
     * @param courseId courseId
     * @return CourseChapterLevelVO
     */
    List<CourseChapterLevelVO> queryCourseChapterLevelListByCourseId(Long courseId);
}
