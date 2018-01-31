
package com.oracle.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oracle.entitys.CustomInfo;
import org.springframework.stereotype.Repository;

/**
 * 客户信息表业务接口
 * @author RangoLan
 *
 */
@Repository
public interface CustomInfoBiz {
	
	/**
	 * 为TMK销售员工分配一个客户
	 * @param customId
	 * @param followManId
	 * @return
	 */
	int addCustomInfo(int customId, int followManId);
	
	/**
	 * 更新客户信息表记录
	 * @param customInfo
	 * @return
	 */
	int updateCustomInfo(CustomInfo customInfo);
	
	
	/**
	 * 批量删除CustomInfo
	 * @param customInfoIds 如(1,2,3)
	 * @return
	 */
	//int deleteCustomInfos(String customInfoIds);
	
	
	/**
	 * 删除单条客户信息表记录
	 * @param customInfoId
	 * @return
	 */
	//int deleteSingleCustomInfo(String customInfoId);
	
	
	
	/**
	 * 按条件搜索客户信息表记录
	 * @param customInfo
	 * @param rows
	 * @param page
	 * @return
	 */
	List<CustomInfo> CustomInfosByCondition(CustomInfo customInfo, int rows, int page);
	
	
	/**
	 * 查询符合条件的记录数
	 * @param customInfo
	 * @return
	 */
	Integer countByCondition(@Param("customInfo") CustomInfo customInfo);
	
	
	/**
	 * 查询员工本月截至当前的统计数据
	 * 依次为：本月上门多少，未通多少，死单多少，紧跟多少，总分配多少。
	 * @param emlpoyeeId
	 * @return
	 */
	Map<String,Object> callCountAtNow(int emlpoyeeId);
	
	
	
	/**
	 * 查询员工本月截至当前的统计数据
	 * 依次为：本月上门多少，未通多少，死单多少，紧跟多少，总分配多少。
	 * @param departmentId 部门Id  电销部门 或者网咨部门
	 * @return
	 */
	Map<String,Object> countForSales(int departmentId);
	
	
	
	
	
	
	/**
	 * 添加备注
	 * @param customInfo
	 * @return
	 */
	int updateMark(CustomInfo customInfo);
	
	/**
	 * 查询某个TMK员工一个月的跟单记录
	 * @param followManId
	 * @return List<CustomInfo>
	 */
	List<CustomInfo> customInfoForMonth(int followManId);
	
	
	
	/**
	 * 查询某个TMK员工上周的跟单记录
	 * @param followManId
	 * @return List<CustomInfo>
	 */
	List<CustomInfo> customInfoForWeek(int followManId);
	
	
	
	
	
}
