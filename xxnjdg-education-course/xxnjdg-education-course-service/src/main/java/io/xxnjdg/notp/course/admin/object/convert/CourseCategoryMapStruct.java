package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseCategoryDTO;
import io.xxnjdg.notp.course.admin.object.view.CourseCategoryPageVO;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.utils.response.PageResult;
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
     * @param courseCategoryDTO
     * @return
     */
    CourseCategory DT2P(CourseCategoryDTO courseCategoryDTO);

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
     * @param courseCategoryBO
     * @return
     */
    CourseCategoryPageVO B2PV(CourseCategoryBO courseCategoryBO);

    /**
     * B2V
     * @param CourseCategoryBO
     * @return
     */
//    AdvVO B2V(CourseCategoryBO CourseCategoryBO);

    /**
     * B2V
     * @param courseCategoryBOList
     * @return
     */
    List<CourseCategoryPageVO> B2PV(List<CourseCategoryBO> courseCategoryBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<CourseCategoryPageVO> B2PV(PageResult<CourseCategoryBO> result);
}