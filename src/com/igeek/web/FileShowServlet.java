package com.igeek.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Department;
import com.igeek.bean.File;
import com.igeek.bean.Positionn;
import com.igeek.service.DepartmentService;
import com.igeek.service.FileService;
import com.igeek.service.PositionService;
import com.igeek.service.impl.DepartmentServiceImpl;
import com.igeek.service.impl.FileServiceImpl;
import com.igeek.service.impl.PositionnServiceImpl;

@WebServlet("/fileShowServlet")
public class FileShowServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		req.setCharacterEncoding("utf-8");
		
		String staffnumber = req.getParameter("staffnumber");
		
		FileService fileService=new FileServiceImpl();
		DepartmentService departmentService=new DepartmentServiceImpl();
		PositionService positionService =new PositionnServiceImpl();
		
		File file = fileService.selectStaffFileAll(Integer.parseInt(staffnumber));
		List<Department> department = departmentService.Searchall();
		List<Positionn> position = positionService.findAllPosition();
		
		if(file!=null) {
			req.getSession().setAttribute("file", file);
			req.getSession().setAttribute("department", department);
			req.getSession().setAttribute("position", position);
			resp.sendRedirect("fileshow.jsp");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
