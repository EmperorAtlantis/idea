package com.oracle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.oracle.entitys.Custom;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomMapper {
    
	
	int deleteByPrimaryKey(Integer id);
    int insert(Custom record);

    /**
     * 动态新增客户
     * @param custom
     * @return
     */
    int insertSelective(Custom record);

    Custom selectByPrimaryKey(Integer id);
    
    /**
	 * 修改客户信息
	 * @param custom
	 * @return
	 */
    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);
    
    
    /**
	 * 按条件搜索客户 
	 * @param custom createdate导入日期,customstatu客户状态,phoneno手机号,name客户姓名,invitename邀约人姓名
	 * @return List<Custom>
	 */
	List<Custom> queryByCondition(@Param("custom") Custom custom, @Param("startRow") int startRow, @Param("pageSize") int pageSize);
	
	/**
	 * 分配客户
	 * @param customIds
	 * @param empIds
	 * @return
	 */
	int allotCustom(List<Integer> customIds, List<Integer> empIds);
	
	
	
	/**
	 * 条件查询客户数目
	 * @param custom
	 * @return
	 */
	int totalByCondition(Custom custom);
	
	
	/**
	 * 客户状态查询客户的id
	 * @param customStatu
	 * @return List<Integer> 客户id的list
	 */
	List<Integer> customIdsByStatu(String customStatu);
	
	/**
	 * 根据客户id 更新客户状态
	 * @param customIds 如(1,2,3)
	 * @return
	 */
	int updateCustomStatu(@Param("customIds") String customIds, @Param("statu") String statu);
	
	
	/**
	 * 根据客户的姓名和手机号检查用户是否存在
	 * @param custom:name phoneNo 
	 * @return name
	 */
	String checkCutomExist(Custom custom);
	
	
	/**
	 * 导出本周的所有客户
	 * @return
	 */
	List<Custom> customsForMonth();
	
	
	/**
	 * 导出本周的所有客户
	 * @return List<Map<String,Object>> 
	 */
	List<Custom> customsForWeek();
	
    
}