package io.xxnjdg.notp.utils.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-16 下午3:36
 */
@AllArgsConstructor
@Getter
public enum ItemStatus {

    /**
     * 启动
     */
    ENABLE(1,"启动"),
    /**
     * 关闭
     */
    DISABLED(0,"系统内部错误");

    private Integer status;
    private String statusText;

}
