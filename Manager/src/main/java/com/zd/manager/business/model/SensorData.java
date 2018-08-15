package com.zd.manager.business.model;

import java.util.Date;

public class SensorData {
    
    private Integer id;

    private Date createTime;

    private String createType;

    private String smuCmsId;

    private String smuCmsChannel;

    private String sensorId;

    private Integer sensorStatus;

    private Double sensorValue;

    private Double sensorTemperature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateType() {
        return createType;
    }

    public void setCreateType(String createType) {
        this.createType = createType;
    }

    public String getSmuCmsId() {
        return smuCmsId;
    }

    public void setSmuCmsId(String smuCmsId) {
        this.smuCmsId = smuCmsId;
    }

    public String getSmuCmsChannel() {
        return smuCmsChannel;
    }

    public void setSmuCmsChannel(String smuCmsChannel) {
        this.smuCmsChannel = smuCmsChannel;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(Integer sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public Double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(Double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Double getSensorTemperature() {
        return sensorTemperature;
    }

    public void setSensorTemperature(Double sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }
}