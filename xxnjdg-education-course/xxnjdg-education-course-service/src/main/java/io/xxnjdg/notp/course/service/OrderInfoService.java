package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.object.data.transfer.OrderInfoListDTO;
import io.xxnjdg.notp.course.object.data.transfer.UserCoursePaymentStatusDTO;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.view.OrderInfoListVO;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * <p>
 * 订单信息表 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 分页展示订单列表
     * @param orderInfoListDTO OrderInfoListDTO
     * @return OrderInfoListVO
     */
    PageResult<OrderInfoListVO> postOrderInfoListByPage(OrderInfoListDTO orderInfoListDTO);


    /**
     * 用户课程付费状态
     * @param userCoursePaymentStatusDTO userCoursePaymentStatusDTO
     * @return OrderInfoBO
     */
    OrderInfoBO getUserCoursePaymentStatus(UserCoursePaymentStatusDTO userCoursePaymentStatusDTO);
}
