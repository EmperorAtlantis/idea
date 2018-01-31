package com.oracle.dao;

import java.util.List;

import com.oracle.entitys.ResetPass;

public interface ResetPassMapper {
    
	
	
	/**
	 * 重置密码后删除重置密码请求
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);
	
    int insert(ResetPass record);
    

	/**
	 * 忘记密码时 请求重置密码
	 * @param resetPass
	 * @return
	 */
    int insertSelective(ResetPass record);

    ResetPass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResetPass record);

    int updateByPrimaryKey(ResetPass record);
    
    
    /**
	 * 查看重置密码请求
	 * @return List<ResetPass>
	 */
	List<ResetPass> querResetRequest();
    
    
    
    
    
    
    
    
    
    
}