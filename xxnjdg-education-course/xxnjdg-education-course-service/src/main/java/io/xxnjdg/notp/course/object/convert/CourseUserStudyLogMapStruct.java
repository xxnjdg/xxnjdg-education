package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseUserStudyLogBO;
import io.xxnjdg.notp.course.object.persistent.CourseUserStudyLog;
import io.xxnjdg.notp.course.object.view.ListCourseUserStudyLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 下午5:38
 */
@Mapper
public interface CourseUserStudyLogMapStruct {
    CourseUserStudyLogMapStruct INSTANCE = Mappers.getMapper(CourseUserStudyLogMapStruct.class);

    /**
     * 转换
     * @param courseUserStudyLogs
     * @return
     */
    List<CourseUserStudyLogBO> convertD2B(List<CourseUserStudyLog> courseUserStudyLogs);

    List<ListCourseUserStudyLogVO> convertB2V(List<CourseUserStudyLogBO> courseUserStudyLogs);
}