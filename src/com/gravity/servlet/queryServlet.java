package com.gravity.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gravity.service.EmpService;

/**
 * 筛选
 */
@WebServlet("/queryServlet")
public class queryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> parms = new HashMap<>();
		parms.put("name", request.getParameter("name"));
		parms.put("sex", request.getParameter("sex"));
		parms.put("carType", request.getParameter("carType"));
		parms.put("page", request.getParameter("page"));
		parms.put("limit", request.getParameter("limit"));
		
		System.out.println(request.getParameter("data"));
		
		try {
			// 指定中文数据的编码格式
			response.setContentType("text/json;charset=utf-8");
			// layui使用的是异步请求。返回数据使用流的方式返回
			response.getWriter().write(new EmpService().queryAllEmp(parms));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
