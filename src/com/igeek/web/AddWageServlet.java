package com.igeek.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.bean.Paging;
import com.igeek.bean.Staff;
import com.igeek.bean.Wage;
import com.igeek.service.WageService;
import com.igeek.service.impl.WageServiceImpl;

@WebServlet("/addwage")
public class AddWageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final WageService service=new WageServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		String number=req.getParameter("staffnumber");
		int staffnumber=Integer.parseInt(number);
		//调用业务 找到要修改的工资信息
		Staff staff=service.searchWageBystaffnumber(staffnumber);
		//将找到的工资信息存入作用域
		req.setAttribute("add", staff);
		
		//转发到修改页面
		req.getRequestDispatcher("/addwage.jsp").forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//设置请求编码
		req.setCharacterEncoding("UTF-8");
		//接受新增的的参数
		
		String staffnumber=req.getParameter("staffnumber");
		String departmentid=req.getParameter("departmentid");
		String wagedate=req.getParameter("wagedate");
		String basicwage=req.getParameter("basicwage");
		String bonusgrant=req.getParameter("bonusgrant");
		String insurance=req.getParameter("insurance");
		String fine=req.getParameter("fine");
		String payable=req.getParameter("payable");
		String realwage=req.getParameter("realwage");
		
		//封装
		Wage wage=new Wage();	
		wage.setStaffnumber(Integer.parseInt(staffnumber));
		wage.setDepartmentid(Integer.parseInt(departmentid));
		wage.setWagedate(wagedate);		
		wage.setBasicwage(Double.parseDouble(basicwage));
		wage.setBonusgrant(Double.parseDouble(bonusgrant));
		wage.setInsurance(Double.parseDouble(insurance));
		wage.setFine(Double.parseDouble(fine));
		wage.setPayable(Double.parseDouble(payable));
		wage.setRealwage(Double.parseDouble(realwage));
		
		//调用业务 添加
		boolean b = service.add(wage);
		
		//判断
		if(b) {
			//成功 重定向到wageServlet
			resp.sendRedirect("wage");
		}else {
			req.setAttribute("Err", "新增失败");
			req.getRequestDispatcher("/wage").forward(req, resp);
		}
		
		
	}
		
	
}
