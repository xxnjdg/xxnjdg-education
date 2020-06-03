package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.OrderInfoDTO;
import io.xxnjdg.notp.course.admin.object.view.OrderInfoStatisticalVO;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 15:57
 */
public interface OrderInfoAdminService extends IService<OrderInfo> {
    /**
     * 分页查询列表
     * @param orderInfoDTO
     * @return
     */
    PageResult<OrderInfoBO> listOrderInfoByPage(OrderInfoDTO orderInfoDTO);

    /**
     * 统计订单收入情况接口
     * @param orderInfoDTO
     * @return
     */
    OrderInfoBO getStatisticalOrderInfo(OrderInfoDTO orderInfoDTO);

    /**
     * 查询
     * @param orderInfoDTO
     * @return
     */
    OrderInfoBO getOrderInfo(OrderInfoDTO orderInfoDTO);

    /**
     * 更新
     * @param orderInfoDTO
     * @return
     */
    Boolean updateOrderInfo(OrderInfoDTO orderInfoDTO);
}
