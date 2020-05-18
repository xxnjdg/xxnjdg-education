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
 * @date 2020/5/18 18:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MsgTemplateVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 状态(1有效, 0无效)
     */
    private Integer statusId;
    /**
     * 标题
     */
    private String title;
    /**
     * 备注
     */
    private String remark;
}
