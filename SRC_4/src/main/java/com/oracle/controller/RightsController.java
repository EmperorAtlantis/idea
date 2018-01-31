package com.oracle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.biz.impl.RightsBizImpl;
import com.oracle.entitys.Rights;


@Controller
public class RightsController {
	
	@Autowired
	private RightsBizImpl rtsBiz;
	
	
	
	@RequestMapping("insertRight")
	public void addRights(Rights right,HttpServletResponse resp){
		
		right.setRightType("2");
		System.out.println(right);
		
		try {
			resp.getWriter().write(rtsBiz.addRight(right)+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("queryAllRights")
	@ResponseBody
	public List<Rights> queryAllRights(){
		
		return rtsBiz.allRights();
	}
	
	@RequestMapping("deleteRight")
	public void deleteRight(String id,HttpServletResponse resp){
		
		try {
			resp.getWriter().write(rtsBiz.deleteRight(Integer.valueOf(id))+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("updateRight")
	public void updateRirht(Rights right){
		
		rtsBiz.updateRight(right);
		
	}
	
	
}
