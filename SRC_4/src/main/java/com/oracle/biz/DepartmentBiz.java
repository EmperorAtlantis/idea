package com.oracle.biz;

import java.util.List;

import com.oracle.entitys.Department;
import org.springframework.stereotype.Repository;

/**
 * 
 * 部门业务接口
 * @author RangoLan
 * 
 *
 */
@Repository
public interface DepartmentBiz {
	
	/**
	 * 新增部门
	 * @param department
	 * @return
	 */
	int addDepartment(Department department);
	
	/**
	 * 修改部门名称
	 * @param dname
	 * @return
	 */
	int updateDepartment(Department department);
	
	
	/**
	 * 查询除技术部门外的所有部门
	 * @return List<Department>
	 */
	List<Department> allDepartment();
	

}
