package io.xxnjdg.notp.course.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.course.portal.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.portal.object.data.transfer.order.info.OrderInfoPageDTO;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 20:22
 */
public interface OrderInfoPortalService extends IService<OrderInfo> {
    /**
     * 分页查询
     * @param orderInfoPageDTO
     * @return
     */
    PageResult<OrderInfoBO> listOrderInfoByPage(OrderInfoPageDTO orderInfoPageDTO);
}
