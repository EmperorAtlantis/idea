package com.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oracle.entitys.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    /**
	 * 新增员工
	 * @param employee username,jobInfoId,managerId,phoneNo,realname
	 * @return
	 */
	int addEmployee(Employee employee);
    
    /**
	 * 根据员工用户名删除 
	 * @param username
	 * @return
	 */
	int cancleEmployee(@Param("username") String username);
    
	/**
	 * 根据员工用户名和手机号重置员工密码
	 * @param username
	 * @param newPass
	 * @return
	 */
	int resetPass(@Param("username") String username, @Param("phoneNo") String phoneNo);
	
	/**
	 * 根据id修改密码
	 * @param employeeId
	 * @param newPass
	 * @return
	 */
	int changePass(@Param("userId") int userId, @Param("newPass") String newPass);
    
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
	
	Employee login(@Param("username") String username, @Param("pass") String pass);
	
	
	/**
	 * 检查用户名是否已存在
	 * @param username
	 * @return
	 */
	String usernameCheck(@Param("username") String username);
	
	
	/**
	 * 根据员工的用户名，检查其是否在职
	 * @param username
	 * @return
	 */
	String checkWorkStatu(@Param("username") String username);
	
	
	/**
	 * 查询某个部门除部门主管外的所有员工
	 * @param departmentId
	 * @return
	 */
	List<Employee> empForDepart(@Param("departmentId") int departmentId, @Param("managerId") int managerId);
	
	

	/**
	 * 修改用户信息
	 * @param employee
	 * @return
	 */
	int updateUser(Employee employee);
	
	
	
}