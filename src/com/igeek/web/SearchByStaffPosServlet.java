package com.igeek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Staff;
import com.igeek.service.StaffService;
import com.igeek.service.impl.StaffServiceImpl;
@WebServlet("/SearchByStaffPos")
public class SearchByStaffPosServlet extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  StaffService service=new StaffServiceImpl();
    	  int positionid=Integer.parseInt(req.getParameter("positionid"));
    	     List<Staff> list = service.searchBypositionid(positionid) ;
    	     
    	     if(null!=list) {
    	    	 
    	    	 req.setAttribute("posmsg", list);
    	    	 req.getRequestDispatcher("SearchStaffByPositionId.jsp").forward(req, resp);
    	     }
    }
}
