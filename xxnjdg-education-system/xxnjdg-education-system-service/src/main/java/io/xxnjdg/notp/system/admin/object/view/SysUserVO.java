package io.xxnjdg.notp.system.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 14:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserVO {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userNo;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 备注
     */
    private String remark;
}
