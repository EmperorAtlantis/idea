package com.oracle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.biz.impl.EmployeeBizImpl;
import com.oracle.biz.impl.RightsBizImpl;
import com.oracle.entitys.Employee;
import com.oracle.entitys.Rights;
import com.oracle.utils.EncryptUtil;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeBizImpl empBiz;

	@Autowired
	private RightsBizImpl rtBiz;

	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest req, String username, String pass) {

		System.out.println("用户名：" + username + "密码：" + pass);
		String newpass = EncryptUtil.SHA256(pass);

		Employee user = empBiz.login(username, newpass);

		System.out.println(newpass);
		if (user != null) {
			List<Rights> rights = rtBiz.rightsForJob(user.getJobInfoId());
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("rights", rights);
			session.setMaxInactiveInterval(1800);

			return "1";

		} else {

			return "0";
		}
	}

	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(Employee employee) {
		if (employee.getDepartmentId() == null) {
			employee.setDepartmentId(1);
			employee.setJobInfoId(2);
		}

		// 默认密码为oracleoaec 经过前端sha1 后端sha256 加密后的数据
		employee.setPass("c61bfc278c72560e5cc3a7d44154b6e3d2dfabebae62c97bd16b8d651c23eeac");
		employee.setNickname("OAEC" + (int) (Math.random() * 1000));
		employee.setWorkStatu("1");
		System.out.println("添加账号：" + employee);

		return "" + empBiz.addEmployee(employee);
	}

	@RequestMapping("checkUsername")
	@ResponseBody
	public String checkUsername(String username) {

		System.out.println("请求验证用户名：" + username);

		if (empBiz.usernameCheck(username) != null) {
			return "false";
		} else {
			return "true";
		}
	}

	@RequestMapping("cancleUser")
	@ResponseBody
	public String cancleUser(String username) {

		System.out.println("注销员工账号：" + username);
		String statu = empBiz.checkWorkStatu(username);
		System.out.println(statu);

		if ("1".equals(statu)) {
			return "" + empBiz.cancleEmployee(username);
		} else {
			return "2";
		}

	}

	@RequestMapping("empForDepart")
	@ResponseBody
	public List<Employee> empForDepart(int departmentId, int managerId) {

		return empBiz.empForDepart(departmentId, managerId);
	}

	@RequestMapping("empForJobId")
	@ResponseBody
	public List<Employee> empForJobId(Employee employee) {

		return empBiz.employeesByCondition(employee);
	}

	@RequestMapping("allEmployees")
	@ResponseBody
	public List<Employee> allEmployees() {

		return empBiz.allEmployees();
	}

	@RequestMapping("updateUser")
	@ResponseBody
	public String updateUser(Employee employee) {
		
		return "" + empBiz.updateUser(employee);
	}
	
	@RequestMapping("changePass")
	@ResponseBody
	public String changePass(HttpSession session,int employeeId,String pass,String newPass){
		pass=EncryptUtil.SHA256(pass);
		Employee user=(Employee)session.getAttribute("user");
		if(user.getPass().equals(pass)){
			return ""+empBiz.changePass(employeeId,EncryptUtil.SHA256(newPass));
		}else{
			return "0";
		}
		
		
	}
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session=null;
		
		return "redirect:login.jsp";
	}
	

}
