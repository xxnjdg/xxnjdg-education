package io.xxnjdg.notp.course.service.impl;

import io.xxnjdg.notp.course.object.persistent.OrderPay;
import io.xxnjdg.notp.course.mapper.OrderPayMapper;
import io.xxnjdg.notp.course.service.OrderPayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单支付信息表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class OrderPayServiceImpl extends ServiceImpl<OrderPayMapper, OrderPay> implements OrderPayService {

}
