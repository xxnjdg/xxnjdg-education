package io.xxnjdg.notp.utils.constant;

import java.util.concurrent.TimeUnit;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 4:47
 */
public interface LockTime {
    /**
     * tryLock时间
     */
    Integer LOCK_TIME = 200;
    TimeUnit LOCK_TIME_UNIT = TimeUnit.MILLISECONDS;
}
