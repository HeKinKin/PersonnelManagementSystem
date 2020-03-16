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
@WebServlet("/SearchByStaffName")
public class PagingByStaffname extends HttpServlet{
	
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  	     resp.setContentType("text/html;charset=utf-8");
  	     StaffService service=new StaffServiceImpl();
  	     int pageSize=5;
  	     int curPage=1;
  	     String staffname=req.getParameter("staffname");
  	   String name=req.getParameter("name");
  	   staffname = staffname==null?"":staffname;
  	   if("yes".equals(name)) {
  		   req.getSession().setAttribute("staffname", staffname);
  	   } 
  	   else {
  		 staffname=(String)req.getSession().getAttribute("staffname");
  	   }
  	     try {     
  	    	 String p = req.getParameter("p");
  	    	 curPage=Integer.parseInt(p);
  	    	// System.out.println(curPage); 
	  		} catch (Exception e) {
	  	}
  	     
  	      Paging<Staff> paging = service.pagingBystaffname(curPage, pageSize, staffname);
  	      req.setAttribute("pagging",paging);
  	      
  	      req.getRequestDispatcher("/SearchStaffByName.jsp").forward(req, resp);
    }
}
