package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.object.business.OrderPayBO;
import io.xxnjdg.notp.course.admin.object.convert.OrderPayMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.OrderPayDTO;
import io.xxnjdg.notp.course.admin.service.OrderPayAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 17:26
 */
@RestController
public class OrderPayAdminController {

    @Autowired
    private OrderPayAdminService orderPayAdminService;

    @PostMapping("/course/pc/order/pay/list")
    public ResponseResult listOrderPayByPage(@RequestBody @Validated OrderPayDTO orderPayDTO ){
        PageResult<OrderPayBO> result = orderPayAdminService.listOrderPayByPage(orderPayDTO);
        return ResponseResult.success(OrderPayMapStruct.INSTANCE.B2V(result));
    }

}
