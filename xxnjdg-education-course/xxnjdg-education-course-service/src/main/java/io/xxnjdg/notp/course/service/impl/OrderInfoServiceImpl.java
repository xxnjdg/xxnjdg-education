package io.xxnjdg.notp.course.service.impl;

import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.course.mapper.OrderInfoMapper;
import io.xxnjdg.notp.course.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
