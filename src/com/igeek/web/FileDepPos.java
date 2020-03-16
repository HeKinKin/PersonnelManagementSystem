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
import com.igeek.bean.Positionn;
import com.igeek.service.DepartmentService;
import com.igeek.service.PositionService;
import com.igeek.service.impl.DepartmentServiceImpl;
import com.igeek.service.impl.PositionnServiceImpl;

@WebServlet("/showdeppos.do")
public class FileDepPos extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		DepartmentService departmentService=new DepartmentServiceImpl();
		PositionService positionService =new PositionnServiceImpl();
		List<Department> department = departmentService.Searchall();
		List<Positionn> position = positionService.findAllPosition();
		
		if (department!=null&&position!=null) {
			req.getSession().setAttribute("department", department);
			req.getSession().setAttribute("position", position);
			resp.sendRedirect("addfile.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

