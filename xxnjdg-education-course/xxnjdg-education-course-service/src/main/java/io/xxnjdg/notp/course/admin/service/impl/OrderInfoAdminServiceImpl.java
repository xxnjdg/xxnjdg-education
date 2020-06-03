package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.admin.object.convert.OrderInfoMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.OrderInfoDTO;
import io.xxnjdg.notp.course.admin.object.error.OrderInfoEnum;
import io.xxnjdg.notp.course.admin.object.view.OrderInfoStatisticalVO;
import io.xxnjdg.notp.course.admin.service.OrderInfoAdminService;
import io.xxnjdg.notp.course.admin.service.OrderPayAdminService;
import io.xxnjdg.notp.course.mapper.OrderInfoMapper;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.course.object.persistent.OrderPay;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 15:57
 */
@Service
public class OrderInfoAdminServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoAdminService {

    @Autowired
    private OrderPayAdminService orderPayAdminService;

    @Override
    public PageResult<OrderInfoBO> listOrderInfoByPage(OrderInfoDTO orderInfoDTO) {

        PageResult<OrderInfoBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<OrderInfo> wrapper = new QueryWrapper<OrderInfo>()
                .lambda();

        DateTime beginPayTime = null;
        DateTime endPayTime = null;

        Long lecturerUserNo = orderInfoDTO.getLecturerUserNo();

        if (lecturerUserNo!=null){
            wrapper.eq(OrderInfo::getLecturerUserNo,lecturerUserNo);
        }

        String lecturerName = null;

        if (StrUtil.isNotBlank(orderInfoDTO.getLecturerName())){
            lecturerName = orderInfoDTO.getLecturerName();
            wrapper.like(OrderInfo::getLecturerName,lecturerName);
        }

        String mobile = null;

        if (StrUtil.isNotBlank(orderInfoDTO.getMobile())){
            mobile = orderInfoDTO.getMobile();
            wrapper.like(OrderInfo::getMobile,mobile);
        }

        Long orderNo = orderInfoDTO.getOrderNo();
        if (orderNo!=null){
            wrapper.eq(OrderInfo::getOrderNo,orderNo);
        }

        Long courseId = orderInfoDTO.getCourseId();
        if (courseId!=null){
            wrapper.eq(OrderInfo::getCourseId,courseId);
        }

        String courseName = null;
        if (StrUtil.isNotBlank(orderInfoDTO.getCourseName())){
            courseName = orderInfoDTO.getCourseName();
            wrapper.like(OrderInfo::getCourseName,courseName);
        }

        Integer tradeType = orderInfoDTO.getTradeType();
        if (tradeType!=null){
            wrapper.eq(OrderInfo::getTradeType,tradeType);
        }

        Integer payType = orderInfoDTO.getPayType();
        if (payType!=null){
            wrapper.eq(OrderInfo::getPayType,payType);
        }

        Integer channelType = orderInfoDTO.getChannelType();
        if (channelType!=null){
            wrapper.eq(OrderInfo::getChannelType,channelType);
        }

        Integer orderStatus = orderInfoDTO.getOrderStatus();
        if (orderStatus!=null){
            wrapper.eq(OrderInfo::getOrderStatus,orderStatus);
        }

        String remark = null;
        if (StrUtil.isNotBlank(orderInfoDTO.getRemark())){
            remark = orderInfoDTO.getRemark();
            wrapper.like(OrderInfo::getRemark,remark);
        }


        if (StrUtil.isNotBlank(orderInfoDTO.getBeginPayTime())) {
            beginPayTime = DateUtil.parse(orderInfoDTO.getBeginPayTime());
            beginPayTime.offset(DateField.HOUR, 24);
            wrapper.ge(OrderInfo::getGmtCreate, beginPayTime);
        }

        if (StrUtil.isNotBlank(orderInfoDTO.getEndPayTime())) {
            endPayTime = DateUtil.parse(orderInfoDTO.getEndPayTime());
            endPayTime.offset(DateField.HOUR, 48);
            wrapper.le(OrderInfo::getGmtCreate, endPayTime);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                orderInfoDTO.getPageCurrent(), orderInfoDTO.getPageSize(), count);

        //查询
        List<OrderInfo> orderInfoList =
                this.baseMapper.listOrderInfoByPage(
                        lecturerUserNo,lecturerName,mobile,orderNo,courseId,courseName,
                        tradeType,payType,channelType,orderStatus,remark,
                        beginPayTime, endPayTime, pageObject.getOffset(), pageObject.getSize());

        List<OrderInfoBO> orderInfoBOList = OrderInfoMapStruct.INSTANCE.P2B(orderInfoList);

        return result
                .setCurrentList(orderInfoBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) orderInfoBOList.size());
    }

    @Override
    public OrderInfoBO getStatisticalOrderInfo(OrderInfoDTO orderInfoDTO) {

        if (StrUtil.isBlank(orderInfoDTO.getRemark())){
            orderInfoDTO.setRemark(null);
        }

        if (StrUtil.isBlank(orderInfoDTO.getCourseName())){
            orderInfoDTO.setCourseName(null);
        }

        if (StrUtil.isBlank(orderInfoDTO.getMobile())){
            orderInfoDTO.setMobile(null);
        }

        if (StrUtil.isBlank(orderInfoDTO.getLecturerName())){
            orderInfoDTO.setLecturerName(null);
        }

        OrderInfo orderInfo =
                this.baseMapper.getStatisticalOrderInfo(orderInfoDTO);
        if (orderInfo == null){
            throw new BaseException(OrderInfoEnum.GET_ERROR);
        }
        return OrderInfoMapStruct.INSTANCE.P2B(orderInfo);
    }

    @Override
    public OrderInfoBO getOrderInfo(OrderInfoDTO orderInfoDTO) {
        OrderInfo orderInfo = this.getById(orderInfoDTO.getId());
        if (orderInfo == null){
            throw new BaseException(OrderInfoEnum.GET_ERROR);
        }

        OrderPay orderPay = orderPayAdminService
                .getOrderPayByOrderNo(orderInfo.getOrderNo());

        if (orderPay == null){
            throw new BaseException(OrderInfoEnum.GET_ERROR);
        }

        return OrderInfoMapStruct.INSTANCE.P2B(orderInfo)
                .setSerialNumber(orderPay.getSerialNumber());
    }

    @Override
    public Boolean updateOrderInfo(OrderInfoDTO orderInfoDTO) {
        OrderInfo orderInfo = OrderInfoMapStruct.INSTANCE.DT2P(orderInfoDTO);
        boolean update = this.updateById(orderInfo);
        if (!update){
            throw new BaseException(OrderInfoEnum.UPDATE_ERROR);
        }
        return true;
    }
}
