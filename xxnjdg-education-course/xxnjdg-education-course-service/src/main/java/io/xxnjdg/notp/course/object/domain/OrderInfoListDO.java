package io.xxnjdg.notp.course.object.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-27 下午8:23
 */
@Data
@Accessors(chain = true)
public class OrderInfoListDO {

    /**
     * 订单状态1待支付，2成功支付，3支付失败，4已关闭
     */
    private Integer orderStatus;

    /**
     * 讲师编号
     */
    private Long lecturerUserNo;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * limit offset
     */
    private Integer offset;

    /**
     * limit size
     */
    private Integer size;

}
