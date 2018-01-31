package com.oracle.biz;

import java.util.List;

import com.oracle.entitys.Employee;
import org.springframework.stereotype.Repository;

/**
 * 员工业务接口
 * @author RangoLan
 *
 */
@Repository
public interface EmployeeBiz {

	/**
	 * 新增员工
	 * @param employee username,jobInfoId,managerId,phoneNo,realname
	 * @return
	 */
	int addEmployee(Employee employee);
	
	/**
	 * 根据员工用户名注销
	 * @param username
	 * @return
	 */
	int cancleEmployee(String username);
	
	
	/**
	 * 根据员工的用户名，检查其是否在职
	 * @param username
	 * @return
	 */
	String checkWorkStatu(String username);
	
	
	
	/**
	 * 根据员工用户名和手机号员工密码
	 * @param username
	 * @param newPass
	 * @return
	 */
	int resetPass(String username, String phoneNo);
	
	/**
	 * 根据id修改密码
	 * @param employeeId
	 * @param newPass
	 * @return
	 */
	int changePass(int employeeId, String newPass);
	
	
	/**
	 * 查看所有员工
	 * @return
	 */
	List<Employee> allEmployees();
	 
	
	/**
	 * 按条件搜索所有员工:username,realname,departmentId,jobInfoId
	 * @param jobId
	 * @return
	 */
	List<Employee> employeesByCondition(Employee employee);
	
	
	
	/**
	 * 登录业务
	 * 
	 * @param username
	 * @param pass
	 * @return
	 */
	
	Employee login(String username, String pass);
	
	
	
	/**
	 * 检查用户名是否已存在
	 * @param username
	 * @return username
	 */
	String usernameCheck(String username);
	
	
	/**
	 * 查询某个部门除部门主管外的所有员工
	 * @param departmentId
	 * @return
	 */
	List<Employee> empForDepart(int departmentId, int managerId);
	
	/**
	 * 修改用户信息
	 * @param employee
	 * @return
	 */
	int updateUser(Employee employee);
	
}
