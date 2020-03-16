package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Staff;
import com.igeek.service.StaffService;
import com.igeek.service.impl.StaffServiceImpl;

@WebServlet("/SearchByStaffNumber")
public class SearchByStaffNumberServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  StaffService service=new StaffServiceImpl();
    	  
    	  int staffnumber=Integer.parseInt(req.getParameter("staffnumber"));
		    Staff staff = service.searchBystaffnumber(staffnumber);
		   
		   if(null!=staff) {
			   req.setAttribute("staffnumber", staff);
			   req.getRequestDispatcher("SearchStaffByNumber.jsp").forward(req, resp);
			   return;
		   }
		   req.getRequestDispatcher("SearchStaffByNumber.jsp").forward(req, resp);
    }
}
