package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.admin.object.convert.OrderInfoMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.OrderInfoDTO;
import io.xxnjdg.notp.course.admin.object.view.OrderInfoStatisticalVO;
import io.xxnjdg.notp.course.admin.service.OrderInfoAdminService;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 15:55
 */
@RestController
public class OrderInfoAdminController {

    @Autowired
    private OrderInfoAdminService orderInfoAdminService;

    @PostMapping("/course/pc/order/info/list")
    public ResponseResult listOrderInfoByPage(@RequestBody @Validated(Page.class) OrderInfoDTO orderInfoDTO ){
        PageResult<OrderInfoBO> result = orderInfoAdminService.listOrderInfoByPage(orderInfoDTO);
        return ResponseResult.success(OrderInfoMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/pc/order/info/statistical")
    public ResponseResult getStatisticalOrderInfo(@RequestBody @Validated(ListGroup.class) OrderInfoDTO orderInfoDTO ){
        OrderInfoBO result = orderInfoAdminService.getStatisticalOrderInfo(orderInfoDTO);
        return ResponseResult.success(OrderInfoMapStruct.INSTANCE.B2SV(result));
    }

    @PostMapping("/course/pc/order/info/view")
    public ResponseResult getOrderInfo(@RequestBody @Validated(Get.class) OrderInfoDTO orderInfoDTO ){
        OrderInfoBO result = orderInfoAdminService.getOrderInfo(orderInfoDTO);
        return ResponseResult.success(OrderInfoMapStruct.INSTANCE.B2VV(result));
    }

    @PostMapping("/course/pc/order/info/update")
    public ResponseResult updateOrderInfo(@RequestBody @Validated(Update.class) OrderInfoDTO orderInfoDTO ){
        Boolean result = orderInfoAdminService.updateOrderInfo(orderInfoDTO);
        return ResponseResult.success(result);
    }
}
