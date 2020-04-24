package io.xxnjdg.notp.user.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-23 下午5:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO implements Serializable {

    private static final long serialVersionUID = 4829956330162403628L;

    /**
     * 用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userNo;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * token，设置有效期为1天
     */
    private String token;

}
