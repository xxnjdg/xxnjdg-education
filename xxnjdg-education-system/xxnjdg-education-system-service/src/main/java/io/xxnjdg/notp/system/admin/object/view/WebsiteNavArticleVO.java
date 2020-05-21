package io.xxnjdg.notp.system.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 23:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WebsiteNavArticleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 导航ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long navId;
    /**
     * 文章标题
     */
    private String artTitle;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 文章图片
     */
    private String artPic;
    /**
     * 文章描述
     */
    private String artDesc;
}
