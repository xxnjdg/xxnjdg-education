package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.persistent.OrderPay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单支付信息表 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface OrderPayMapper extends BaseMapper<OrderPay> {

    /**
     * 分页查询OrderPay列表
     * @param orderNo
     * @param offset
     * @param size
     * @return
     */
    List<OrderPay> listOrderPayByPage(@Param("orderNo") Long orderNo,@Param("offset") Integer offset, @Param("size") Integer size);
}
