package com.zd.manager.business.model;

public class StatisticChart {
	private Integer statisticChartId;

	private Integer projectId;

	private Integer detectionTypeId;

	private String detectionTypeName;

	private String tableName;

	private String attributes;

	private String sensorId;

	public Integer getStatisticChartId() {
		return statisticChartId;
	}

	public void setStatisticChartId(Integer statisticChartId) {
		this.statisticChartId = statisticChartId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getDetectionTypeId() {
		return detectionTypeId;
	}

	public void setDetectionTypeId(Integer detectionTypeId) {
		this.detectionTypeId = detectionTypeId;
	}

	public String getDetectionTypeName() {
		return detectionTypeName;
	}

	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
}