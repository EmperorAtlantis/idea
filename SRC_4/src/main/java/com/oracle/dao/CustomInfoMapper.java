package com.oracle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.oracle.entitys.CustomInfo;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomInfo record);

    int insertSelective(CustomInfo record);

    CustomInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomInfo record);

    
    
    
    int updateByPrimaryKey(CustomInfo record);
    
    
    
    
    
    /**
	 * 按条件搜索客户信息表记录
	 * @param customInfo
	 * @param rows
	 * @param page
	 * @return
	 */
	List<CustomInfo> CustomInfosByCondition(@Param("customInfo") CustomInfo customInfo, @Param("startRow") int startRow, @Param("pageSize") int pageSize);
	
	
	/**
	 * 为TMK销售员工分配一个客户
	 * @param customId
	 * @param followManId
	 * @return
	 */
	int addCustomInfo(@Param("customId") int customId, @Param("followManId") int followManId);
	
	
	/**
	 * 更新客户信息表记录
	 * @param customInfo
	 * @return
	 */
	int updateCustomInfo(CustomInfo customInfo);
	
	
	
	/**
	 * 添加备注
	 * @param customInfo
	 * @return
	 */
	int updateMark(CustomInfo customInfo);
	
	

	/**
	 * 查询销售员工某个状态客户的统计数量
	 * @param followManId 销售员工id
	 * @param statu  客户状态0：未联系 1：未接通 2：紧跟 3：已上门4：死单 5：电话无效

	 * @return 该状态的客户的数量
	 */
	Integer countByStatu(@Param("followManId") int followManId, @Param("statu") String statu);
	
	
	

	
	
	
	/**
	 * 查询符合条件的记录数
	 * @param customInfo
	 * @return
	 */
	Integer countByCondition(@Param("customInfo") CustomInfo customInfo);
	
	
	
	/**
	 * 查询某个TMK员工一个月的跟单记录
	 * @param followManId
	 * @return List<CustomInfo>
	 */
	List<CustomInfo> customInfoForMonth(@Param("followManId") int followManId);
	
	
	
	/**
	 * 查询某个TMK员工上周的跟单记录
	 * @param followManId
	 * @return List<CustomInfo>
	 */
	List<CustomInfo> customInfoForWeek(@Param("followManId") int followManId);
	
	
	
	
	
}