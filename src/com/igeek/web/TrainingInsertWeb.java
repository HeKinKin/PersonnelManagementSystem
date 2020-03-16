package com.igeek.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Paging;
import com.igeek.bean.Training;
import com.igeek.service.TrainingService;
import com.igeek.service.impl.TrainingServiceImpl;

@WebServlet("/TrainingInsertWeb")
public class TrainingInsertWeb extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value1=req.getParameter("value1");
		String value2=req.getParameter("value2");
		String value3=req.getParameter("value3");
		String value4=req.getParameter("value4");
		String value5=req.getParameter("value5");
		TrainingService ts=new TrainingServiceImpl();
		int a=ts.insertTraining(Integer.parseInt(value1),value2,value3,value4,value5);							
		if(a>0) {			
			req.getRequestDispatcher("/search.do").forward(req,resp);
		}		
	}
}
