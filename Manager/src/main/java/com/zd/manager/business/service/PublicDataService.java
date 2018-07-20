package com.zd.manager.business.service;

import com.zd.manager.business.model.fictitious.QueryDataCondition;
import com.zd.manager.core.model.PaginationResult;

public interface PublicDataService {

	PaginationResult selectData(int offset, int limit,
			QueryDataCondition conditioin);

}
