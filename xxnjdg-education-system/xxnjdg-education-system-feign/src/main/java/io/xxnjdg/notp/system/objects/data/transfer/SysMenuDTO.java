package io.xxnjdg.notp.system.objects.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-14 下午7:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long userNo;

    /**
     * 主键
     */
    @Null
    private Long id;

    /**
     * 创建时间
     */
    @Null
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @Null
    private LocalDateTime gmtModified;

    /**
     * 状态(1:正常，0:禁用)
     */
    @Null
    private Integer statusId;

    /**
     * 排序
     */
    @Null
    private Integer sort;

    /**
     * 父ID
     */
    @Null
    private Long parentId;

    /**
     * 菜单名称
     */
    @Null
    private String menuName;

    /**
     * 路由路径
     */
    @Null
    private String menuUrl;

    /**
     * 接口URL
     */
    @Null
    private String apiUrl;

    /**
     * 菜单图标
     */
    @Null
    private String menuIcon;

    /**
     * 备注
     */
    @Null
    private String remark;

    /**
     * 菜单类型(1：目录   2：菜单   3：按钮)
     */
    @Null
    private Integer menuType;


}