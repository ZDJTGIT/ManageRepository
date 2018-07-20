package com.zd.manager.business.model;

import java.util.Date;

public class StaticLevelData {
    private Integer id;

    private String sensorId;

    private Date firstTime;

    private Double firstData;

    private Date previousTime;

    private Double previousData;

    private Date currentTimes;

    private Double currentData;

    private Double currentTemperature;

    private Double currentLaserChange;

    private Double totalLaserChange;

    private Double speedChange;

    private Integer sensorStatus;

    private String createType;

    private String smuCmsId;

    private String smuCmsChannel;

    private Integer smuStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId == null ? null : sensorId.trim();
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Double getFirstData() {
        return firstData;
    }

    public void setFirstData(Double firstData) {
        this.firstData = firstData;
    }

    public Date getPreviousTime() {
        return previousTime;
    }

    public void setPreviousTime(Date previousTime) {
        this.previousTime = previousTime;
    }

    public Double getPreviousData() {
        return previousData;
    }

    public void setPreviousData(Double previousData) {
        this.previousData = previousData;
    }

    public Date getCurrentTimes() {
        return currentTimes;
    }

    public void setCurrentTimes(Date currentTimes) {
        this.currentTimes = currentTimes;
    }

    public Double getCurrentData() {
        return currentData;
    }

    public void setCurrentData(Double currentData) {
        this.currentData = currentData;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getCurrentLaserChange() {
        return currentLaserChange;
    }

    public void setCurrentLaserChange(Double currentLaserChange) {
        this.currentLaserChange = currentLaserChange;
    }

    public Double getTotalLaserChange() {
        return totalLaserChange;
    }

    public void setTotalLaserChange(Double totalLaserChange) {
        this.totalLaserChange = totalLaserChange;
    }

    public Double getSpeedChange() {
        return speedChange;
    }

    public void setSpeedChange(Double speedChange) {
        this.speedChange = speedChange;
    }

    public Integer getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(Integer sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public String getCreateType() {
        return createType;
    }

    public void setCreateType(String createType) {
        this.createType = createType == null ? null : createType.trim();
    }

    public String getSmuCmsId() {
        return smuCmsId;
    }

    public void setSmuCmsId(String smuCmsId) {
        this.smuCmsId = smuCmsId == null ? null : smuCmsId.trim();
    }

    public String getSmuCmsChannel() {
        return smuCmsChannel;
    }

    public void setSmuCmsChannel(String smuCmsChannel) {
        this.smuCmsChannel = smuCmsChannel == null ? null : smuCmsChannel.trim();
    }

    public Integer getSmuStatus() {
        return smuStatus;
    }

    public void setSmuStatus(Integer smuStatus) {
        this.smuStatus = smuStatus;
    }
}