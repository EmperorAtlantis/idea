package com.oracle.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oracle.entitys.ConsultRecord;
import com.oracle.entitys.CustomInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsultRecord record);

    int insertSelective(ConsultRecord record);

    ConsultRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsultRecord record);

    
    
    /**
	 * 咨询师修改客户咨询结果记录
	 * @param consultStatu
	 * @param result
	 * @return
	 */
    int updateConsultRecord(ConsultRecord record);
    
    
    
    /**
	 * 为咨询师分配一个客户
	 * 
	 * @param customId客户ID
	 * @param employeeId咨询师ID
	 * @return
	 */
	int addConsultRecord(@Param("customId") int customId, @Param("consultManId") int consultManId);
	
	
	
	
	/**
	 * 查询所有客户咨询记录
	 * @param consultManId 咨询师id
	 * @param startRow 
	 * @param pageSize
	 * @return List<ConsultRecord> 
	 */
	List<ConsultRecord> allConsultRecords(@Param("record") ConsultRecord record, @Param("startRow") int startRow, @Param("pageSize") int pageSize);
	
	/**
	 * 查询咨询师某个状态客户的统计数量
	 * @param consultManId 咨询师id
	 * @param consultStatu 客户咨询状态 0：新增 1 ：紧跟  2：已报名  3：死单  4:报名后退费
	 * @return 该状态的客户的数量
	 */
	Integer countByStatu(@Param("consultManId") int consultManId, @Param("consultStatu") String consultStatu);
	
	
	
	
	/**
	 * 
	 * @param record 携带参数 consultManId consultDate
	 * @param endDate 结束日期
	 * @param startRow 
	 * @param pageSize
	 * @return List<ConsultRecord> 
	 */
	List<ConsultRecord> ConsultRecordByDate(@Param("record") ConsultRecord record, @Param("endDate") Date endDate, @Param("startRow") int startRow, @Param("pageSize") int pageSize);
    
	/**
	 * 根据employeeid param 查询跟踪记录
	 * @param record
	 * @return List<ConsultRecord>
	 */
	List<ConsultRecord> ConsultRecordByParam(ConsultRecord record);
	
	
	/**
	 * 按条件查询客户跟踪记录数
	 * @param record
	 * @param endDate
	 * @return
	 */
	int countByCondition(@Param("record") ConsultRecord record, @Param("endDate") Date endDate);
    
	
	
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
	List<ConsultRecord> ConsultRecordForMonth(@Param("consultManId") int consultManId);
	
	
	
	
	/**
	 * 查询某个咨询师上周的咨询记录
	 * @param consultManId
	 * @return
	 */
	List<ConsultRecord> ConsultRecordForWeek(@Param("consultManId") int consultManId);
	
}