package io.xxnjdg.notp.user.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-29 上午3:57
 */
@Data
public class LecturerUserNoVO implements Serializable {
    private static final long serialVersionUID = 793578479402035504L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 讲师编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lecturerUserNo;
    /**
     * 讲师名称
     */
    private String lecturerName;
    /**
     * 电话
     */
    private String lecturerMobile;
    /**
     * 头像
     */
    private String headImgUrl;
    /**
     * 邮箱
     */
    private String lecturerEmail;
    /**
     * 职位
     */
    private String position;
    /**
     * 简介
     */
    private String introduce;
}
