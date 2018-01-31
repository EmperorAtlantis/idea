package com.oracle.biz;

import java.util.List;

import com.oracle.entitys.ResetPass;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetPassBiz {

	
	/**
	 * 忘记密码时 请求重置密码
	 * @param resetPass
	 * @return
	 */
	int addResetPass(ResetPass resetPass);
	
	
	
	/**
	 * 查看重置密码请求
	 * @return List<ResetPass>
	 */
	List<ResetPass> querResetRequest();
	
	
	
	/**
	 * 重置密码后删除重置密码请求
	 * @param id
	 * @return
	 */
	int deleteResetPass(int id);
	
	
	
	
	
	
}
