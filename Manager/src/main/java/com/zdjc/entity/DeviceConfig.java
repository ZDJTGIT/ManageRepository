package com.zdjc.entity;

public class DeviceConfig {
    private Integer dcId;

    private String terminalNumber;

    private String terminalChannel;

    private String sensorNumber;

    private String monitorPointNumber;

    private Integer monitorType;

    public Integer getDcId() {
        return dcId;
    }

    public void setDcId(Integer dcId) {
        this.dcId = dcId;
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
}