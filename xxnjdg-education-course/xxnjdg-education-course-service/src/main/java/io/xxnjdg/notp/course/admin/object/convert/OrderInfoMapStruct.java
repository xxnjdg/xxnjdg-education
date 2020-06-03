package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.OrderInfoDTO;
import io.xxnjdg.notp.course.admin.object.view.OrderInfoPageVO;
import io.xxnjdg.notp.course.admin.object.view.OrderInfoStatisticalVO;
import io.xxnjdg.notp.course.admin.object.view.OrderInfoViewVO;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 16:01
 */
@Mapper
public interface OrderInfoMapStruct {
    OrderInfoMapStruct INSTANCE = Mappers.getMapper(OrderInfoMapStruct.class);


    /**
     * B2V
     * @param orderInfoDTO
     * @return
     */
    OrderInfo DT2P(OrderInfoDTO orderInfoDTO);


    /**
     * B2V
     * @param orderInfoBO
     * @return
     */
    @Mappings(@Mapping(source = "pricePaid",target = "totalProfit"))
    OrderInfoStatisticalVO B2SV(OrderInfoBO orderInfoBO);

    /**
     * B2V
     * @param orderInfoBO
     * @return
     */
    OrderInfoViewVO B2VV(OrderInfoBO orderInfoBO);



    /**
     * P2B
     * @param orderInfo
     * @return
     */
    OrderInfoBO P2B(OrderInfo orderInfo);


    /**
     * P2B
     * @param orderInfoList
     * @return
     */
    List<OrderInfoBO> P2B(List<OrderInfo> orderInfoList);

    /**
     * B2V
     * @param orderInfoBO
     * @return
     */
    OrderInfoPageVO B2PV(OrderInfoBO orderInfoBO);


    /**
     * B2V
     * @param orderInfoBOList
     * @return
     */
    List<OrderInfoPageVO> B2PV(List<OrderInfoBO> orderInfoBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<OrderInfoPageVO> B2PV(PageResult<OrderInfoBO> result);
}