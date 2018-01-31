package com.oracle.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.biz.EmployeeBiz;
import com.oracle.dao.EmployeeMapper;
import com.oracle.entitys.Employee;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class EmployeeBizImpl implements EmployeeBiz {
	
	@Autowired
	private EmployeeMapper employeeDao;
	
	/**
	 * 新增员工
	 * @param employee username,jobInfoId,managerId,phoneNo,realname
	 * @return
	 */
	@Override
	public int addEmployee(Employee employee) {
		
		return employeeDao.addEmployee(employee);
	}

	

	/**
	 * 查看所有员工
	 * @return
	 */
	@Override
	public List<Employee> allEmployees() {

		return employeeDao.allEmployees();
	}

	/**
	 * 按条件搜索所有员工:username,realname,departmentId,jobInfoId
	 * @param jobId
	 * @return
	 */
	@Override
	public List<Employee> employeesByCondition(Employee employee) {
		
		return employeeDao.employeesByCondition(employee);
	}

	@Override
	public Employee login(String username, String pass) {
		
		return employeeDao.login(username, pass);
	}

	@Override
	public int cancleEmployee(String username) {
		
		return employeeDao.cancleEmployee(username);
	}


	@Override
	public String usernameCheck(String username) {
		
		return employeeDao.usernameCheck(username);
	}


	@Override
	public String checkWorkStatu(String username) {
		
		return employeeDao.checkWorkStatu(username);
	}



	@Override
	public int resetPass(String username, String phoneNo) {
		
		return employeeDao.resetPass(username, phoneNo);
	}



	@Override
	public int changePass(int employeeId, String newPass) {
		
		return employeeDao.changePass(employeeId, newPass);
	}



	@Override
	public List<Employee> empForDepart(int departmentId, int managerId) {
		
		return employeeDao.empForDepart(departmentId, managerId);
	}



	@Override
	public int updateUser(Employee employee) {
		
		return employeeDao.updateUser(employee);
	}



	

}
