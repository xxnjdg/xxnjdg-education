package io.xxnjdg.notp.user.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/16 1:15
 */
@Getter
@AllArgsConstructor
public enum  UserLogLoginEnum implements BaseResponse {
    /**
     * 插入异常，请联系管理员
     */
    INSERT_ERROR(400,"插入异常，请联系管理员");

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