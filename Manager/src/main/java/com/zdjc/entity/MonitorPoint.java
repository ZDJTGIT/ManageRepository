package com.zdjc.entity;

public class MonitorPoint {
    private Integer mpId;

    private Integer sectorId;

    private String monitorPointNumber;

    private Integer monitorType;

    private String terminalNumber;

    private String terminalChannel;

    private String sensorNumber;

    private Integer sensorId;

    private Float sensorDeep;

    public Integer getMpId() {
        return mpId;
    }

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public String getMonitorPointNumber() {
        return monitorPointNumber;
    }

    public void setMonitorPointNumber(String monitorPointNumber) {
        this.monitorPointNumber = monitorPointNumber;
    }

    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public String getTerminalChannel() {
        return terminalChannel;
    }

    public void setTerminalChannel(String terminalChannel) {
        this.terminalChannel = terminalChannel;
    }

    public String getSensorNumber() {
        return sensorNumber;
    }

    public void setSensorNumber(String sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Float getSensorDeep() {
        return sensorDeep;
    }

    public void setSensorDeep(Float sensorDeep) {
        this.sensorDeep = sensorDeep;
    }
}