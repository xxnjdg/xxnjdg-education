package io.xxnjdg.notp.user.object.persistent;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户发送短信日志
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SendSmsLog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 短信模板
     */
    private String template;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 验证码
     */
    private String smsCode;

    /**
     * 是否发送成功(1发送成功，0:发送失败)
     */
    private Integer isSuccess;


}
