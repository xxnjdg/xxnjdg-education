package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseChapterBO;
import io.xxnjdg.notp.course.object.business.CourseChapterPeriodBO;
import io.xxnjdg.notp.course.object.business.CourseDetailBO;
import io.xxnjdg.notp.course.object.view.CourseChapterLevelVO;
import io.xxnjdg.notp.course.object.view.CourseChapterPeriodVO;
import io.xxnjdg.notp.course.object.view.CourseDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 上午3:27
 */
@Mapper
public interface CourseDetailBOToVO {
    CourseDetailBOToVO INSTANCE = Mappers.getMapper(CourseDetailBOToVO.class);

    /**
     * 转换
     * @param course course
     * @return  CourseBO
     */
    CourseDetailVO convert(CourseDetailBO course);

    List<CourseChapterLevelVO> convertCourseChapterLevelVO(List<CourseChapterBO> chapterList);

    List<CourseChapterPeriodVO> convertCourseChapterPeriodVO(List<CourseChapterPeriodBO> courseChapterPeriodVO);
}