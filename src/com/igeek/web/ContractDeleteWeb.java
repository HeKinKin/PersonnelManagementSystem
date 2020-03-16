package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.service.ContractService;
import com.igeek.service.impl.ContractServiceImpl;

/**
 * Servlet implementation class aa
 */
@WebServlet("/ContractDeleteWeb")
public class ContractDeleteWeb extends HttpServlet {
	ContractService ts=new ContractServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("value");
		int ID=Integer.parseInt(id);
		int a=ts.deleteContract(ID);
		if(a>0) {
			request.getRequestDispatcher("/search1.do").forward(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
