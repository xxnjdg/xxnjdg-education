package io.xxnjdg.notp.utils.interfaces;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-17 下午6:30
 */
public interface BaseLevel {
    /**
     * 获取总数
     * @return Integer
     */
    Integer getTotal();

    /**
     * 获取当前 index
     * @return Integer
     */
    Integer getCurrentIndex();

    /**
     * 获取下一个实例
     * @return BaseLevel
     */
    BaseLevel getNextInstance();
}
