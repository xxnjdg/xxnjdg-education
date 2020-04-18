package io.xxnjdg.notp.course.object.data.transfer;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-17 上午11:24
 */
@Data
public class AdvDTO {

    /**
     * 位置(0电脑端，1微信端)
     */
    @Range(min = 0,max=1,message = "平台参数错误")
    @NotNull(message = "平台参数不能为空")
    private Integer platShow;

}
