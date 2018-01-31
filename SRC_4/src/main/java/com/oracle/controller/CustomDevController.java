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

import com.oracle.biz.impl.CustomBizImpl;
import com.oracle.biz.impl.CustomInfoBizImpl;
import com.oracle.entitys.CustomInfo;
import com.oracle.utils.ExcelUtils;


@Controller
public class CustomDevController {
	
	@Autowired
	private CustomInfoBizImpl ciBiz;
	
	@Autowired
	private CustomBizImpl cusBiz;
	
	
	
	
	@RequestMapping("customInfo")
	@ResponseBody
	public Map<String,Object> customInfoForDate(String src,int rows,int page,int followManId){
		
		System.out.println("rows="+rows+">>>>>>>>>>>>>>"+"page="+page);
		Map<String,Object> map=new HashMap<String, Object>();
		System.out.println("src="+src);
		CustomInfo info = new CustomInfo();
		info.setFollowManId(followManId);
		
		if("0".equals(src)){
			info.setStartDate(new Date(System.currentTimeMillis()));
		}else if("1".equals(src)){
			info.setStatu("0");
		}else if("2".equals(src)){
			info.setPlanDate(new Date(System.currentTimeMillis()));
		}else{
			info.setId(1);
		}
		
		List<CustomInfo> list = ciBiz.CustomInfosByCondition(info, rows, page);
		Integer total = ciBiz.countByCondition(info);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	@RequestMapping("addMark")
	@ResponseBody
	public String addMark(CustomInfo customInfo){
		System.out.println(customInfo);
		String mark = customInfo.getMark();
		mark=new Date(System.currentTimeMillis())+" : "+mark;
		customInfo.setMark(mark);
		return ciBiz.updateMark(customInfo)+"";
	}
	
	
	@RequestMapping("updateCustomInfo")
	@ResponseBody
	public String updateCutonInfo(CustomInfo customInfo){
		System.out.println(customInfo+">>>>>>>>>>>>>>>>>>>>>");
		String statu = customInfo.getStatu();
		if("4".equals(statu)){
			cusBiz.updateCustomStatu("("+customInfo.getCustomId()+")", statu);
		}
		
		
		return ""+ciBiz.updateCustomInfo(customInfo);
	}
	
	
	@RequestMapping("countInfo")
	@ResponseBody
	public List<Map<String, Object>> callCountAtNow(int followManId){
		System.out.println("请求统计数据");
		Map<String, Object> map = ciBiz.callCountAtNow(followManId);
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map);
		return list;
	}
	
	
	
	@RequestMapping("exportCustomInfo")
	public void exportCustomInfo(HttpServletResponse response,String type,int followManId){
		List<CustomInfo> list =null;
	
		if("1".equals(type)){
			list= ciBiz.customInfoForWeek(followManId);
		}else{
			list=ciBiz.customInfoForMonth(followManId);
		}
		
		String[] columns={"记录编号","客户姓名","客户手机","跟踪状态(0:未联系  1:未接通  2:紧跟  3:已上门  4:死单 5:电话无效)","分配日期","计划联系日期","最近联系","跟踪备注"};
		List<Integer> index=new ArrayList<Integer>();
		
		index.add(3);
		index.add(4);
		ExcelUtils.exportToExcel(response, list,index, "客户跟踪记录表", columns,"客户跟踪记录表");
		
	}
	
	
	@RequestMapping("countInfoForDepart")
	@ResponseBody
	public List<Map<String,Object>> countInfoForDepart(int departmentId){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map = ciBiz.countForSales(departmentId);
		list.add(map);
		
		return list;
	}
	
	
	
	
}
