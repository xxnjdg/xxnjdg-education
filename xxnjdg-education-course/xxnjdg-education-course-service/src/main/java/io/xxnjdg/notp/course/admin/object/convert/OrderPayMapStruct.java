package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.OrderPayBO;
import io.xxnjdg.notp.course.admin.object.view.OrderPayVO;
import io.xxnjdg.notp.course.object.persistent.OrderPay;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 17:55
 */
@Mapper
public interface OrderPayMapStruct {
    OrderPayMapStruct INSTANCE = Mappers.getMapper(OrderPayMapStruct.class);

    /**
     * P2B
     * @param orderPay
     * @return
     */
    OrderPayBO P2B(OrderPay orderPay);


    /**
     * P2B
     * @param orderPay
     * @return
     */
    List<OrderPayBO> P2B(List<OrderPay> orderPay);

    /**
     * B2V
     * @param orderPayBO
     * @return
     */
    OrderPayVO B2V(OrderPayBO orderPayBO);

    /**
     * B2V
     * @param orderPayBOList
     * @return
     */
    List<OrderPayVO> B2V(List<OrderPayBO> orderPayBOList);

    /**
     * B2V
     * @param orderPayBO
     * @return
     */
    PageResult<OrderPayVO> B2V(PageResult<OrderPayBO> orderPayBO);
}