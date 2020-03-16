package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Attendance;
import com.igeek.bean.Paging;
import com.igeek.service.AttendanceService;
import com.igeek.service.impl.AttendanceServiceImpl;

@WebServlet("/searchAttendance.do")
public class SearchAttendanceServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curPageStr = request.getParameter("curPage");
		if(curPageStr == null) {
			curPageStr = "1";
		}
		int curPage = Integer.parseInt(curPageStr);
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr == null) {
			pageSizeStr = "10";
		}
		int pageSize = Integer.parseInt(pageSizeStr);
		String staffnumber = request.getParameter("staffnumber");
		String departmentid = request.getParameter("departmentid");
		String attendancedays = request.getParameter("attendancedays");
		AttendanceService service = new AttendanceServiceImpl();
		Paging<Attendance> pagging = service.findAttendance(curPage, pageSize,staffnumber,departmentid,attendancedays);
		request.setAttribute("staffnumber", staffnumber);
		request.setAttribute("departmentid", departmentid);
		request.setAttribute("attendancedays", attendancedays);
		request.setAttribute("pagging", pagging);
		request.getRequestDispatcher("/AttendanceManager.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}