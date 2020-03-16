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

@WebServlet("/SearchByStaffDep")
public class departmentnumberServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("html/text;charset=utf-8");
       StaffService service=new StaffServiceImpl();
       String  departmentnumber=req.getParameter("departmentnumber");
         List<Staff> rs = service.searchBydepartmentid(Integer.parseInt(departmentnumber));
         if(null!=rs) {
        	 req.setAttribute("depmsg",rs);
        	 
        	 req.getRequestDispatcher("SearchStaffByDepartmentId.jsp").forward(req, resp);
         }
	}
}
