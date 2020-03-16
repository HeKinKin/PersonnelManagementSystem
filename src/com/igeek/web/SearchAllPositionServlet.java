package com.igeek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.Positionn;
import com.igeek.service.PositionService;
import com.igeek.service.impl.PositionnServiceImpl;
import com.igeek.utils.JedisPoolUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.annotation.WebServlet;

@WebServlet("/searchAllPosition.do")
public class SearchAllPositionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PositionService service = new PositionnServiceImpl();
		
		List<Positionn> positionList = service.findAllPosition();
		request.setAttribute("positionList", positionList);
		request.getRequestDispatcher("/positionManager.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}