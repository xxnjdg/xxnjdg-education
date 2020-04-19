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
 * 用户教育信息
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserExt implements Serializable {

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
     * 用户类型(1用户，2讲师)
     */
    private Integer userType;

    /**
     * 用户手机
     */
    private String mobile;

    /**
     * 性别(1男，2女，3保密)
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String headImgUrl;

    /**
     * 备注
     */
    private String remark;


}
