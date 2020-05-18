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
 * @date 2020/5/18 15:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FullMsgUserVO implements Serializable {
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
     * 排序
     */
    private Integer sort;
    /**
     * 短信ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long msgId;
    /**
     * 用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userNo;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 短信类型
     */
    private Integer msgType;
    /**
     * 短信标题
     */
    private String msgTitle;
    /**
     * 是否阅读(1是;0否)
     */
    private Integer isRead;
    /**
     * 是否置顶(1是;0否)
     */
    private Integer isTop;
}
