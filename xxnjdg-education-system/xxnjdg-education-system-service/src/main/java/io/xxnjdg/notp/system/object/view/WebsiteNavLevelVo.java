package io.xxnjdg.notp.system.object.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-16 下午5:41
 */
@Data
@Accessors(chain = true)
public class WebsiteNavLevelVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 状态(1有效, 0无效)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 导航名称
     */
    private String navName;

    /**
     * 孩子
     */
    List<WebsiteNavLevelVo> children;

}
