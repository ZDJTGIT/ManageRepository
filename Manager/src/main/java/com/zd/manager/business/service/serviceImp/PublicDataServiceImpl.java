package com.zd.manager.business.service.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zd.manager.business.mapper.StaticLevelDataMapper;
import com.zd.manager.business.model.PublicData;
import com.zd.manager.business.model.fictitious.QueryDataCondition;
import com.zd.manager.business.service.PublicDataService;
import com.zd.manager.core.model.PaginationResult;

@Service
public class PublicDataServiceImpl implements PublicDataService {

	@Resource
	private StaticLevelDataMapper staticLevelDataMapper;

	@Override
	public PaginationResult selectData(int offset, int limit,
			QueryDataCondition conditioin) {
		Page<Object> offsetPage = PageHelper.startPage(offset, limit);
		List<PublicData> publicDatas = staticLevelDataMapper.selectData(
				conditioin.getTableName(), conditioin.getSmuCmsId(),
				conditioin.getSmuCmsChannel(), conditioin.getSensorId(),
				conditioin.getBeginTime(), conditioin.getEndTime());
		System.out.println(conditioin);
		return new PaginationResult(offsetPage.getTotal(), publicDatas);
	}

	@Override
	public boolean updatefirstData(QueryDataCondition condition) {
		int result = staticLevelDataMapper.updatefirstData(
				condition.getTableName(), condition.getSmuCmsId(),
				condition.getSmuCmsChannel(), condition.getBeginTime(),
				condition.getEndTime(), condition.getSensorId());
		System.out.println(condition);
		return result > 0 ? true : false;
	}

}
