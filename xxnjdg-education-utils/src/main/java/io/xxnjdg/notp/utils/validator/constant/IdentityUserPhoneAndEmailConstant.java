package io.xxnjdg.notp.utils.validator.constant;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-23 下午4:36
 */
public interface IdentityUserPhoneAndEmailConstant {
    /**
     * 手机号正则
     */
    String PHONE_REGEX = "^1[3|4|5|8|7][0-9]\\d{4,8}$";
    /**
     * 邮箱号正则
     */
    String EMAIL_REGEX = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";

}
