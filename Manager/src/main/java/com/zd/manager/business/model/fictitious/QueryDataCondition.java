package com.zd.manager.business.model.fictitious;

public class QueryDataCondition {

	private String tableName;

	private String smuCmsId;

	private String smuCmsChannel;

	private String sensorId;

	private String beginTime;

	private String endTime;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "QueryDataCondition [tableName=" + tableName + ", smuCmsId="
				+ smuCmsId + ", smuCmsChannel=" + smuCmsChannel + ", sensorId="
				+ sensorId + ", beginTime=" + beginTime + ", endTime="
				+ endTime + "]";
	}

}
