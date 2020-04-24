package io.xxnjdg.notp.utils.interfaces;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-23 下午8:24
 */
public interface BaseResponse {
    /**
     * 返回状态码
     *
     * @return 状态码
     */
    Integer status();

    /**
     * 返回状态信息
     *
     * @return 状态信息
     */
    String statusText();
}
