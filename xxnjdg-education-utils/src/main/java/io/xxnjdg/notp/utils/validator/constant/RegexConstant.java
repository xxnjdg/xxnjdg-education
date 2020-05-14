package io.xxnjdg.notp.utils.validator.constant;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-12 下午4:47
 */
public interface RegexConstant {
    /**
     * 1-254 正整数
     */
    String RANGE = "^([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-3])))$";
    String UNSIGNED_INTEGER = "^[\\d]{1,9}$";
    String UNSIGNED_LONG = "^[\\d]{1,19}$";
}
