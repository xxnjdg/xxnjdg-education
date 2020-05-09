package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseIntroduceBO;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduce;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午5:19
 */
@Mapper
public interface CourseIntroduceDOToBO {
    CourseIntroduceDOToBO INSTANCE = Mappers.getMapper(CourseIntroduceDOToBO.class);

    /**
     * 转换
     * @param courseIntroduce
     * @return
     */
    CourseIntroduceBO convert(CourseIntroduce courseIntroduce);
}
