package io.xxnjdg.notp.course.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.OrderPayBO;
import io.xxnjdg.notp.course.admin.object.convert.OrderPayMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.OrderPayDTO;
import io.xxnjdg.notp.course.admin.service.OrderPayAdminService;
import io.xxnjdg.notp.course.mapper.OrderPayMapper;
import io.xxnjdg.notp.course.object.persistent.OrderPay;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 17:28
 */
@Service
public class OrderPayAdminServiceImpl extends ServiceImpl<OrderPayMapper, OrderPay> implements OrderPayAdminService {

    @Override
    public PageResult<OrderPayBO> listOrderPayByPage(OrderPayDTO orderPayDTO) {

        PageResult<OrderPayBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<OrderPay> wrapper = new QueryWrapper<OrderPay>()
                .lambda();

        Long orderNo = orderPayDTO.getOrderNo();
        if (orderNo != null){
            wrapper.eq(OrderPay::getOrderNo, orderNo);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0){
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                orderPayDTO.getPageCurrent(), orderPayDTO.getPageSize(), count);

        //查询
        List<OrderPay> orderPayList =
                this.baseMapper.listOrderPayByPage(orderNo,pageObject.getOffset(), pageObject.getSize());

        List<OrderPayBO> orderPayBOList = OrderPayMapStruct.INSTANCE.P2B(orderPayList);

        return result
                .setCurrentList(orderPayBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) orderPayList.size());
    }
}