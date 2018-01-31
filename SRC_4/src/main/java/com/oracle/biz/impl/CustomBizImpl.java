package com.oracle.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.biz.CustomBiz;
import com.oracle.dao.CustomMapper;
import com.oracle.entitys.Custom;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class CustomBizImpl implements CustomBiz {
	
	@Autowired
	private CustomMapper customDao;
	
	/**
	 * 新增客户
	 * @param custom
	 * @return
	 */
	@Override
	public int addCustom(Custom custom) {
		return customDao.insert(custom);
	}

	/**
	 * 按条件搜索客户 
	 * @param custom createdate导入日期,customstatu客户状态,phoneno手机号,name客户姓名,invitename邀约人姓名
	 * @return List<Custom>
	 */
	@Override
	public List<Custom> queryByCondition(Custom custom,int page,int rows) {
		return customDao.queryByCondition(custom,(page-1)*rows,rows);
	}

	/**
	 * 修改客户信息
	 * @param custom
	 * @return
	 */
	@Override
	public int updateCustom(Custom custom) {
		return customDao.updateByPrimaryKeySelective(custom);
	}

	

	@Override
	public int totalByCondition(Custom custom) {
		
		return customDao.totalByCondition(custom);
	}

	@Override
	public List<Integer> customIdsByStatu(String customStatu) {
		
		return customDao.customIdsByStatu(customStatu);
	}

	@Override
	public int updateCustomStatu(String customIds,String statu) {
		
		return customDao.updateCustomStatu(customIds, statu);
	}

	@Override
	public boolean checkCutomExist(Custom custom) {
		
		return customDao.checkCutomExist(custom)==null;
	}

	@Override
	public List<Custom> customsForMonth() {
		
		return customDao.customsForMonth();
	}

	@Override
	public List<Custom> customsForWeek() {
		
		return customDao.customsForWeek();
	}

}
