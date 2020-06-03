package io.xxnjdg.notp.course.portal.object.convert;

import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.course.portal.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.portal.object.view.order.info.OrderInfoPageVO;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 20:31
 */
@Mapper
public interface OrderInfoMapStruct {
    OrderInfoMapStruct INSTANCE = Mappers.getMapper(OrderInfoMapStruct.class);

    /**
     * P2B
     *
     * @param p
     * @return
     */
    OrderInfoBO P2B(OrderInfo p);

    /**
     * P2B
     *
     * @param pl
     * @return
     */
    List<OrderInfoBO> P2B(List<OrderInfo> pl);

    /**
     * B2V
     *
     * @param b
     * @return
     */
    OrderInfoPageVO B2PV(OrderInfoBO b);


    /**
     * B2V
     *
     * @param bl
     * @return
     */
    List<OrderInfoPageVO> B2PV(List<OrderInfoBO> bl);

    /**
     * B2V
     *
     * @param result
     * @return
     */
    PageResult<OrderInfoPageVO> B2PV(PageResult<OrderInfoBO> result);


}