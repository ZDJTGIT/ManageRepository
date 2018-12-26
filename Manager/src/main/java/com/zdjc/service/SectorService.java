package com.zdjc.service;

import java.util.List;
import java.util.Map;

import com.zdjc.entity.Result;
import com.zdjc.entity.Sector;
import com.zdjc.vo.SectorAndLinkMan;
import com.zdjc.vo.subway.sector.AddSectorVO;
import com.zdjc.vo.subway.sector.UpdateSectorVO;

public interface SectorService {
	/**
	 * 获取基本信息
	 * @return 基本信息
	 */
	public Result<Map<String,Object>> getBase();
	
	public Result<String> buildSector(SectorAndLinkMan pojo);

	/**
	 * 获取所有地铁区间信息
	 * @return
	 */
	public Result<List<Sector>> getSubwaySectors();

	/**
	 * 新增地铁区间信息
	 * @param entity
	 * @return
	 */
	public Result<String> addSubwaySector(AddSectorVO entity);

	/**
	 * 更新地铁区间信息
	 * @param entity
	 * @return
	 */
	public Result<String> updateSubwaySector(UpdateSectorVO entity);
}
