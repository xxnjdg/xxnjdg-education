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

    /**
     * decimal(11,2)
     * 整数到达9位，小数保留最后2位，不能填 0 0.0 0.00...
     */
    String COURSE_PRICE = "(^[1-9]\\d{0,8}(\\.\\d{1,2})?$)|(^0\\.[1-9]$)|(^0\\.\\d[1-9]$)";
    /**
     * decimal(5,4)
     * 导师分成
     */
    String LECTURER_PROPORTION = "(^0(\\.\\d{1,4})?$)";
    /**
     *
     */
    String PASSWORD = "^[A-Za-z\\d$@!%*?&\\.]{6,20}$";
}
