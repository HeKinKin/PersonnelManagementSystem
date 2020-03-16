package com.igeek.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.bean.Paging;
import com.igeek.bean.User;
import com.igeek.service.UserService;
import com.igeek.service.impl.UserServiceImpl;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet
{
	//业务
		private final UserService service = new UserServiceImpl();
		private int pageSize = 5;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	
	String adminloginname = request.getParameter("adminloginname");
	User user = service.checkPower(adminloginname);
	
	if(user.getPower()==1) {
	
		//接受页码	
			int curPage = 1;
			try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
			}catch (Exception e) {
				
			}
			//调用业务
	//		request.setAttribute("paging", service.searchAllUser(curPage, pageSize));
			HttpSession httpSession=request.getSession();
			Paging<User> paging = service.searchAllUser(pageSize ,curPage);
			httpSession.setAttribute("paging", paging);
			//转发
			response.sendRedirect("adminshow.jsp");
	//		request.getRequestDispatcher("adminshow.jsp").forward(request, response);
		}else {
			pw.println("<h1 style=\"color : red ;\">无权限</h1>");
			pw.print("<h2><a href=\"home.jsp\">回到首页</a></h2>");
		}
	}
	
}
