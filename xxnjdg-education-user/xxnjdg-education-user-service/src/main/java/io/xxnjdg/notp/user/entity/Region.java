package io.xxnjdg.notp.user.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 行政区域表
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Region implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 区域编码（国标）
     */
    private String provinceCode;

    /**
     * 中心经度
     */
    private BigDecimal centerLng;

    /**
     * 中心维度
     */
    private BigDecimal centerLat;

    /**
     * 省Id
     */
    private Integer provinceId;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市Id
     */
    private Integer cityId;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 区名称
     */
    private String districtName;

    /**
     * 全路径名称
     */
    private String mergerName;


}
