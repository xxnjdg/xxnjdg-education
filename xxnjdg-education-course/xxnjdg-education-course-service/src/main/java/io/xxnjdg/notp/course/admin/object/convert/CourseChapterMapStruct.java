package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseChapterBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 20:10
 */
@Mapper
public interface CourseChapterMapStruct {
    CourseChapterMapStruct INSTANCE = Mappers.getMapper(CourseChapterMapStruct.class);


    /**
     * P2B
     * @param courseChapter
     * @return
     */
    CourseChapterBO P2B(CourseChapter courseChapter);


    /**
     * P2B
     * @param courseChapterList
     * @return
     */
    List<CourseChapterBO> P2B(List<CourseChapter> courseChapterList);
}