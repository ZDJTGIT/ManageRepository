package com.zdjc.mapper;

import java.util.List;

import com.zdjc.entity.Sector;

public interface SectorMapper {
    int insert(Sector record);

    int insertSelective(Sector record);

    /**
     * 查询所有地铁区间
     * @return
     */
	List<Sector> querySubwaySectors();

	/**
	 * 更新区间
	 * @param entity
	 * @return
	 */
	int updateSector(Sector entity);
}