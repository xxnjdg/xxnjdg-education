package io.xxnjdg.notp.utils.constant;

import cn.hutool.core.util.EnumUtil;
import io.xxnjdg.notp.utils.interfaces.BaseLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-17 下午2:11
 */
@AllArgsConstructor
@Getter
public enum  CourseCategoryFloor {

    /**
     * 第一层
     */
    FIRST(1,"第一层"),
    /**
     * 第二层
     */
    SECOND(2,"第二层"),

    /**
     * 第三层
     */
    THIRD(3,"第三层");

    private Integer status;
    private String statusText;

}
