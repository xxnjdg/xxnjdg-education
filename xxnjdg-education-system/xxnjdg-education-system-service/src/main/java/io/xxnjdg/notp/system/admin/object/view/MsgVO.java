package io.xxnjdg.notp.system.admin.object.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 3:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MsgVO implements Serializable {
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
     * 短信标题
     */
    private String msgTitle;
    /**
     * 是否已发送(1是;0否)
     */
    private Integer isSend;
    /**
     * 是否定时发送（1是，0否）
     */
    private Integer isTimeSend;

    /**
     * 是否置顶(1是;0否)
     */
    private Integer isTop;
    /**
     * 发送时间
     */
    private LocalDateTime sendTime;
}
