package com.igeek.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.File;
import com.igeek.bean.Staff;
import com.igeek.service.FileService;
import com.igeek.service.StaffService;
import com.igeek.service.impl.FileServiceImpl;
import com.igeek.service.impl.StaffServiceImpl;
import com.igeek.utils.JDBCUtils;
import java.sql.Connection;

@WebServlet("/fileEidtServlet")
public class FileEidtServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		req.setCharacterEncoding("utf-8");
		FileService fileService=new FileServiceImpl();
		StaffService staffService =new StaffServiceImpl();
		
		//获取表单提交的全部信息
		String staffname=req.getParameter("staffname");
		String stafftel=req.getParameter("stafftel");
		String staffemail=req.getParameter("staffemail");
		String departmentid=req.getParameter("departmentid");
		String positionid=req.getParameter("positionid");
		String workingstate=req.getParameter("workingstate");
		String staffnumber=req.getParameter("staffnumber");
		
	
//		String staffimg=req.getParameter("staffimg");
		
		String staffsex=req.getParameter("staffsex");
		String nationality=req.getParameter("nationality");
		String politicalstatus=req.getParameter("politicalstatus");
		String staffbirthday=req.getParameter("staffbirthday");
		String entrytime=req.getParameter("entrytime");
		String staffeducation=req.getParameter("staffeducation");
		String graduatedschool=req.getParameter("graduatedschool");
		String staffaddress=req.getParameter("staffaddress");
		
		//创建 档案
		File file=new File();
		file.setStaffnumber(Integer.parseInt(staffnumber));
//		file.setStaffimg(staffimg);
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
		staff.setStaffnumber(Integer.parseInt(staffnumber));
		staff.setStaffname(staffname);
		staff.setStafftel(stafftel);
		staff.setStaffemail(staffemail);
		staff.setDepartmentid(Integer.parseInt(departmentid));
		staff.setPositionid(Integer.parseInt(positionid));
		staff.setWorkingstate(workingstate);
		
		boolean filebo = fileService.editStaffFile(file);
		
		boolean staffbo = staffService.editStaffmsg(staff);
		
		if(filebo&&staffbo) {
			resp.sendRedirect("pagingServlet");
//			resp.sendRedirect("fileShowServlet?staffnumber="+staffnumber);
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
