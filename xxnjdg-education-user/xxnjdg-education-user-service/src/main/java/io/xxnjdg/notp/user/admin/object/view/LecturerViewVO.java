package io.xxnjdg.notp.user.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 23:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LecturerViewVO implements Serializable {
    private static final long serialVersionUID = 1L;
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
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;
    /**
     * 排序
     */
    private Integer sort;
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
    /**
     * 讲师分成比例
     */
    private BigDecimal lecturerProportion;

    /**
     * 讲师账户
     */
    private LecturerExtVO lecturerExt;
}
