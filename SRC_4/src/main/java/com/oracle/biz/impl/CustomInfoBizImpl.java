package com.oracle.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.biz.CustomInfoBiz;
import com.oracle.dao.CustomInfoMapper;
import com.oracle.dao.EmployeeMapper;
import com.oracle.entitys.CustomInfo;
import com.oracle.entitys.Employee;


@Component
@Transactional(propagation=Propagation.REQUIRED)
public class CustomInfoBizImpl implements CustomInfoBiz{

	
	@Autowired
	private CustomInfoMapper cinfoDao;
	
	@Autowired
	private EmployeeMapper empDao;
	
	
	@Override
	public int addCustomInfo(int customId, int followManId) {
		
		return cinfoDao.addCustomInfo(customId, followManId);
	}

	@Override
	public int updateCustomInfo(CustomInfo customInfo) {
		
		return cinfoDao.updateCustomInfo(customInfo);
	}

	

	@Override
	public List<CustomInfo> CustomInfosByCondition(CustomInfo customInfo,
			int rows, int page) {
		
		return cinfoDao.CustomInfosByCondition(customInfo, (page-1)*rows, rows);
	}

	@Override
	public Map<String, Object> callCountAtNow(int emlpoyeeId) {
		Map<String, Object> map=new HashMap<String, Object>();
		Integer visited = cinfoDao.countByStatu(emlpoyeeId, "3");
		Integer disConnect = cinfoDao.countByStatu(emlpoyeeId, "1");
		Integer following = cinfoDao.countByStatu(emlpoyeeId, "2");
		Integer denied = cinfoDao.countByStatu(emlpoyeeId, "4");
		
		Integer invalid=cinfoDao.countByStatu(emlpoyeeId, "5");
		Integer newAllot = cinfoDao.countByStatu(emlpoyeeId, "0");
		
		Integer total=visited+disConnect+following+denied+newAllot;
		
		
		map.put("newAllot", newAllot);
		map.put("visited", visited);
		map.put("disConnect", disConnect);
		map.put("following", following);
		map.put("denied", denied);
		map.put("invalid", invalid);
		map.put("total", total);
		return map;
	}

	@Override
	public Integer countByCondition(CustomInfo customInfo) {
		
		return cinfoDao.countByCondition(customInfo);
	}

	@Override
	public int updateMark(CustomInfo customInfo) {
		
		return cinfoDao.updateMark(customInfo);
	}

	@Override
	public List<CustomInfo> customInfoForMonth(int followManId) {
		
		return cinfoDao.customInfoForMonth(followManId);
	}

	@Override
	public List<CustomInfo> customInfoForWeek(int followManId) {
		
		return cinfoDao.customInfoForWeek(followManId);
	}

	@Override
	public Map<String, Object> countForSales(int departmentId) {
		Map<String, Object> map=new HashMap<String, Object>();
		Employee employee = new Employee();
		employee.setDepartmentId(departmentId);
		List<Employee> elist = empDao.employeesByCondition(employee);
		
		Integer visited = 0;
		Integer disConnect = 0;
		Integer following = 0;
		Integer denied = 0;
		Integer newAllot = 0;
		Integer invalid=0;
		
		for (Employee e : elist) {
			visited+=cinfoDao.countByStatu(e.getId(), "3");
			disConnect+=cinfoDao.countByStatu(e.getId(), "1");
			following+=cinfoDao.countByStatu(e.getId(), "2");
			denied+=cinfoDao.countByStatu(e.getId(), "4");
			newAllot+=cinfoDao.countByStatu(e.getId(), "0");
			invalid+=cinfoDao.countByStatu(e.getId(), "5");
		}
		
		Integer total=visited+disConnect+following+denied+newAllot;
		
		map.put("newAllot", newAllot);
		map.put("visited", visited);
		map.put("disConnect", disConnect);
		map.put("following", following);
		map.put("denied", denied);
		map.put("total", total);
		map.put("invalid", invalid);
		
		
		return map;
	}

}
