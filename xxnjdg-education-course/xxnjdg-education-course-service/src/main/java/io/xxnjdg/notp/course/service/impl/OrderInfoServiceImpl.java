package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.object.convert.OrderInfoDOToBO;
import io.xxnjdg.notp.course.object.data.transfer.OrderInfoListDTO;
import io.xxnjdg.notp.course.object.data.transfer.UserCoursePaymentStatusDTO;
import io.xxnjdg.notp.course.object.domain.OrderInfoListDO;
import io.xxnjdg.notp.course.object.error.OrderInfoEnum;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.course.mapper.OrderInfoMapper;
import io.xxnjdg.notp.course.object.view.OrderInfoListVO;
import io.xxnjdg.notp.course.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.DefaultPageValue;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.response.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
@Slf4j
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    // TODO: 20-4-28 没测完
    @Override
    public PageResult<OrderInfoListVO> postOrderInfoListByPage(OrderInfoListDTO orderInfoListDTO) {

        Integer pageCurrent;
        Integer pageSize;
        OrderInfoListDO orderInfoListDO = new OrderInfoListDO()
                .setUserNo(orderInfoListDTO.getUserNo())
                .setOrderStatus(null);

        PageResult<OrderInfoListVO> orderInfoListVOPageResult = new PageResult<>();

        String orderStatus = orderInfoListDTO.getOrderStatus();

        if (StrUtil.isNotBlank(orderStatus) && !ObjectUtil.equal(orderStatus,"0")){
            orderInfoListDO.setOrderStatus(new Integer(orderStatus));
        }

        //算总数
        Integer count = this.baseMapper.orderInfoListByPageCount(orderInfoListDO);
        log.error(count.toString());

        //条数为0
        if (count == 0){
            return orderInfoListVOPageResult;
        }

        //没有值设置默认值
        if (StrUtil.isBlank(orderInfoListDTO.getPageCurrent())){
            pageCurrent = DefaultPageValue.DEFAULT_CURRENT_PAGE;
        }else {
            pageCurrent = new Integer(orderInfoListDTO.getPageCurrent());
        }
        log.error("pageCurrent "+pageCurrent);

        //没有值设置默认值
        if (StrUtil.isBlank(orderInfoListDTO.getPageSize())){
            pageSize = DefaultPageValue.DEFAULT_CURRENT_LIST_SIZE;
        }else{
            pageSize = new Integer(orderInfoListDTO.getPageSize());
        }
        log.error("pageSize "+pageSize);

        //总数 + 列表数 算总页数
        int totalPage = PageUtil.totalPage(count, pageSize);
        log.error("totalPage "+totalPage);

        //算 limit offset size
        int[] startEnd;
        if (totalPage < pageCurrent){
            pageCurrent = totalPage;
        }
        log.error("pageCurrent "+pageCurrent);

        //设置 limit
        startEnd = PageUtil.transToStartEnd(pageCurrent-1, pageSize);

        orderInfoListDO.setOffset(startEnd[0]).setSize(pageSize);

        //查询
        List<OrderInfoListVO> orderInfoListVOS = this.baseMapper.orderInfoListByPage(orderInfoListDO);

        orderInfoListVOPageResult.setCurrentList(orderInfoListVOS);
        orderInfoListVOPageResult.setTotalCount(new Long(count));
        orderInfoListVOPageResult.setTotalPage(new Long(pageCurrent));

        return orderInfoListVOPageResult;
    }

    @Override
    public OrderInfoBO getUserCoursePaymentStatus(UserCoursePaymentStatusDTO userCoursePaymentStatusDTO) {
        LambdaQueryWrapper<OrderInfo> infoLambdaQueryWrapper = new QueryWrapper<OrderInfo>()
                .lambda()
                .eq(OrderInfo::getCourseId, userCoursePaymentStatusDTO.getCourseId())
                .eq(OrderInfo::getUserNo, userCoursePaymentStatusDTO.getUserNo())
                .eq(OrderInfo::getOrderStatus, userCoursePaymentStatusDTO.getOrderStatus());

        OrderInfo one = this.getOne(infoLambdaQueryWrapper);
        if (one == null){
            return null;
        }
        return OrderInfoDOToBO.INSTANCE.convert(one);
    }
}
