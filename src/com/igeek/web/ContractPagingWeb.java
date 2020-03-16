package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Contract;
import com.igeek.bean.Paging;
import com.igeek.service.ContractService;
import com.igeek.service.impl.ContractServiceImpl;
@WebServlet("/search1.do")
public class ContractPagingWeb extends HttpServlet{
	int pagesize=6;     
	int currpage=1;
	ContractService ts=new ContractServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name1");		
		String number=req.getParameter("number1");
		String p=req.getParameter("p");
		if(name==null&&number!=null) {			 
			if(p==null) {
				p="1";
			}	
			Paging<Contract> pa=ts.selectId(Integer.parseInt(number));
			req.setAttribute("paging",pa);
		}
		if(name==null&&number==null) {			
			if(p==null) {
				p="1";
			}
			currpage=Integer.parseInt(p);			
			Paging<Contract> pa=ts.selectPaging(pagesize, currpage);
			req.setAttribute("paging",pa);
		}
		if(name!=null&&number==null){		
			if(p==null) {
				p="1";
			}
			currpage=Integer.parseInt(p);
			Paging<Contract> pa=ts.selectName(name,pagesize, currpage);			
			req.setAttribute("name", name);
			req.setAttribute("paging",pa);
		}
		
		req.getRequestDispatcher("/员工合同管理.jsp").forward(req,resp);
	}
}
