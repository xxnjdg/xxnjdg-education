package io.xxnjdg.notp.course.admin.object.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 18:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfoStatisticalVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总收入
     */
    private BigDecimal totalProfit;

    /**
     * 平台收入
     */
    private BigDecimal platformProfit;

    /**
     * 讲师收入
     */
    private BigDecimal lecturerProfit;
}
