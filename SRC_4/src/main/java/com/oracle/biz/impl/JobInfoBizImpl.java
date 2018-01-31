package com.oracle.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.biz.JobInfoBiz;
import com.oracle.dao.JobInfoMapper;
import com.oracle.entitys.JobInfo;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class JobInfoBizImpl implements JobInfoBiz{
	
	@Autowired
	private JobInfoMapper jobDao;
	@Override
	public int addJobInfo(JobInfo jobInfo) {
		
		return jobDao.insertSelective(jobInfo);
	}

	@Override
	public int updateJobInfo(JobInfo jobInfo) {
		
		return jobDao.updateByPrimaryKeySelective(jobInfo);
	}

	@Override
	public int deleteJobInfo(String jobInfoId) {
		
		return jobDao.deleteByPrimaryKey(Integer.valueOf(jobInfoId));
	}

	@Override
	public List<JobInfo> allJobInfo() {
		
		return jobDao.allJobInfo();
	}

	@Override
	public List<JobInfo> jobsForDepartment(int departmentId) {
		
		return jobDao.jobsForDepartment(departmentId);
	}

}
