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
@WebServlet("/Register")
public class RegisterServelt extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		User user = new User();
		user.setAdminloginname(name);
		user.setAdminpassword(pwd);
		
		
		
		UserService service = new UserServiceImpl();
		//User d = service.checking(name);
		//if(d.getAdminloginname()!=name) {
		
		if(service.register(user)) {
			response.sendRedirect("adminshow.jsp");
		}
	}
	//else {
			//response.sendRedirect("Login.jsp");
		//}
		
	//}
}
