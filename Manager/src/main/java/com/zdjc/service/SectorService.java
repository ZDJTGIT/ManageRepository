package com.zdjc.service;

import java.util.Map;

import com.zdjc.entity.Result;
import com.zdjc.vo.SectorAndLinkMan;

public interface SectorService {
	/**
	 * 获取基本信息
	 * @return 基本信息
	 */
	public Result<Map<String,Object>> getBase();
	
	public Result<String> buildSector(SectorAndLinkMan pojo);
}
