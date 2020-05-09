package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.domain.OrderInfoListDO;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.course.object.view.OrderInfoListVO;

import java.util.List;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    /**
     * 算总数
     * @param orderInfoListDO
     * @return
     */
    Integer orderInfoListByPageCount(OrderInfoListDO orderInfoListDO);

    /**
     * 返回分页数据
     * @param orderInfoListDO
     * @return
     */
    List<OrderInfoListVO> orderInfoListByPage(OrderInfoListDO orderInfoListDO);

}
