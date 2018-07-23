package com.zd.manager.business.service;

import com.zd.manager.business.model.fictitious.QueryDataCondition;
import com.zd.manager.core.model.PaginationResult;

public interface PublicDataService {

	/**
	 * 查询传感器数据
	 * 
	 * @param offset
	 * @param limit
	 * @param conditioin
	 * @return
	 */
	PaginationResult selectData(int offset, int limit,
			QueryDataCondition conditioin);

	/**
	 * 修改zdjc数据库的数据表第一次数据
	 * 
	 * @param tableName
	 * @param smuCmsId
	 * @param beginTimes
	 * @param endTimes
	 * @param sensorNumber
	 * @return
	 */
	boolean updatefirstData(QueryDataCondition condition);

}
