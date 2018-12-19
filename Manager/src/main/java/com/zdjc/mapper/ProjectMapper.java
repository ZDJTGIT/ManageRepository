package com.zdjc.mapper;

import java.util.List;

import com.zdjc.entity.Project;

public interface ProjectMapper {
    int insert(Project record);

    int insertSelective(Project record);

	List<Project> queryAllProjects();

	int update(Project project);

	int deleteProject(Project pro);
}