package com.oracle.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oracle.biz.impl.CustomBizImpl;
import com.oracle.biz.impl.CustomInfoBizImpl;
import com.oracle.biz.impl.EmployeeBizImpl;
import com.oracle.entitys.Custom;
import com.oracle.entitys.Department;
import com.oracle.entitys.Employee;
import com.oracle.utils.ExcelUtils;

@Controller
public class CustomController {

	@Autowired
	private CustomBizImpl customBiz;
	@Autowired
	private EmployeeBizImpl emBiz;
	@Autowired
	private CustomInfoBizImpl ciBiz;

	@RequestMapping("insertCustom")
	@ResponseBody
	public String addCustom(HttpSession session,Custom custom) {

		System.out.println("请求添加的custom:" + custom);
		
		if(customBiz.checkCutomExist(custom)){
			
			customBiz.addCustom(custom);
			
			Employee user=(Employee)session.getAttribute("user");
			
			if(user.getJobInfoId()==5){
				ciBiz.addCustomInfo(custom.getId(), user.getId());
			}
			return "1";
		}else{
			return "0";
		}
		
		
		
	}

	@RequestMapping("updateCustom")
	@ResponseBody
	public String updateCustom(Custom custom) {

		System.out.println("修改客户custom:" + custom);

		return "" + customBiz.updateCustom(custom);
	}

	@RequestMapping("queryCustom")
	@ResponseBody
	public Map<String, Object> queryCustom(Custom custom, int rows, int page) {

		System.out.println(custom);

		Map<String, Object> map = new HashMap<String, Object>();

		List<Custom> list = customBiz.queryByCondition(custom, page, rows);

		int total = customBiz.totalByCondition(custom);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	@RequestMapping("allotCustom")
	@ResponseBody
	public String allotCustom() {

		List<Integer> cids = customBiz.customIdsByStatu("0");

		if (cids.size() > 0) {
			Employee employee = new Employee();
			employee.setJobInfoId(8);// 销售职位员工
			List<Employee> list = emBiz.employeesByCondition(employee);

			List<Integer> eids = new ArrayList<Integer>();
			StringBuilder b = new StringBuilder();

			// 获得销售员工的id
			for (Employee e : list) {
				eids.add(e.getId());

			}

			for (Integer i : cids) {
				b.append(i + ",");
			}

			String customIds = "(" + b.substring(0, b.length() - 1) + ")";

			System.out.println("修改状态的customids:" + customIds);

			int cuts = cids.size();
			int emps = eids.size();

			int num = cuts / emps;

			System.out.println("客户数:" + cuts + "员工数:" + emps + "平均每人：" + num);
			if (cuts % emps == 0) {
				for (int i = 0; i < emps; i++) {
					for (int j = i * num; j < (i + 1) * num; j++) {
						ciBiz.addCustomInfo(cids.get(j), eids.get(i));
					}
				}

			} else {

				for (int i = 0; i < emps; i++) {
					for (int j = i * num; j < (i + 1) * num; j++) {
						ciBiz.addCustomInfo(cids.get(j), eids.get(i));
					}
				}

				for (int k = (cuts % emps) * emps; k < cuts; k++) {
					int i = (int) (Math.random() * emps);// 随机产生销售员id的list索引

					ciBiz.addCustomInfo(cids.get(k), eids.get(i));
				}

			}

			customBiz.updateCustomStatu(customIds, "2");

			return "1";
		} else {
			return "0";
		}

	}

	@RequestMapping("queryConsulters")
	@ResponseBody
	public List<Employee> queryConsulters() {

		System.out.println("查询所有的咨询师");

		Employee employee = new Employee();

		employee.setJobInfoId(3);// 咨询师id
		return emBiz.employeesByCondition(employee);
	}

	@RequestMapping("batchImportCustom")
	@ResponseBody
	public String batchImportCustom(HttpServletRequest req) {

		// 强转为MultipartHttpServletRequest请求
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		// 通过表单的name属性值 获得file文件
		MultipartFile file = mreq.getFile("file");
		// 获取初始名字
		String fileName = file.getOriginalFilename();
		// 修改文件名，防止覆盖 时间戳 SimpleDateFormat 的使用是为了可以看出上传时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new Date());

		System.out.println("fileName=" + fileName + ">>>>>>>>>>>>>>>>>>>>>>>");
		String newName = fileName.substring(0, fileName.lastIndexOf("."))
				+ date + fileName.substring(fileName.lastIndexOf("."));
		FileOutputStream fos = null;
		String filePath = req.getSession().getServletContext().getRealPath("/")
				+ "excel\\" + newName;

		try {
			fos = new FileOutputStream(filePath);
			fos.write(file.getBytes());
			fos.flush();
			fos.close();

			// 上传之后可以读取到文件
			System.out.println("filePath=" + filePath + ">>>>>>>"
					+ new File(filePath).canRead());

			// 读取excel到list<E>

			List<Custom> list = ExcelUtils.readExcel(filePath,
					"com.oracle.entitys.Custom");

			int count = 0;

			for (Custom c : list) {
				if (c != null) {

					if (customBiz.checkCutomExist(c)) {
						count += customBiz.addCustom(c);
					}

				}

			}

			return "" + count;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "false";

	}
	
	
	
	@RequestMapping("exportCustom")
	public void exportCustom(HttpServletResponse response,String type){
		
		List<Custom> list =null;
		if("1".equals(type)){
			list= customBiz.customsForWeek();
		}else{
			list=customBiz.customsForWeek();
		}
		
		List<Integer> index=new ArrayList<Integer>();
		
		index.add(8);
		
		String[] columns={"编号","姓名","教育水平","手机","qq","邮箱","状态(0:新增  1:已上门 2:销售跟进 3:咨询跟进  4:死单 5:已报名)","导入日期"} ;
		ExcelUtils.exportToExcel(response, list,index, "本月客户资料表", columns,"客户信息表");
	}
	
	
	
	
	
	
	

}
