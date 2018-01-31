package com.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oracle.entitys.Rights;

public interface RightsMapper {
	
	
	/**
	 * 根据权限id 删除权限
	 * @param rid
	 * @return
	 */
    int deleteByPrimaryKey(Integer rid);
    
    int insert(Rights record);
    
    /**
     * 动态插入一条权限
     * @param record
     * @return
     */
    int insertSelective(Rights record);

    Rights selectByPrimaryKey(Integer rid);
    
    /**
     * 动态更新Right
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Rights record);

    int updateByPrimaryKey(Rights record);
    
    /**
	 * 查询所有权限
	 * @return
	 */
	List<Rights> allRights();
	
	
	/**
	 * 查询某职位对应的权限
	 * @param jobInfoId 职位id
	 * @return
	 */
	List<Rights> rightsForJob(@Param("jobInfoId") int jobInfoId);
	
	
	
	
}