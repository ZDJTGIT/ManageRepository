package com.zdjc.mapper;

import java.util.List;

import com.zdjc.entity.User;
import com.zdjc.vo.UserVO;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
    
    User findByUsername(String username);
    
    /**
     * 查询所有用户并返回uservo模型
     * @return
     */
    List<UserVO> selectAllUser();

    /**
     *通过uservo模型 更新用户
     * @param user
     * @return
     */
	int updateUserByUserVo(UserVO user);

	/**
	 * 通过uservo模型 删除用户
	 * @param user
	 * @return
	 */
	int deleteUserByUserVo(UserVO user);
}