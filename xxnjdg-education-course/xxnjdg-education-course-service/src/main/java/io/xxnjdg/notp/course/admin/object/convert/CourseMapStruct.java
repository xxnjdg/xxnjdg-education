package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseDTO;
import io.xxnjdg.notp.course.object.persistent.Adv;
import io.xxnjdg.notp.course.object.persistent.Course;
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
     * @param advBO
     * @return
     */
//    AdvPageVO B2PV(AdvBO advBO);

    /**
     * B2V
     * @param advBO
     * @return
     */
//    AdvVO B2V(AdvBO advBO);

    /**
     * B2V
     * @param advBOList
     * @return
     */
//    List<AdvPageVO> B2PV(List<AdvBO> advBOList);

    /**
     * B2V
     * @param result
     * @return
     */
//    PageResult<AdvPageVO> B2PV(PageResult<AdvBO> result);
}