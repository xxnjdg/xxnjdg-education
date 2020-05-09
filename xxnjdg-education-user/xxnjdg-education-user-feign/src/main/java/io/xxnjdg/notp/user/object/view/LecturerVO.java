package io.xxnjdg.notp.user.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-28 下午1:44
 */
@Data
@Accessors(chain = true)
public class LecturerVO implements Serializable {
    private static final long serialVersionUID = -3918102608276986092L;

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
     * 讲师用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lecturerUserNo;

    /**
     * 讲师名称
     */
    private String lecturerName;

    /**
     * 讲师手机
     */
    private String lecturerMobile;

    /**
     * 讲师邮箱
     */
    private String lecturerEmail;

    /**
     * 职位
     */
    private String position;

    /**
     * 头像
     */
    private String headImgUrl;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 讲师分成比例
     */
    private BigDecimal lecturerProportion;

    /**
     * 讲师账户信息表
     */
    private LecturerExtVO lecturerExtVO;
}
