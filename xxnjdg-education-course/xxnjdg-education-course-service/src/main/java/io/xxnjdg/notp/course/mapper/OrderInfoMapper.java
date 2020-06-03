package io.xxnjdg.notp.course.mapper;

import cn.hutool.core.date.DateTime;
import io.xxnjdg.notp.course.admin.object.data.transfer.OrderInfoDTO;
import io.xxnjdg.notp.course.object.domain.OrderInfoListDO;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.course.object.view.OrderInfoListVO;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查询列表
     * @param lecturerUserNo
     * @param lecturerName
     * @param mobile
     * @param orderNo
     * @param courseId
     * @param courseName
     * @param tradeType
     * @param payType
     * @param channelType
     * @param orderStatus
     * @param remark
     * @param beginPayTime
     * @param endPayTime
     * @param offset
     * @param size
     * @return
     */
    List<OrderInfo> listOrderInfoByPage(
            @Param("lecturerUserNo") Long lecturerUserNo,
            @Param("lecturerName") String lecturerName,
            @Param("mobile") String mobile,
            @Param("orderNo") Long orderNo,
            @Param("courseId") Long courseId,
            @Param("courseName") String courseName,
            @Param("tradeType") Integer tradeType,
            @Param("payType") Integer payType,
            @Param("channelType") Integer channelType,
            @Param("orderStatus") Integer orderStatus,
            @Param("remark") String remark,
            @Param("beginPayTime") DateTime beginPayTime,
            @Param("endPayTime") DateTime endPayTime,
            @Param("offset") Integer offset,
            @Param("size") Integer size);

    /**
     * 统计订单收入情况
     * @param orderInfoDTO
     * @return
     */
    OrderInfo getStatisticalOrderInfo(OrderInfoDTO orderInfoDTO);

    /**
     * 分页查询列表
     * @param userNo
     * @param orderStatus
     * @param offset
     * @param size
     * @return
     */
    List<OrderInfo> listOrderInfoPortalByPage(
            @Param("userNo") Long userNo,
            @Param("orderStatus") Integer orderStatus,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
