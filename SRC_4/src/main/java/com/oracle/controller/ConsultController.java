package com.oracle.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.biz.impl.ConsultBizImpl;
import com.oracle.biz.impl.CustomBizImpl;
import com.oracle.entitys.ConsultRecord;
import com.oracle.utils.ExcelUtils;

@Controller
public class ConsultController {
	
	@Autowired
	private ConsultBizImpl crBiz;
	
	@Autowired
	private CustomBizImpl cusBiz;
	@RequestMapping("queryRecord")
	@ResponseBody
	public Map<String,Object> recordBycondition(ConsultRecord record,Date endDate,int rows,int page){
		
		System.out.println("咨询师查询记录》》》》》》》》》》》》》》》》");
		
		System.out.println(record);
		
		System.out.println("endDate"+endDate);
		
		Map<String,Object> map=new HashMap<String, Object>();
		if(record.getCustomName()!=null|record.getCustomPhoneNo()!=null){
			map.put("rows", crBiz.ConsultRecordByParam(record));
			map.put("total", crBiz.countByCondition(record, null));
		}else if(endDate!=null){
			map.put("rows", crBiz.ConsultRecordByDate(record, endDate, rows, page));
			map.put("total", crBiz.countByCondition(record, endDate));
		}else{
			map.put("rows", crBiz.allConsultRecords(record, rows, page));
			map.put("total", crBiz.countByCondition(record, null));
		}
		
		return map;
		
		
		
	}
	
	
	
	@RequestMapping("updateRecord")
	@ResponseBody
	public String updateRecord(ConsultRecord record){
		System.out.println("更新记录》》》》》》》》》》》》》》》》"+record);
		if("3".equals(record.getConsultStatu())){
			cusBiz.updateCustomStatu("("+record.getCustomId()+")", "4");
		}
		
		return ""+crBiz.updateConsultRecord(record);
	}
	
	@RequestMapping("addResult")
	@ResponseBody
	public String addResult(ConsultRecord record){
		System.out.println("添加咨询备注》》》》》》》》》》》》》》》》》》");
		System.out.println(record);
		String result = record.getResult();
		result=new Date(System.currentTimeMillis())+" : "+result;
		record.setResult(result);
		return ""+crBiz.updateResult(record);
	}
	
	
	@RequestMapping("countConsult")
	@ResponseBody
	public List<Map<String,Object>> countAtNow(int consultManId){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		//员工id
		list.add(crBiz.consultCountAtNow(consultManId));
		
		
		return list;
	}
	
	@RequestMapping("allotToConsult")
	@ResponseBody
	public String allotToConsult(int customId,int consultManId){
		System.out.println("customId="+customId+">>>>>>>>>>"+"consultManId="+consultManId);
		if(crBiz.addConsultRecord(customId, consultManId)==1){
			return	cusBiz.updateCustomStatu("("+customId+")", "3")+"";
		}
		
		return "0";
	}
	
	
	
	
	@RequestMapping("exportConsultRecord")
	public void exportConsultRecord(HttpServletResponse response,String type,int consultManId){
		List<ConsultRecord> list =null;
		
		if("1".equals(type)){
			list= crBiz.ConsultRecordForWeek(consultManId);
		}else{
			list=crBiz.ConsultRecordForMonth(consultManId);
		}
		
		String[] columns={"记录编号","客户姓名","客户手机","客户状态(0:新增  1:紧跟  2:已报名  3:死单  4:报名后退费)","咨询日期","咨询结果备注"};
		List<Integer> index=new ArrayList<Integer>();
		
		index.add(3);
		index.add(5);
		ExcelUtils.exportToExcel(response, list,index, "客户咨询记录表", columns,"客户咨询记录表");
		
	}
	
	@RequestMapping("countConsultForDepart")
	@ResponseBody
	public List<Map<String,Object>> countConsultForDepart(int departmentId){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String, Object> map = crBiz.CountForDepart(departmentId);
		list.add(map);
		return list;
	}
	
	
	
	
	
}
