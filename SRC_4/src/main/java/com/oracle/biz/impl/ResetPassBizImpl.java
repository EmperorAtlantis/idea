package com.oracle.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.biz.ResetPassBiz;
import com.oracle.dao.ResetPassMapper;
import com.oracle.entitys.ResetPass;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class ResetPassBizImpl implements ResetPassBiz{
	
	@Autowired
	private ResetPassMapper rePassDao;
	
	
	
	
	@Override
	public int addResetPass(ResetPass resetPass) {
		
		return rePassDao.insertSelective(resetPass);
	}

	@Override
	public List<ResetPass> querResetRequest() {
		
		return rePassDao.querResetRequest();
	}

	@Override
	public int deleteResetPass(int id) {
		
		return rePassDao.deleteByPrimaryKey(id);
	}

}
