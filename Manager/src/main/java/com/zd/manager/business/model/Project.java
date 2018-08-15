package com.zd.manager.business.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Project implements Serializable{
	private Integer projectId;
	private String projectName;
	private Integer projectType;
	private String projectAddress;
	private String weatherAddress;
	private String projectLongitude;
	private String projectLatitude;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date projectBeginTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date projectEndTime;
	private Integer projectStatus;
	private String projectDescription;
	private String projectImageUrl;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public String getWeatherAddress() {
		return weatherAddress;
	}

	public void setWeatherAddress(String weatherAddress) {
		this.weatherAddress = weatherAddress;
	}

	public String getProjectLongitude() {
		return projectLongitude;
	}

	public void setProjectLongitude(String projectLongitude) {
		this.projectLongitude = projectLongitude;
	}

	public String getProjectLatitude() {
		return projectLatitude;
	}

	public void setProjectLatitude(String projectLatitude) {
		this.projectLatitude = projectLatitude;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getProjectBeginTime() {
		return projectBeginTime;
	}

	public void setProjectBeginTime(Date projectBeginTime) {
		this.projectBeginTime = projectBeginTime;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getProjectEndTime() {
		return projectEndTime;
	}

	public void setProjectEndTime(Date projectEndTime) {
		this.projectEndTime = projectEndTime;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectImageUrl() {
		return projectImageUrl;
	}
	
	public void setProjectImageUrl(String projectImageUrl) {
		this.projectImageUrl = projectImageUrl;
	}

	private static final long serialVersionUID = 1L;
}