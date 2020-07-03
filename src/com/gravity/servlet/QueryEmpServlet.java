package com.gravity.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gravity.service.EmpService;

/**
 * 查询所有数据，并实现分页显示
 */
@WebServlet("/queryEmp")
public class QueryEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取分页条数和页码
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		System.out.println(page+"    "+limit);	
		try {
			// 指定中文数据的编码格式
			response.setContentType("text/json;charset=utf-8");
			// layui使用的是异步请求。返回数据使用流的方式返回
			response.getWriter().write(new EmpService().queryAllEmp(page,limit));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
