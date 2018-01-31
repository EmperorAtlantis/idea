package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.biz.impl.DepartmentBizImpl;
import com.oracle.entitys.Department;


@Controller
public class DepartmentController {

	@Autowired
	private DepartmentBizImpl dtBiz;
	
	
	@RequestMapping("getDepartment")
	@ResponseBody
	public List<Department> getDepartments(){
		
		System.out.println("请求查询除技术部外的所有部门");
		
		
		return dtBiz.allDepartment();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
