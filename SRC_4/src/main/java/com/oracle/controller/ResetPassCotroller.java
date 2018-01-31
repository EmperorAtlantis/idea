package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.biz.impl.EmployeeBizImpl;
import com.oracle.biz.impl.ResetPassBizImpl;
import com.oracle.entitys.ResetPass;

@Controller
public class ResetPassCotroller {

	@Autowired
	private ResetPassBizImpl repassBiz;

	@Autowired
	private EmployeeBizImpl empBiz;

	@RequestMapping("querRestRequest")
	@ResponseBody
	public List<ResetPass> querRestRequest() {

		System.out.println("请求查询所有重置密码请求");

		return repassBiz.querResetRequest();
	}

	@RequestMapping("resetPass")
	@ResponseBody
	public String resetPass(ResetPass resetPass) {

		if (empBiz.resetPass(resetPass.getUsername(), resetPass.getPhoneNo()) == 1) {
			return repassBiz.deleteResetPass(resetPass.getId()) + "";
		}

		return "0";
	}
	
	
	@RequestMapping("reqResetPass")
	@ResponseBody
	public String reqResetPass(ResetPass resetPass){
		
		System.out.println("请求重置密码："+resetPass);
		
		
		return ""+repassBiz.addResetPass(resetPass);
	}
	
	

}
