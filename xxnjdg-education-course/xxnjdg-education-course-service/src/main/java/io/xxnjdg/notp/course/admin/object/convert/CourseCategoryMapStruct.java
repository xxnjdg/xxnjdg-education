package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 17:51
 */
@Mapper
public interface CourseCategoryMapStruct {
    CourseCategoryMapStruct INSTANCE = Mappers.getMapper(CourseCategoryMapStruct.class);

    /**
     * P2B
     * @param advDTO
     * @return
     */
//    Adv DTO2P(AdvDTO advDTO);

    /**
     * P2B
     * @param courseCategory
     * @return
     */
    CourseCategoryBO P2B(CourseCategory courseCategory);


    /**
     * P2B
     * @param courseCategoryList
     * @return
     */
    List<CourseCategoryBO> P2B(List<CourseCategory> courseCategoryList);

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