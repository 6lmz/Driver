package com.gravity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gravity.beam.Upart;
import com.gravity.service.UserService;

/**
 * 注册界面的servlet
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");

				System.out.println(name);
		Upart up = new Upart(name,pwd);

		try{
			
			
			boolean isok= new UserService().addtoUser(up);
			System.out.println(isok?"有数据":"没有数据");
			 if(isok) {
				   request.setAttribute("msg", "欢迎您"+name+",注册成功！");
					response.sendRedirect("login.html");
					
				}else {
					request.getRequestDispatcher("register.html").forward(request, response);
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
