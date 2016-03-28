package com.movie.web.global;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/global/main.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = null;
		
		
		//HttpSession session = request.getSession();
//		String path = request.getServletPath();//서블릿에서 전달한 action path
		Command command = new Command();
		ArrayList<String> arrStr = Separate.getValidityUrl(request);
		command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
		//AdminBean aBean = new AdminBean();
		
		
		switch (arrStr.get(1)) {
		case "main":
			//command = CommandFactory.createCommand(directory, "main");
			//	session.setAttribute("user", aBean);
			dis = request.getRequestDispatcher(command.getView());
			//getRequestDispatcher 는 페이지 이동하는 함수 
			//request,response 는 세션이나 객체처리된 값들을 전달한다.
			dis.forward(request, response);
			
			break;

		default:
			break;
		} 
	} 

}
