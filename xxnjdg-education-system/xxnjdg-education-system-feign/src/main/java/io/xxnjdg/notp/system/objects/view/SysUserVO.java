package io.xxnjdg.notp.system.objects.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/15 22:25
 */
@Data
@Accessors(chain = true)
public class SysUserVO implements Serializable {

    /**
     * SysUser 菜单 apiurl
     */
    List<String> listMenuApiUrl;
}
