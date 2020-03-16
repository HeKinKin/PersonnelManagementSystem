package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.User;
import com.igeek.service.UserService;
import com.igeek.service.impl.UserServiceImpl;
@WebServlet("/Update")
public class UpdateServlet extends HttpServlet{
	private final UserService service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		 User user = service.checking(name);
		 request.setAttribute("Eite", user);
		//request.getSession().setAttribute("Eite", user);
		 request.getRequestDispatcher("Update.jsp").forward(request, response);
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//设置接受请求编码
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		//封装
			System.out.println(name);
			System.out.println(pwd);
		User user = new User();
		user.setAdminloginname(name);
		user.setAdminpassword(pwd);
		
		boolean b = service.amendUser(user);
		//判断
		if(b) {
			response.sendRedirect("adminshow.jsp");
		}else {
			request.setAttribute("Err", "修改失败");
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		}
	}
}
