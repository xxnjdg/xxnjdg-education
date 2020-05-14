package io.xxnjdg.notp.user.object.business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-14 下午6:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 密码盐
     */
    private String mobileSalt;

    /**
     * 登录密码
     */
    private String mobilePsw;

    /**
     * 用户来源(client_id)
     */
    private String userSource;
}
