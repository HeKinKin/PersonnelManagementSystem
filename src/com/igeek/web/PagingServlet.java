package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Paging;
import com.igeek.bean.Staff;
import com.igeek.service.StaffService;
import com.igeek.service.impl.StaffServiceImpl;

@WebServlet("/pagingServlet")
public class PagingServlet extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     resp.setContentType("text/html;charset=utf-8");
	     StaffService service=new StaffServiceImpl();
	     int pageSize=5;
	     int curPage=1;
	     try {     String p = req.getParameter("p");
	       
	    	 curPage=Integer.parseInt(p);
	    	// System.out.println(curPage);
	    	 
		} catch (Exception e) {
			
		}
	      Paging<Staff> paging = service.paging(curPage, pageSize);
	      req.setAttribute("paging", paging);
	      req.getRequestDispatcher("PagingStaff.jsp").forward(req, resp);
  }
}
