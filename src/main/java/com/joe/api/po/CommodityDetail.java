package com.joe.api.po;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.math.BigDecimal;

/**
 * 商品明细Bean
 */
public class CommodityDetail {

    //明细ID（自增主键）
    private Integer detailId;

    //商品Id（对应 Commodity  commodityId）
    private Integer commodityId;

    //单位
    private String unit;

    //成本
    private BigDecimal cost;

    //原价
    private BigDecimal initPrice;

    //库存
    private Integer stock;

    //属性
    private String property;

    //细节图
    private String detailPicture;

    //图信息
    private String pictureInfo;

    //运费
    private BigDecimal freight;

    //积分
    private Integer integral;

    //产地
    private String origin;

    //可用
    private Boolean enable;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getInitPrice() {
        return initPrice;
    }

    public void setInitPrice(BigDecimal initPrice) {
        this.initPrice = initPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDetailPicture() {
        return detailPicture;
    }

    public void setDetailPicture(String detailPicture) {
        this.detailPicture = detailPicture;
    }

    public String getPictureInfo() {
        return pictureInfo;
    }

    public void setPictureInfo(String pictureInfo) {
        this.pictureInfo = pictureInfo;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}