package io.xxnjdg.notp.course.object.data.transfer;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-18 下午6:47
 */
@Data
public class ZoneDTO implements Serializable {

    private static final long serialVersionUID = -1085078662673158628L;
    /**
     * 位置0电脑端，1微信端)
     */
    @NotNull(message = "参数不能为空")
    @Range(min = 0,max = 1,message = "平台参数错误")
    private Integer zoneLocation;


}
