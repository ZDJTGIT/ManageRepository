package com.zdjc.entity;

import java.util.Date;

public class InventoryRecord {
    private Integer irId;

    private Integer userId;

    private String deviceNumber;

    private Integer deviceType;

    private Integer outAndIn;

    private Date createDate;

    public Integer getIrId() {
        return irId;
    }

    public void setIrId(Integer irId) {
        this.irId = irId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getOutAndIn() {
        return outAndIn;
    }

    public void setOutAndIn(Integer outAndIn) {
        this.outAndIn = outAndIn;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}