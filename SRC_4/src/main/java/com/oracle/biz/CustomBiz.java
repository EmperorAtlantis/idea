package com.oracle.biz;

import java.util.List;
import java.util.Map;

import com.oracle.entitys.Custom;
import org.springframework.stereotype.Repository;

/**
 * 客户表业务接口
 * @author RangoLan
 *
 */
@Repository
public interface CustomBiz {
	
	/**
	 * 新增客户
	 * @param custom
	 * @return
	 */
	int addCustom(Custom custom);
	
	/**
	 * 按条件搜索客户 
	 * @param custom createdate导入日期,customstatu客户状态,phoneno手机号,name客户姓名,invitename邀约人姓名
	 * @return List<Custom>
	 */
	List<Custom> queryByCondition(Custom custom, int page, int rows);
	
	
	/**
	 * 修改客户信息
	 * @param custom
	 * @return
	 */
	int updateCustom(Custom custom);
	
	
	/**
	 * 根据客户id 更新客户状态
	 * @param customIds 如(1,2,3)
	 * @return
	 */
	int updateCustomStatu(String customIds, String statu);
	
	
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
	 * 根据客户的姓名和手机号检查用户是否存在
	 * @param custom:name phoneNo 
	 * @return true 不存在 false 存在
	 */
	boolean checkCutomExist(Custom custom);
	
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
