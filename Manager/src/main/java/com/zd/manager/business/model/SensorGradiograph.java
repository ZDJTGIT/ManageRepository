package com.zd.manager.business.model;

public class SensorGradiograph {
    private Integer sensorId;

    private Integer projectId;

    private String monitorPoint;

    private String smuNumber;

    private String smuChannel;

    private String sensorNumber;

    private String sensorType;

    private String sensorModel;

    private String sensorLongitude;

    private String sensorLatitude;

    private String sensorPlace;

    private Float sensorDepth;

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getMonitorPoint() {
        return monitorPoint;
    }

    public void setMonitorPoint(String monitorPoint) {
        this.monitorPoint = monitorPoint;
    }

    public String getSmuNumber() {
        return smuNumber;
    }

    public void setSmuNumber(String smuNumber) {
        this.smuNumber = smuNumber;
    }

    public String getSmuChannel() {
        return smuChannel;
    }

    public void setSmuChannel(String smuChannel) {
        this.smuChannel = smuChannel;
    }

    public String getSensorNumber() {
        return sensorNumber;
    }

    public void setSensorNumber(String sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorModel() {
        return sensorModel;
    }

    public void setSensorModel(String sensorModel) {
        this.sensorModel = sensorModel;
    }

    public String getSensorLongitude() {
        return sensorLongitude;
    }

    public void setSensorLongitude(String sensorLongitude) {
        this.sensorLongitude = sensorLongitude;
    }

    public String getSensorLatitude() {
        return sensorLatitude;
    }

    public void setSensorLatitude(String sensorLatitude) {
        this.sensorLatitude = sensorLatitude;
    }

    public String getSensorPlace() {
        return sensorPlace;
    }

    public void setSensorPlace(String sensorPlace) {
        this.sensorPlace = sensorPlace;
    }

    public Float getSensorDepth() {
        return sensorDepth;
    }

    public void setSensorDepth(Float sensorDepth) {
        this.sensorDepth = sensorDepth;
    }
}