package com.zd.manager.business.mapper;

import com.zd.manager.business.model.ShowImage;

public interface ShowImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table show_image
     *
     * @mbg.generated Fri Aug 03 16:05:42 CST 2018
     */
    int deleteByPrimaryKey(Integer imageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table show_image
     *
     * @mbg.generated Fri Aug 03 16:05:42 CST 2018
     */
    int insert(ShowImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table show_image
     *
     * @mbg.generated Fri Aug 03 16:05:42 CST 2018
     */
    int insertSelective(ShowImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table show_image
     *
     * @mbg.generated Fri Aug 03 16:05:42 CST 2018
     */
    ShowImage selectByPrimaryKey(Integer imageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table show_image
     *
     * @mbg.generated Fri Aug 03 16:05:42 CST 2018
     */
    int updateByPrimaryKeySelective(ShowImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table show_image
     *
     * @mbg.generated Fri Aug 03 16:05:42 CST 2018
     */
    int updateByPrimaryKey(ShowImage record);
}