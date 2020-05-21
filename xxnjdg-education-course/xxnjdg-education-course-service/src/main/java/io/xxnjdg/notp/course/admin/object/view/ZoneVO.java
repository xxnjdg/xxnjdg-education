package io.xxnjdg.notp.course.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 22:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZoneVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专区ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 状态(1:正常;0:禁用)
     */
    private Integer statusId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 专区名称
     */
    private String zoneName;

    /**
     * 专区描述
     */
    private String zoneDesc;
    /**
     * 位置(0电脑端，1微信端)
     */
    private Integer zoneLocation;
}
