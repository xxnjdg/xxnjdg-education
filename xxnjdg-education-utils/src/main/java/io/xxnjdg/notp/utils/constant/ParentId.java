package io.xxnjdg.notp.utils.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-16 下午3:46
 */
@AllArgsConstructor
@Getter
public enum ParentId {

    /**
     * 夫id
     */
    ZERO_PARENT_ID(0L,"父id");

    private Long status;
    private String statusText;

}
