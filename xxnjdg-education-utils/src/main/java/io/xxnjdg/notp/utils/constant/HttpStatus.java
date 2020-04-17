package io.xxnjdg.notp.utils.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午3:03
 */
@AllArgsConstructor
@Getter
public enum HttpStatus {

    /**
     * 操作成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 资源，服务未找到
     */
    NOT_FOUND(404,"服务未找到"),
    /**
     * 系统内部错误
     */
    ERROR(500,"系统内部错误");

    private int status;
    private String statusText;

}
