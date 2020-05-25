package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseUserStudyLogBO;
import io.xxnjdg.notp.course.admin.object.view.CourseUserStudyLogPageVO;
import io.xxnjdg.notp.course.object.persistent.CourseUserStudyLog;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 4:31
 */
@Mapper
public interface CourseUserStudyLogMapStruct {
    CourseUserStudyLogMapStruct INSTANCE = Mappers.getMapper(CourseUserStudyLogMapStruct.class);


    /**
     * P2B
     * @param course
     * @return
     */
    CourseUserStudyLogBO P2B(CourseUserStudyLog course);


    /**
     * P2B
     * @param advList
     * @return
     */
    List<CourseUserStudyLogBO> P2B(List<CourseUserStudyLog> advList);

    /**
     * B2V
     * @param courseBO
     * @return
     */
    CourseUserStudyLogPageVO B2PV(CourseUserStudyLogBO courseBO);


    /**
     * B2V
     * @param courseBOList
     * @return
     */
    List<CourseUserStudyLogPageVO> B2PV(List<CourseUserStudyLogBO> courseBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<CourseUserStudyLogPageVO> B2PV(PageResult<CourseUserStudyLogBO> result);
}