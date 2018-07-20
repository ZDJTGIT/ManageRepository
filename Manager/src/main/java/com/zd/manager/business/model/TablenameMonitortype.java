package com.zd.manager.business.model;

public class TablenameMonitortype {
    private Integer tablenameMonitortypeId;

    private Integer monitorType;

    private String tableName;

    public Integer getTablenameMonitortypeId() {
        return tablenameMonitortypeId;
    }

    public void setTablenameMonitortypeId(Integer tablenameMonitortypeId) {
        this.tablenameMonitortypeId = tablenameMonitortypeId;
    }

    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }
}