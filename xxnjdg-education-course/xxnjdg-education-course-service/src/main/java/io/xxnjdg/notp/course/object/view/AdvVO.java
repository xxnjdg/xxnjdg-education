package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-17 上午11:18
 */
@Data
public class AdvVO implements Serializable {

    private static final long serialVersionUID = -4851376715168406998L;
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
