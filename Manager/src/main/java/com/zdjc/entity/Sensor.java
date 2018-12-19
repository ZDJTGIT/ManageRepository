package com.zdjc.entity;

import java.util.Date;

public class Sensor {
    private Integer sensorId;

    private String sensorNumber;

    private String manufacturer;

    private String sensorModel;

    private String sensorName;

    private String sensorRange;

    private String sensorAccuracy;

    private Date productDate;

    private Date endDate;

    private Integer sensorStatus;

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorNumber() {
        return sensorNumber;
    }

    public void setSensorNumber(String sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSensorModel() {
        return sensorModel;
    }

    public void setSensorModel(String sensorModel) {
        this.sensorModel = sensorModel;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorRange() {
        return sensorRange;
    }

    public void setSensorRange(String sensorRange) {
        this.sensorRange = sensorRange;
    }

    public String getSensorAccuracy() {
        return sensorAccuracy;
    }

    public void setSensorAccuracy(String sensorAccuracy) {
        this.sensorAccuracy = sensorAccuracy;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(Integer sensorStatus) {
        this.sensorStatus = sensorStatus;
    }
}