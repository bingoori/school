package com.movie.web.global;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet {
	public static void dispatcher(HttpServletRequest request, HttpServletResponse response,String view){
		try {
			RequestDispatcher dis = request.getRequestDispatcher(view);
			dis.forward(request, response);
		} catch (Exception e) {
		System.out.println("dispatcher error");
			e.printStackTrace();
		} 
	}
}
