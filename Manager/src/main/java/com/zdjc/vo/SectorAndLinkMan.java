package com.zdjc.vo;

import java.util.Arrays;

import com.zdjc.entity.Project;
import com.zdjc.entity.Sector;

public class SectorAndLinkMan extends Sector{

	private Integer[] alarmLinkMan;
	
	private Integer[] chargeMan;



	public Integer[] getAlarmLinkMan() {
		return alarmLinkMan;
	}

	public void setAlarmLinkMan(Integer[] alarmLinkMan) {
		this.alarmLinkMan = alarmLinkMan;
	}

	public Integer[] getChargeMan() {
		return chargeMan;
	}

	public void setChargeMan(Integer[] chargeMan) {
		this.chargeMan = chargeMan;
	}

	@Override
	public String toString() {
		return "SectorAndLinkMan [alarmLinkMan=" + Arrays.toString(alarmLinkMan) + ", chargeMan="
				+ Arrays.toString(chargeMan) + ", getSectorId()=" + getSectorId() + ", getProjectId()=" + getProjectId()
				+ ", getSectorName()=" + getSectorName() + ", getSectorType()=" + getSectorType()
				+ ", getSectorAddress()=" + getSectorAddress() + ", getSectorLongitude()=" + getSectorLongitude()
				+ ", getSectorLatitude()=" + getSectorLatitude() + ", getSectorBeginTime()=" + getSectorBeginTime()
				+ ", getSectorEndTime()=" + getSectorEndTime() + ", getSectorDescription()=" + getSectorDescription()
				+ ", getSectorStatus()=" + getSectorStatus() + ", toString()=" + super.toString() + "]";
	}

}
