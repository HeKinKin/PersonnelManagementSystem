package com.igeek.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Attendance;
import com.igeek.bean.Contract;
import com.igeek.bean.File;
import com.igeek.bean.Staff;
import com.igeek.bean.Training;
import com.igeek.bean.Wage;
import com.igeek.service.AttendanceService;
import com.igeek.service.ContractService;
import com.igeek.service.FileService;
import com.igeek.service.StaffService;
import com.igeek.service.TrainingService;
import com.igeek.service.WageService;
import com.igeek.service.impl.AttendanceServiceImpl;
import com.igeek.service.impl.ContractServiceImpl;
import com.igeek.service.impl.FileServiceImpl;
import com.igeek.service.impl.StaffServiceImpl;
import com.igeek.service.impl.TrainingServiceImpl;
import com.igeek.service.impl.WageServiceImpl;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

@WebServlet("/fileAddServlet")
public class FileAddServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		req.setCharacterEncoding("utf-8");
		FileService fileService=new FileServiceImpl();
		StaffService staffService =new StaffServiceImpl();
		WageService wageService=new WageServiceImpl();
		AttendanceService attendanceService =new AttendanceServiceImpl();
		TrainingService trainingService =new TrainingServiceImpl();
		ContractService contractService =new ContractServiceImpl();
		
		//实例化
		SmartUpload  su = new SmartUpload();
		//初始化
		su.initialize(getServletConfig(), req, resp);
		
		Request requset = su.getRequest();
		//获取图片路径
		String staffimg=null;
		try {
			//设置允许的后缀名  白名单
			su.setAllowedFilesList("jpg,png,JPEG");
			
			//设置不允许的后缀名  黑名单
			//su.setDeniedFilesList("exe,avi");
			
			
			//设置单个文件大小  1M
			su.setMaxFileSize(1024*1024);
			
			//设置总上传大小 10M
			su.setTotalMaxFileSize(1024*1024*10);
			//接受上传的文件，存储到服务器临时目录
			su.upload();
			//获取上传文件列表对象
			Files files = su.getFiles();
			//取出第一个
			com.jspsmart.upload.File  file = files.getFile(0);
			/*for(int i=0;i<files.getCount();i++) {
				 files.getFile(i);
			}*/
			
			//判断文件错误
			if(!file.isMissing()) {
				String  fieldName = file.getFieldName();//file1
				//String fileName = file.getFileName();  //上传的文件的名称
				String ext = file.getFileExt();  //文件的扩展名
				
				String fileName = UUID.randomUUID().toString()+"."+ext;
				
				
				//获取上传文件夹的 绝对物理路径
				String path = req.getServletContext().getRealPath("/imgs");
			//	String path = "E:/uploads";
				path +=   java.io.File.separator +  fileName;
				staffimg=fileName;
				
			  file.saveAs(path); //保存路径，需要物理的绝对路径
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//获取表单提交的全部信息
		String staffname=requset.getParameter("staffname");
		String stafftel=requset.getParameter("stafftel");
		String staffemail=requset.getParameter("staffemail");
		String departmentid=requset.getParameter("departmentid");
		String positionid=requset.getParameter("positionid");
		String staffnumber=requset.getParameter("staffnumber");
//		String staffimg=requset.getParameter("staffimg");
		String staffsex=requset.getParameter("staffsex");
		String nationality=requset.getParameter("nationality");
		String politicalstatus=requset.getParameter("politicalstatus");
		String staffbirthday=requset.getParameter("staffbirthday");
		String entrytime=requset.getParameter("entrytime");
		String staffeducation=requset.getParameter("staffeducation");
		String graduatedschool=requset.getParameter("graduatedschool");
		String staffaddress=requset.getParameter("staffaddress");
		//创建 档案
		File file=new File();
		file.setStaffnumber(Integer.parseInt(staffnumber));
		file.setStaffimg(staffimg);
		file.setStaffsex(staffsex);
		file.setNationality(nationality);
		file.setPoliticalstatus(politicalstatus);
		file.setEntrytime(entrytime);
		file.setStaffeducation(staffeducation);
		file.setGraduatedschool(graduatedschool);
		file.setStaffaddress(staffaddress);
		file.setStaffbirthday(staffbirthday);
		
		//创建 员工
		Staff staff=new Staff();
		staff.setStaffname(staffname);
		staff.setStaffnumber(Integer.parseInt(staffnumber));
		staff.setStafftel(stafftel);
		staff.setStaffemail(staffemail);
		staff.setDepartmentid(Integer.parseInt(departmentid));
		staff.setPositionid(Integer.parseInt(positionid));
		staff.setWorkingstate("在职");
		
		//员工插入到工资表
		Wage wage=new Wage();
		wage.setStaffnumber(Integer.parseInt(staffnumber));
		wage.setDepartmentid(Integer.parseInt(departmentid));
		wage.setWagedate(entrytime);
		
		//员工插入到考勤表
		Attendance attendance=new Attendance();
		attendance.setStaffnumber(Integer.parseInt(staffnumber));
		attendance.setDepartmentid(Integer.parseInt(departmentid));
		
		//员工插入到培训表
		Training training=new Training();
		training.setStaffnumber(Integer.parseInt(staffnumber));
		
		
		//员工插入到合同表
		Contract contract=new Contract();
		contract.setStaffnumber(Integer.parseInt(staffnumber));
		
		
		boolean ataffbo = staffService.addStaffmsg(staff);
		if(ataffbo) {
			boolean filebo = fileService.addNewStaffFile(file);
			boolean wagebo = wageService.add(wage);
			boolean attendancebo = attendanceService.addStaff(Integer.parseInt(staffnumber), Integer.parseInt(departmentid));
			int trainingbo = trainingService.insertTraining(Integer.parseInt(staffnumber), "待确认", "待确认", "待确认", "待确认");
			int contractbo = contractService.insertContract(Integer.parseInt(staffnumber),"待确认", "待确认", "待确认", "待确认");
			
			resp.sendRedirect("home.jsp");
		}else {
			req.setAttribute("err", "添加失败");
			
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		
	}

}
