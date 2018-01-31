package com.oracle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.biz.impl.JobInfoBizImpl;
import com.oracle.entitys.JobInfo;

@Controller
public class JobController {
	
	@Autowired
	private JobInfoBizImpl jobBiz;
	
	@RequestMapping("insertJob")
	public void addJob(JobInfo job,HttpServletResponse resp){
		
		System.out.println("添加的职位"+job);
		
		try {
			resp.getWriter().write(jobBiz.addJobInfo(job)+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("queryAllJobs")
	@ResponseBody
	public List<JobInfo> queryAllJobts(){
		System.out.println("查询所有职位");
		
		return jobBiz.allJobInfo();
	}
	
	@RequestMapping("updateJob")
	public void updateJob(JobInfo job,HttpServletResponse resp){
		
		System.out.println("更新职位");
		
		jobBiz.updateJobInfo(job);
		
	}
	
	
	@RequestMapping("deleteJob")
	public void deleteJob(String id,HttpServletResponse resp){
		
		System.out.println("删除职位id="+id);
		
		
		try {
			resp.getWriter().write(jobBiz.deleteJobInfo(id)+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("getJobByDid")
	@ResponseBody
	public List<JobInfo> getJobByDid(int departmentId){
		System.out.println("请求查询部门departmentId="+departmentId+"所有职位");
		
		return jobBiz.jobsForDepartment(departmentId);
	}
	
	
	
	
	
}
