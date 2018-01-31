package com.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oracle.entitys.JobInfo;

public interface JobInfoMapper {
	

	/**
	 * 删除某个职位
	 * @param jobInfoId
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
    
    
    int insert(JobInfo record);
    
    /**
	 * 新增职位
	 * @param jobInfo
	 * @return
	 */
    int insertSelective(JobInfo record);
    
    JobInfo selectByPrimaryKey(Integer id);
    
    /**
	 * 修改职位信息
	 * @param jobInfo
	 * @return
	 */
    int updateByPrimaryKeySelective(JobInfo record);

    int updateByPrimaryKey(JobInfo record);
    
    
    /**
	 * 查询除超级管理员和管理员为的职位
	 * @return List<JobInfo>
	 */
	List<JobInfo> allJobInfo();
	
	
	/**
	 * 查询某个部门的所有职位
	 * @param departmentId
	 * @return
	 */
	List<JobInfo>  jobsForDepartment(@Param("departmentId") int departmentId);
	
	
	
    
    
}