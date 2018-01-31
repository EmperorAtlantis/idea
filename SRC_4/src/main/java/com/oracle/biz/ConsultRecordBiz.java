package com.oracle.biz;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oracle.entitys.ConsultRecord;


/**
 * 咨询师跟单记录表业务接口
 * @author RangoLan
 *
 */
public interface ConsultRecordBiz {

	/**
	 * 为咨询师分配一个客户
	 * 
	 * @param customId客户ID
	 * @param employeeId咨询师ID
	 * @return
	 */
	int addConsultRecord(int customId, int consultManId);
	
	
	/**
	 * 咨询师修改客户咨询结果记录
	 * @param consultStatu
	 * @param result
	 * @return
	 */
	int updateConsultRecord(ConsultRecord record);
	
	
	
	
	/**
	 * 查询所有客户咨询记录
	 * @param consultManId 咨询师id
	 * @param rows 
	 * @param page
	 * @return List<ConsultRecord> 
	 */
	List<ConsultRecord> allConsultRecords(ConsultRecord record, int rows, int page);
	
	
	
	
	/**
	 * 
	 * @param record 携带参数 consultManId consultDate
	 * @param endDate 结束日期
	 * @param rows 
	 * @param page
	 * @return List<ConsultRecord> 
	 */
	List<ConsultRecord> ConsultRecordByDate(ConsultRecord record, Date endDate, int rows, int page);
	
	/**
	 * 根据employeeid customid 查询跟踪记录
	 * @param record
	 * @return List<ConsultRecord>
	 */
	List<ConsultRecord> ConsultRecordByParam(ConsultRecord record);
	
	
	/**
	 * 查询员工本月截至当前的统计数据
	 * 依次为：分配客户数    已报名成功客户数   死单客户数   报名后退费客户数
	 * @param emlpoyeeId
	 * @return
	 */
	Map<String,Object> consultCountAtNow(int emlpoyeeId);
	
	
	
	/**
	 * 查询员工本月截至当前的统计数据
	 * 依次为：分配客户数    已报名成功客户数   死单客户数   报名后退费客户数
	 * 
	 * @return
	 */
	Map<String,Object> CountForDepart(int departmentId);
	
	
	
	
	
	
	/**
	 * 按条件查询客户跟踪记录数
	 * @param record
	 * @param endDate
	 * @return
	 */
	int countByCondition(ConsultRecord record, Date endDate);
	
	
	/**
	 * 添加咨询备注
	 * @param record
	 * @return
	 */
	int updateResult(ConsultRecord record);
	
	
	
	/**
	 * 查询某个咨询师一个月的咨询记录
	 * @param consultManId
	 * @return
	 */
	List<ConsultRecord> ConsultRecordForMonth(int consultManId);
	
	
	
	
	/**
	 * 查询某个咨询师上周的咨询记录
	 * @param consultManId
	 * @return
	 */
	List<ConsultRecord> ConsultRecordForWeek(int consultManId);
	
	
}
