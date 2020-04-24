package io.xxnjdg.notp.user.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-24 下午5:44
 */
@Data
public class UserExtVO implements Serializable {
    private static final long serialVersionUID = -6715947440837973434L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userNo;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 性别
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
     * 头像
     */
    private String headImgUrl;
    /**
     * 备注
     */
    private String remark;
}
