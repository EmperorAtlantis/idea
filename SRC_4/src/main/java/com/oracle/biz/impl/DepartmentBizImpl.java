package com.oracle.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.biz.DepartmentBiz;
import com.oracle.dao.DepartmentMapper;
import com.oracle.entitys.Department;


@Component
@Transactional(propagation=Propagation.REQUIRED)
public class DepartmentBizImpl implements DepartmentBiz{
	
	@Autowired
	private DepartmentMapper dtDao;

	@Override
	public int addDepartment(Department department) {
		
		return dtDao.insert(department);
	}

	@Override
	public int updateDepartment(Department department) {
		
		return dtDao.updateByPrimaryKey(department);
	}

	@Override
	public List<Department> allDepartment() {
		
		return dtDao.allDepartment();
	}
	
	
	
	
	
}
