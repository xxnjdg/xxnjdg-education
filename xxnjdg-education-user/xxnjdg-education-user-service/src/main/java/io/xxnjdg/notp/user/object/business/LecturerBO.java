package io.xxnjdg.notp.user.object.business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午10:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LecturerBO implements Serializable {

    private static final long serialVersionUID = -1611554524008088187L;
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
     * 排序
     */
    private Integer sort;

    /**
     * 讲师用户编号
     */
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
    private LecturerExtBO lecturerExtVO;
}