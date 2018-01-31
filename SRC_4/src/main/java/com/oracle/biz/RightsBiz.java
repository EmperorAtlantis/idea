package com.oracle.biz;

import java.util.List;

import com.oracle.entitys.Rights;
import org.springframework.stereotype.Repository;

/**
 * 权限业务接口
 * @author RangoLan
 *
 */
@Repository
public interface RightsBiz {

	
	/**
	 * 新增权限
	 * @param right
	 * @return
	 */
	int addRight(Rights right);
	
	
	/**
	 * 查询所有权限
	 * @return
	 */
	List<Rights> allRights();
	
	/**
	 * 根据权限id 删除权限
	 * @param rid
	 * @return
	 */
	int deleteRight(int rid);
	
	
	/**
	 * 更新权限
	 * @param right
	 * @return
	 */
	int updateRight(Rights right);
	
	
	
	/**
	 * 查询某职位对应的权限
	 * @param jobInfoId 职位id
	 * @return
	 */
	List<Rights> rightsForJob(int jobInfoId);
	
	
	
	
}
