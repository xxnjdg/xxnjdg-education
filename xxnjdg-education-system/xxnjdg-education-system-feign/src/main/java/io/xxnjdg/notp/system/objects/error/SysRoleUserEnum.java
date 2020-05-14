package io.xxnjdg.notp.system.objects.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-14 下午8:42
 */
@Getter
@AllArgsConstructor
public enum SysRoleUserEnum implements BaseResponse {
    /**
     * 错误请求
     */
    GET_ERROR(400,"系统用户角色异常，请联系管理员");

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