package io.xxnjdg.notp.course.object.data.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午6:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserCoursePaymentStatusDTO {
    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * 订单状态：1待支付，2成功支付，3支付失败，4已关闭
     */
    private Integer orderStatus;
}
