package com.zd.manager.business.mapper;

import com.zd.manager.business.model.ProjectImagesRelation;

public interface ProjectImagesRelationMapper {
    int deleteByPrimaryKey(Integer projectImagesRelationId);

    int insert(ProjectImagesRelation record);

    int insertSelective(ProjectImagesRelation record);

    ProjectImagesRelation selectByPrimaryKey(Integer projectImagesRelationId);

    int updateByPrimaryKeySelective(ProjectImagesRelation record);

    int updateByPrimaryKey(ProjectImagesRelation record);
}