package io.xxnjdg.notp.user.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-26 下午5:51
 */
@Getter
@AllArgsConstructor
public enum  UserRegisterEnum implements BaseResponse {
    /**
     * 两次密码不重复
     */
    PASSWORD_REPEAT_ERROR(400,"两次密码不重复"),
    /**
     * 验证码不正确
     */
    CODE_ERROR(400,"验证码不正确"),
    /**
     * 系统错误,稍后再试
     */
    INSERT_ERROR(400,"系统错误,稍后再试"),
    /**
     * 手机号没有注册
     */
    USER_NO_REGISTER_ERROR(400,"手机号没有注册"),
    /**
     * 密码相同
     */
    USER_PASSWORD_EQUAL_ERROR(400,"密码相同"),
    /**
     * 密码更新失败
     */
    USER_PASSWORD_INSERT_ERROR(400,"密码更新失败"),
    /**
     * 手机号以注册
     */
    REGISTER_ERROR(400,"手机号以注册");

    private Integer status;
    private String statusText;

    @Override
    public Integer status() {
        return status;
    }

    @Override
    public String statusText() {
        return statusText;
    }

}
