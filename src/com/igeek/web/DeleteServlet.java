package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.service.UserService;
import com.igeek.service.impl.UserServiceImpl;


@WebServlet("/del")
public class DeleteServlet extends HttpServlet{
	
	//业务
			private final UserService service = new UserServiceImpl();
			
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收 要删除的用户id
		String str_id = request.getParameter("id");
		int id = Integer.parseInt(str_id);
		//调用业务
		boolean b = service.deleteUserById(id);
		
		if(b) {
			response.sendRedirect("adminshow.jsp");
		}
	}
}
