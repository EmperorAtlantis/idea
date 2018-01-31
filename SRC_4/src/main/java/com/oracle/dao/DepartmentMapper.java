package com.oracle.dao;

import java.util.List;

import com.oracle.entitys.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    
    

	/**
	 * 新增部门
	 * @param department
	 * @return
	 */
    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);
    
    /**
	 * 修改部门名称
	 * @param Department record
	 * @return
	 */
    int updateByPrimaryKey(Department record);
    
    
    
    /**
	 * 查询除技术部门外的所有部门
	 * @return List<Department>
	 */
	List<Department> allDepartment();
    
    
    
    
    
    
    
    
}