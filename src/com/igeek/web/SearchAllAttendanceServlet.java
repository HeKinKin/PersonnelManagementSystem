package com.igeek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Attendance;
import com.igeek.bean.Paging;
import com.igeek.service.AttendanceService;
import com.igeek.service.impl.AttendanceServiceImpl;

import javax.servlet.annotation.WebServlet;

@WebServlet("/searchAllAttendance.do")
public class SearchAllAttendanceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttendanceService service = new AttendanceServiceImpl();
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
		Paging<Attendance> pagging = service.findPagging(curPage, pageSize);
		request.setAttribute("pagging", pagging);
		request.getRequestDispatcher("/AttendanceManager.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}