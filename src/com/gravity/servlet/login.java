package com.gravity.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gravity.service.UserService;
import com.gravity.beam.Upart;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		System.out.println(name+"--------"+pwd);
		//需要通过控制层执行数据库的操作
		Upart up = new Upart(name,pwd);
		
		try {
			//调用控制层添加数据到数据库
			boolean isok= new UserService().queryUserWith(up);
			System.out.println(isok?"有数据":"没有数据");
			if(isok) {
				//说明明用户存在，登录成功，跳转到页面（主页）
				//重定向
				response.sendRedirect("index.html");
				
			}else {
				//用户不存在返回登录界面
				request.getRequestDispatcher("login.html").forward(request, response);
				
			}
		} catch (SQLException e) {
			//登录异常
			System.out.println("数据库异常");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
