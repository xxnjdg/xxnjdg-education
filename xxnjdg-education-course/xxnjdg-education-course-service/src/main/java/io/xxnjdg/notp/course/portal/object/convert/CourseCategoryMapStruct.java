package io.xxnjdg.notp.course.portal.object.convert;


import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.course.portal.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.portal.object.view.course.category.CourseCategoryPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 19:01
 */
@Mapper
public interface CourseCategoryMapStruct {
    CourseCategoryMapStruct INSTANCE = Mappers.getMapper(CourseCategoryMapStruct.class);

    /**
     * P2B
     *
     * @param p
     * @return
     */
    CourseCategoryBO P2B(CourseCategory p);

    /**
     * P2B
     *
     * @param pl
     * @return
     */
    List<CourseCategoryBO> P2B(List<CourseCategory> pl);

    /**
     * B2V
     *
     * @param b
     * @return
     */
    CourseCategoryPageVO B2PV(CourseCategoryBO b);


    /**
     * B2V
     *
     * @param bl
     * @return
     */
    List<CourseCategoryPageVO> B2PV(List<CourseCategoryBO> bl);
}