package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 22:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WebsiteNavArticleDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL, groups = {Update.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Insert.class})
    private Long id;

    /**
     * 排序
     */
    @Range(min = 1, max = Integer.MAX_VALUE, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Insert.class})
    private Integer sort;

    /**
     * 文章标题
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class, Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class})
    private String artTitle;

    /**
     * 文章图片
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class, Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class})
    private String artPic;

    /**
     * 文章描述
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class})
    private String artDesc;

    /**
     * 状态(1有效, 0无效)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Insert.class})
    private Integer statusId;

    /**
     * 导航ID
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL, groups = {Get.class, Insert.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Get.class, Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class})
    private Long navId;

    /**
     * 创建时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime gmtModified;

}