package com.zd.manager.business.model.fictitious;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询条件对象", description = "传感器数据查询条件对象")
public class QueryDataCondition {

	@ApiModelProperty(value = "表名", name = "tableName", required = true)
	private String tableName;

	@ApiModelProperty(value = "终端编号", name = "smuCmsId", required = true)
	private String smuCmsId;

	@ApiModelProperty(value = "终端通道", name = "smuCmsChannel", required = true)
	private String smuCmsChannel;

	@ApiModelProperty(value = "传感器编号", name = "sensorId", required = true)
	private String sensorId;

	@ApiModelProperty(value = "开始时间", name = "beginTime", required = true)
	private String beginTime;

	@ApiModelProperty(value = "结束时间", name = "endTime", required = true)
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
