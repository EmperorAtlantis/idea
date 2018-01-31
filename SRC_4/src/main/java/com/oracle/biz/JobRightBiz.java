package com.oracle.biz;

import java.util.List;

import com.oracle.entitys.Rights;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRightBiz {

	/**
	 * 增加职位权限
	 * @param jobInfoid
	 * @param rightid
	 * @return
	 */
	int addRightForJob(int jobInfoid, int rightid);
	
	/**
	 * 修改职位权限
	 * @param jobInfoid
	 * @param rightid
	 * @return
	 */
	int updateRightForJob(int jobInfoid, int rightid);
	
	/**
	 * 删除职位权限
	 * @param jobInfoid
	 * @param rightid
	 * @return
	 */
	int deleteRightForJob(int jobInfoid, int rightid);
	
	/**
	 * 查询指定职位的所有权限
	 * @param jobInfoid
	 * @return
	 */
	List<Rights> rightsforJobInfoId(int jobInfoid);
	
}
