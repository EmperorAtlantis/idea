package com.oracle.biz.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.biz.ConsultRecordBiz;
import com.oracle.dao.ConsultRecordMapper;
import com.oracle.dao.EmployeeMapper;
import com.oracle.entitys.ConsultRecord;
import com.oracle.entitys.Employee;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class ConsultBizImpl implements ConsultRecordBiz{

	@Autowired
	private ConsultRecordMapper crDao;
	
	@Autowired
	private EmployeeMapper empDao;
	
	
	
	
	@Override
	public int addConsultRecord(int customId, int consultManId) {
		
		return crDao.addConsultRecord(customId, consultManId);
	}

	@Override
	public int updateConsultRecord(ConsultRecord record) {
	
		return crDao.updateConsultRecord(record);
	}

	@Override
	public List<ConsultRecord> allConsultRecords(ConsultRecord record,
			int rows, int page) {
		
		return crDao.allConsultRecords(record, (page-1)*rows, rows);
	}

	@Override
	public List<ConsultRecord> ConsultRecordByDate(ConsultRecord record,
			Date endDate, int rows, int page) {
	
		return crDao.ConsultRecordByDate(record, endDate, (page-1)*rows, rows);
	}

	@Override
	public Map<String, Object> consultCountAtNow(int emlpoyeeId) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		 Integer following = crDao.countByStatu(emlpoyeeId, "1");
		 Integer signed = crDao.countByStatu(emlpoyeeId, "2");
		 Integer denied = crDao.countByStatu(emlpoyeeId, "3");
		 Integer refundment = crDao.countByStatu(emlpoyeeId, "4");
		 Integer newAllot=crDao.countByStatu(emlpoyeeId, "0");
		map.put("following", following);
		map.put("signed", signed);
		map.put("denied", denied);
		map.put("refundment", refundment);
		map.put("newAllot", newAllot);
		map.put("total", following+signed+denied+refundment+newAllot);
		
		
		return map;
	}

	@Override
	public List<ConsultRecord> ConsultRecordByParam(ConsultRecord record) {
		
		return crDao.ConsultRecordByParam(record);
	}

	@Override
	public int countByCondition(ConsultRecord record, Date endDate) {
	
		return crDao.countByCondition(record, endDate);
	}

	@Override
	public int updateResult(ConsultRecord record) {
		
		return crDao.updateResult(record);
	}

	@Override
	public List<ConsultRecord> ConsultRecordForMonth(int consultManId) {
		
		return crDao.ConsultRecordForMonth(consultManId);
	}

	@Override
	public List<ConsultRecord> ConsultRecordForWeek(int consultManId) {
		
		return crDao.ConsultRecordForWeek(consultManId);
	}

	@Override
	public Map<String, Object> CountForDepart(int departmentId) {
		Map<String, Object> map=new HashMap<String, Object>();
		
		Employee employee = new Employee();
		employee.setDepartmentId(departmentId);
		List<Employee> elist = empDao.employeesByCondition(employee);
		Integer following =0;
		Integer signed =0;
		Integer denied = 0;
		Integer refundment =0;
		Integer newAllot=0;
		
		for (Employee e : elist) {
			following += crDao.countByStatu(e.getId(), "1");
			signed += crDao.countByStatu(e.getId(), "2");
			denied += crDao.countByStatu(e.getId(), "3");
			newAllot+=crDao.countByStatu(e.getId(), "0");
			refundment += crDao.countByStatu(e.getId(), "4");
		}
		 
		map.put("following", following);
		map.put("signed", signed);
		map.put("denied", denied);
		map.put("refundment", refundment);
		map.put("newAllot", newAllot);
		map.put("total", following+signed+denied+refundment+newAllot);
		
		
		return map;
		
	}

}
