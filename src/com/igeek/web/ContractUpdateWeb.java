package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.service.ContractService;
import com.igeek.service.impl.ContractServiceImpl;

@WebServlet("/ContractUpdateWeb")
public class ContractUpdateWeb extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(1);
		String value1=req.getParameter("value1");
		String value2=req.getParameter("value2");
		String value3=req.getParameter("value3");
		String value4=req.getParameter("value4");
		String value5=req.getParameter("value5");
		ContractService ts=new ContractServiceImpl();
		int a=ts.updateContract(Integer.parseInt(value1),value2,value3,value4,value5);							
		if(a>0) {			
			req.getRequestDispatcher("/search1.do").forward(req,resp);
		}		
	}
}
