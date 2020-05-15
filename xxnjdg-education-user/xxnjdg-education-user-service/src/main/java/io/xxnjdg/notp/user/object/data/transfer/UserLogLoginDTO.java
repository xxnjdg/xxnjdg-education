package io.xxnjdg.notp.user.object.data.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/16 1:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserLogLoginDTO implements Serializable {

    private static final long serialVersionUID = 1434999078159648155L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 登录状态(1成功，0失败)
     */
    private Integer loginStatus;

    /**
     * 登录IP
     */
    private String loginIp;

}
