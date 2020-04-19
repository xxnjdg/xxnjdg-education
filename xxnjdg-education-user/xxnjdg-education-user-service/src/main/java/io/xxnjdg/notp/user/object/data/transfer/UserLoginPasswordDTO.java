package io.xxnjdg.notp.user.object.data.transfer;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-20 上午1:53
 */
@Data
public class UserLoginPasswordDTO implements Serializable {

    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 登录密码
     */
    private String password;
    /**
     * clientId
     */
    private String clientId;

    private String ip;

}
