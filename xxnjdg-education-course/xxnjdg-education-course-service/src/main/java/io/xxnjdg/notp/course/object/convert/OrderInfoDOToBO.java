package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午6:44
 */
@Mapper
public interface OrderInfoDOToBO {
    OrderInfoDOToBO INSTANCE = Mappers.getMapper(OrderInfoDOToBO.class);

    /**
     * 转换
     * @param course course
     * @return  CourseBO
     */
    OrderInfoBO convert(OrderInfo course);
}