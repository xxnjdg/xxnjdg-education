package io.xxnjdg.notp.user.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午10:56
 */
@Getter
@AllArgsConstructor
public enum  LecturerExtEnum implements BaseResponse {
    /**
     * 讲师不存在，请联系管理员
     */
    LECTURER_EXT_NULL(400,"讲师信息不存在，请联系管理员");

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