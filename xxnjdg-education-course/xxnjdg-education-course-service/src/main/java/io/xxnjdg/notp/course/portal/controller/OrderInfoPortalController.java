package io.xxnjdg.notp.course.portal.controller;

import io.xxnjdg.notp.course.portal.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.portal.object.convert.OrderInfoMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.order.info.OrderInfoPageDTO;
import io.xxnjdg.notp.course.portal.service.OrderInfoPortalService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 20:20
 */
@RestController
@Validated
public class OrderInfoPortalController {
    @Autowired
    private OrderInfoPortalService orderInfoPortalService;

    @PostMapping("/course/auth/order/info/list")
    public ResponseResult listOrderInfoByPage(
            @RequestBody @Validated OrderInfoPageDTO orderInfoPageDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo ){
        PageResult<OrderInfoBO> result = orderInfoPortalService.listOrderInfoByPage(
                orderInfoPageDTO.setUserNo(userNo));
        return ResponseResult.success(OrderInfoMapStruct.INSTANCE.B2PV(result));
    }
}
