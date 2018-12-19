package com.zdjc.entity;

import java.math.BigDecimal;

public class Threshold {
    private Integer thresholdId;

    private Integer sectorId;

    private Integer sectorType;

    private Integer monitorType;

    private Integer thresholdType;

    private BigDecimal minThresholdValue;

    private Double maxThresholdValue;

    private Double minDrasticThresholdValue;

    private Double maxDrasticThresholdValue;

    public Integer getThresholdId() {
        return thresholdId;
    }

    public void setThresholdId(Integer thresholdId) {
        this.thresholdId = thresholdId;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public Integer getSectorType() {
        return sectorType;
    }

    public void setSectorType(Integer sectorType) {
        this.sectorType = sectorType;
    }

    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    public Integer getThresholdType() {
        return thresholdType;
    }

    public void setThresholdType(Integer thresholdType) {
        this.thresholdType = thresholdType;
    }

    public BigDecimal getMinThresholdValue() {
        return minThresholdValue;
    }

    public void setMinThresholdValue(BigDecimal minThresholdValue) {
        this.minThresholdValue = minThresholdValue;
    }

    public Double getMaxThresholdValue() {
        return maxThresholdValue;
    }

    public void setMaxThresholdValue(Double maxThresholdValue) {
        this.maxThresholdValue = maxThresholdValue;
    }

    public Double getMinDrasticThresholdValue() {
        return minDrasticThresholdValue;
    }

    public void setMinDrasticThresholdValue(Double minDrasticThresholdValue) {
        this.minDrasticThresholdValue = minDrasticThresholdValue;
    }

    public Double getMaxDrasticThresholdValue() {
        return maxDrasticThresholdValue;
    }

    public void setMaxDrasticThresholdValue(Double maxDrasticThresholdValue) {
        this.maxDrasticThresholdValue = maxDrasticThresholdValue;
    }
}