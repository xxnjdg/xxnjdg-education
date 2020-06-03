package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.OrderPayBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.OrderPayDTO;
import io.xxnjdg.notp.course.object.persistent.OrderPay;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 17:27
 */
public interface OrderPayAdminService extends IService<OrderPay> {

    /**
     * 分页查询 OrderPay列表
     * @param orderPayDTO
     * @return
     */
    PageResult<OrderPayBO> listOrderPayByPage(OrderPayDTO orderPayDTO);

    /**
     * 查询
     * @param orderNo
     * @return
     */
    OrderPay getOrderPayByOrderNo(Long orderNo);
}
