package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseDTO;
import io.xxnjdg.notp.course.admin.object.view.CourseGetVO;
import io.xxnjdg.notp.course.admin.object.view.CoursePageVO;
import io.xxnjdg.notp.course.admin.object.view.CourseViewVO;
import io.xxnjdg.notp.course.object.persistent.Adv;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 16:25
 */
@Mapper
public interface CourseMapStruct {
    CourseMapStruct INSTANCE = Mappers.getMapper(CourseMapStruct.class);

    /**
     * P2B
     * @param course
     * @return
     */
    CourseAudit NATA(Course course);

    /**
     * P2B
     * @param courseDTO
     * @return
     */
    Course DT2P(CourseDTO courseDTO);

    /**
     * P2B
     * @param course
     * @return
     */
    CourseBO P2B(Course course);


    /**
     * P2B
     * @param advList
     * @return
     */
    List<CourseBO> P2B(List<Course> advList);

    /**
     * B2V
     * @param courseBO
     * @return
     */
    CoursePageVO B2PV(CourseBO courseBO);

    /**
     * B2GV
     * @param courseBO
     * @return
     */
    CourseGetVO B2GV(CourseBO courseBO);

    /**
     * B2VV
     * @param courseBO
     * @return
     */
    CourseViewVO B2VV(CourseBO courseBO);

    /**
     * B2V
     * @param courseBOList
     * @return
     */
    List<CoursePageVO> B2PV(List<CourseBO> courseBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<CoursePageVO> B2PV(PageResult<CourseBO> result);
}