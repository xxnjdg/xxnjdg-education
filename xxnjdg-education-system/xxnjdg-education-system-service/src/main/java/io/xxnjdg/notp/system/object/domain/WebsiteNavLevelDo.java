package io.xxnjdg.notp.system.object.domain;

import io.xxnjdg.notp.system.object.persistent.WebsiteNav;
import lombok.Data;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-16 下午4:41
 */
@Data
public class WebsiteNavLevelDo extends WebsiteNav {
    List<WebsiteNav> children;
}
