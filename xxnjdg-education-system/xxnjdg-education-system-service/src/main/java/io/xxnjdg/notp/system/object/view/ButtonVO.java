package io.xxnjdg.notp.system.object.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/16 22:14
 */
@Data
@Accessors(chain = true)
public class ButtonVO implements Serializable {
    private static final long serialVersionUID = -1460340329663400815L;

    /**
     * 接口URL
     */
    private String apiUrl;

    /**
     * 菜单名称
     */
    private String name;
}
