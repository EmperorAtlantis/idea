package com.oracle.biz;

import java.util.List;

import com.oracle.entitys.JobInfo;
import org.springframework.stereotype.Repository;

/**
 * 职位信息表业务接口
 * @author RangoLan
 *
 */
@Repository
public interface JobInfoBiz {
	
	/**
	 * 新增职位
	 * @param jobInfo
	 * @return
	 */
	int addJobInfo(JobInfo jobInfo);
	
	/**
	 * 修改职位信息
	 * @param jobInfo
	 * @return
	 */
	int updateJobInfo(JobInfo jobInfo);
	
	
	/**
	 * 删除某个职位
	 * @param jobInfoId
	 * @return
	 */
	int deleteJobInfo(String jobInfoId); 
	
	
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
	List<JobInfo>  jobsForDepartment(int departmentId);
	
}
