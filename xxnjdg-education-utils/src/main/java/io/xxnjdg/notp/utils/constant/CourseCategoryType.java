package io.xxnjdg.notp.utils.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-17 下午2:10
 */
@AllArgsConstructor
@Getter
public enum  CourseCategoryType {

    /**
     * 课程
     */
    COURSE("1","课程"),
    /**
     * 资源
     */
    RESOURCES("2","资源");

    private String status;
    private String statusText;

}
