package com.igeek.web;

import java.io.IOException;
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
@WebServlet("/search.do")
public class TrainingPagingWeb extends HttpServlet{
	int pagesize=6;     
	int currpage=1;
	TrainingService ts=new TrainingServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");		
		String number=req.getParameter("number");
		String p=req.getParameter("p");
		if(name==null&&number!=null) {			 
			if(p==null) {
				p="1";
			}	
			Paging<Training> pa=ts.selectId(Integer.parseInt(number));
			req.setAttribute("paging",pa);
		}
		if(name==null&&number==null) {			
			if(p==null) {
				p="1";
			}
			currpage=Integer.parseInt(p);			
			Paging<Training> pa=ts.selectPaging(pagesize, currpage);
			req.setAttribute("paging",pa);
		}
		if(name!=null&&number==null){		
			if(p==null) {
				p="1";
			}
			currpage=Integer.parseInt(p);
			Paging<Training> pa=ts.selectName(name,pagesize, currpage);			
			req.setAttribute("name", name);
			req.setAttribute("paging",pa);
		}
		
		req.getRequestDispatcher("/员工培训管理.jsp").forward(req,resp);
	}
}
