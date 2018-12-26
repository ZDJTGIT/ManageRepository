package com.zdjc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author KStar--1143574134@qq.com
 *
 * @data 2018年12月24日 下午3:40:43
 */
/**
 * @author KStar--1143574134@qq.com
 *
 * @data 2018年12月25日 上午9:14:29
 */
public class Sector {
    private Integer sectorId;

    private Integer projectId;

    private String sectorName;

    private Integer sectorType;

    private String sectorAddress;

    private String sectorLongitude;

    private String sectorLatitude;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sectorBeginTime;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sectorEndTime;

    private String sectorDescription;

    private Integer sectorStatus;

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public Integer getSectorType() {
        return sectorType;
    }

    public void setSectorType(Integer sectorType) {
        this.sectorType = sectorType;
    }

    public String getSectorAddress() {
        return sectorAddress;
    }

    public void setSectorAddress(String sectorAddress) {
        this.sectorAddress = sectorAddress;
    }

    public String getSectorLongitude() {
        return sectorLongitude;
    }

    public void setSectorLongitude(String sectorLongitude) {
        this.sectorLongitude = sectorLongitude;
    }

    public String getSectorLatitude() {
        return sectorLatitude;
    }

    public void setSectorLatitude(String sectorLatitude) {
        this.sectorLatitude = sectorLatitude;
    }

    public Date getSectorBeginTime() {
        return sectorBeginTime;
    }

    public void setSectorBeginTime(Date sectorBeginTime) {
        this.sectorBeginTime = sectorBeginTime;
    }

    public Date getSectorEndTime() {
        return sectorEndTime;
    }

    public void setSectorEndTime(Date sectorEndTime) {
        this.sectorEndTime = sectorEndTime;
    }

    public String getSectorDescription() {
        return sectorDescription;
    }

    public void setSectorDescription(String sectorDescription) {
        this.sectorDescription = sectorDescription;
    }

    public Integer getSectorStatus() {
        return sectorStatus;
    }

    public void setSectorStatus(Integer sectorStatus) {
        this.sectorStatus = sectorStatus;
    }

	@Override
	public String toString() {
		return "Sector [sectorId=" + sectorId + ", projectId=" + projectId + ", sectorName=" + sectorName
				+ ", sectorType=" + sectorType + ", sectorAddress=" + sectorAddress + ", sectorLongitude="
				+ sectorLongitude + ", sectorLatitude=" + sectorLatitude + ", sectorBeginTime=" + sectorBeginTime
				+ ", sectorEndTime=" + sectorEndTime + ", sectorDescription=" + sectorDescription + ", sectorStatus="
				+ sectorStatus + "]";
	}
    
    

}