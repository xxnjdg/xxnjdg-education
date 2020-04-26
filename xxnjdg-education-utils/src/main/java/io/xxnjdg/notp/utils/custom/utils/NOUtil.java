package io.xxnjdg.notp.utils.custom.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Date;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-26 下午7:16
 */
public class NOUtil {
    public static Long getUserNo() {
        return Long.valueOf(DateUtil.format(new Date(), "yyyyMMddHHmmss") + RandomUtil.randomNumbers(2));
    }
}
