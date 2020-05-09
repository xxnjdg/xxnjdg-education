package io.xxnjdg.notp.course.controller;


import io.xxnjdg.notp.course.object.data.transfer.OrderInfoListDTO;
import io.xxnjdg.notp.course.object.view.OrderInfoListVO;
import io.xxnjdg.notp.course.service.OrderInfoService;
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
 * <p>
 * 订单信息表 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
@Validated
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @PostMapping("/course/auth/order/info/list")
    public ResponseResult postOrderInfoListByPage(
            @RequestBody @Validated OrderInfoListDTO orderInfoListDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo ){
        return ResponseResult.success(
                orderInfoService.postOrderInfoListByPage(
                        orderInfoListDTO.setUserNo(userNo)));
    }

}

