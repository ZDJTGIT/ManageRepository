package com.zd.manager.business.mapper;

import com.zd.manager.business.model.Project;

public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Jul 10 10:42:30 CST 2018
     */
    int deleteByPrimaryKey(Integer projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Jul 10 10:42:30 CST 2018
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Jul 10 10:42:30 CST 2018
     */
    int insertSelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Jul 10 10:42:30 CST 2018
     */
    Project selectByPrimaryKey(Integer projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Jul 10 10:42:30 CST 2018
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Jul 10 10:42:30 CST 2018
     */
    int updateByPrimaryKey(Project record);
}