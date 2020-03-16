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
@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	private final UserService service = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("adminloginname");
		String pwd = request.getParameter("adminpassword");
		User user = service.login(name, pwd);
	
		if(null==user) {
			request.setAttribute("Err", "用户名，密码错误");
			request.getRequestDispatcher("dengluye.jsp").forward(request, response);
		}else {
			//存入会话
			request.getSession().setAttribute("Tom", user);
			response.sendRedirect("index.jsp");
		}
	}
}
