package com.igeek.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.bean.Paging;
import com.igeek.bean.Wage;
import com.igeek.service.WageService;
import com.igeek.service.impl.WageServiceImpl;

@WebServlet("/wage")
public class WageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//业务
	private final WageService service=new WageServiceImpl();
	
	private int pageSize = 5;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter pw = resp.getWriter();
		
		//HttpSession session = req.getSession();
		
		int currPage=1;	
		String staffnumber="";
		staffnumber=req.getParameter("staffnumber");		
		String departmentname="";
		departmentname=req.getParameter("departmentname");
		//System.out.println("p:"+req.getParameter("p"));
		
		try {
			currPage=Integer.parseInt(req.getParameter("pa"));
			
		} catch (Exception e) {
			
		}
		Paging<Wage> b = service.select(pageSize, currPage,staffnumber, departmentname);
		
		//判断
	
		
		if(b.getData()==null) {
			req.setAttribute("staffnumber", staffnumber);
			req.setAttribute("departmentname", departmentname);
			req.setAttribute("Err", "查无此人,请重新查找");
			req.getRequestDispatcher("/wage.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("staffnumber", staffnumber);
			req.setAttribute("departmentname", departmentname);
			//调用业务
			req.setAttribute("pag", b);	
			//转发
			req.getRequestDispatcher("/wage.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
