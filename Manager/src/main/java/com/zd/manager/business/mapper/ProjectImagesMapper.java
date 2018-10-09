package com.zd.manager.business.mapper;

import com.zd.manager.business.model.ProjectImages;

public interface ProjectImagesMapper {
    int deleteByPrimaryKey(Integer projectImageId);

    int insert(ProjectImages record);

    int insertSelective(ProjectImages record);

    ProjectImages selectByPrimaryKey(Integer projectImageId);

    int updateByPrimaryKeySelective(ProjectImages record);

    int updateByPrimaryKey(ProjectImages record);
}