package com.oracle.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.biz.RightsBiz;
import com.oracle.dao.RightsMapper;
import com.oracle.entitys.Rights;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class RightsBizImpl implements RightsBiz{
	
	@Autowired
	private RightsMapper rtsDao;

	@Override
	public int addRight(Rights right) {
		
		return rtsDao.insertSelective(right);
	}

	@Override
	public List<Rights> allRights() {
		
		return rtsDao.allRights();
	}

	@Override
	public int deleteRight(int rid) {
		
		return rtsDao.deleteByPrimaryKey(rid);
	}

	@Override
	public int updateRight(Rights right) {
		
		return rtsDao.updateByPrimaryKeySelective(right);
	}

	@Override
	public List<Rights> rightsForJob(int jobInfoId) {
		
		return rtsDao.rightsForJob(jobInfoId);
	}
	
	
	
	
	
	
}
