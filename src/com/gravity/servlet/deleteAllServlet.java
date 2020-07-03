package com.gravity.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gravity.service.EmpService;

/**
 * 批量删除的servlet
 */
@WebServlet("/deleteAllEmp")
public class deleteAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deleteJson = request.getParameter("data");
	System.out.println(deleteJson);
	String[] list=deleteJson.split(",");
	String[] sid;
	int id;

	for(int i=0;i<list.length;i++) {
		if((i+1)%7==3) {
			sid=list[i].split(":");
			id=Integer.parseInt(sid[1]);
			System.out.println("  获取的编号    "+id);
			try {
				response.getWriter().write(new EmpService().deleteEmp(id));
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
