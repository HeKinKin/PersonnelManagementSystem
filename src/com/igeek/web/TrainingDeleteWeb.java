package com.igeek.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.service.TrainingService;
import com.igeek.service.impl.TrainingServiceImpl;

/**
 * Servlet implementation class aa
 */
@WebServlet("/TrainingDeleteWeb")
public class TrainingDeleteWeb extends HttpServlet {
	TrainingService ts=new TrainingServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("value");		
		int ID=Integer.parseInt(id);
		int a=ts.deleteTraining(ID);
		if(a>0) {
			request.getRequestDispatcher("/search.do").forward(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
