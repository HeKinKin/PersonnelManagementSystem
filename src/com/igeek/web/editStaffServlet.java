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
@WebServlet("/editStaffServlet")
public class editStaffServlet  extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 Staff staff=new Staff();
    	 resp.setContentType("text/html;charset=utf-8");
    	StaffService service=new StaffServiceImpl();
    	String number=req.getParameter("id");
    	 staff = service.searchBystaffnumber(Integer.parseInt(number));
    	if(null!=staff) {
    		req.setAttribute("StaffMsg", staff);
    		req.getRequestDispatcher("editStaffmsg.jsp").forward(req, resp);
    		

   
    	}
    	
    }
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 Staff staff=new Staff();
    	 resp.setContentType("text/html;charset=utf-8");
     	StaffService service=new StaffServiceImpl();
     	String number=req.getParameter("staffnumber");
     	    staff.setStaffnumber(Integer.parseInt(number));
     	    String name=req.getParameter("staffname");
     	    byte[] bytes=name.getBytes("ISO-8859-1");
     	    String  staffname=new String(bytes,"utf-8");
     	  staff.setStaffname(staffname);
     	  
     	  String workingstate=req.getParameter("workingstate");
  	     byte[] by=workingstate.getBytes("ISO-8859-1");
  	     String  state=new String(by,"utf-8");
  	     staff.setWorkingstate(state);
  	     staff.setStafftel(req.getParameter("stafftel"));
  	     staff.setStaffemail(req.getParameter("staffemail"));
  	     staff.setPositionid(Integer.parseInt(req.getParameter("positionid")));
  	     staff.setDepartmentid(Integer.parseInt(req.getParameter("departmentid")));
  	     
    	   boolean flag = service.editStaffmsg(staff); 
    	   if(flag) {
    		   req.setAttribute("msg", "修改成功");
    		   req.getRequestDispatcher("editStaffmsg.jsp").forward(req, resp);
    	   }
    	   else {
    		   req.setAttribute("msg", "修改失败");
    		   req.getRequestDispatcher("editStaffmsg.jsp").forward(req, resp);
    		   
    	   }
    }
}
