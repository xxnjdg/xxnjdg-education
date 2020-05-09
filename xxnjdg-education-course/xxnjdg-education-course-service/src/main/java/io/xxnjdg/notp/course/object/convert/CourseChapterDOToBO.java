package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseChapterBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午8:17
 */
@Mapper
public interface CourseChapterDOToBO {
    CourseChapterDOToBO INSTANCE = Mappers.getMapper(CourseChapterDOToBO.class);

    /**
     * 转换
     * @param courseChapters courseChapters
     * @return  List<CourseChapterBO>
     */
    List<CourseChapterBO> convert(List<CourseChapter> courseChapters);
}