package io.xxnjdg.notp.course.portal.object.view.adv;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 2:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdvPageVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 广告标题
     */
    private String advTitle;

    /**
     * 广告图片
     */
    private String advImg;

    /**
     * 广告链接
     */
    private String advUrl;

    /**
     * 广告跳转方式
     */
    private String advTarget;

    /**
     * 广告位置(1首页轮播)
     */
    private Integer advLocation;
}
