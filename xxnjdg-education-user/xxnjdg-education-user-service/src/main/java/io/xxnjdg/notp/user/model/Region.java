package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Region implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 父id
     *
     * @mbg.generated
     */
    private Long parentId;

    /**
     * 级别
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * 区域编码（国标）
     *
     * @mbg.generated
     */
    private String provinceCode;

    /**
     * 中心经度
     *
     * @mbg.generated
     */
    private BigDecimal centerLng;

    /**
     * 中心维度
     *
     * @mbg.generated
     */
    private BigDecimal centerLat;

    /**
     * 省Id
     *
     * @mbg.generated
     */
    private Integer provinceId;

    /**
     * 省名称
     *
     * @mbg.generated
     */
    private String provinceName;

    /**
     * 市Id
     *
     * @mbg.generated
     */
    private Integer cityId;

    /**
     * 城市编码
     *
     * @mbg.generated
     */
    private String cityCode;

    /**
     * 市名称
     *
     * @mbg.generated
     */
    private String cityName;

    /**
     * 区域名称
     *
     * @mbg.generated
     */
    private String regionName;

    /**
     * 区名称
     *
     * @mbg.generated
     */
    private String districtName;

    /**
     * 全路径名称
     *
     * @mbg.generated
     */
    private String mergerName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public BigDecimal getCenterLng() {
        return centerLng;
    }

    public void setCenterLng(BigDecimal centerLng) {
        this.centerLng = centerLng;
    }

    public BigDecimal getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(BigDecimal centerLat) {
        this.centerLat = centerLat;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", level=").append(level);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", centerLng=").append(centerLng);
        sb.append(", centerLat=").append(centerLat);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", cityId=").append(cityId);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", cityName=").append(cityName);
        sb.append(", regionName=").append(regionName);
        sb.append(", districtName=").append(districtName);
        sb.append(", mergerName=").append(mergerName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}