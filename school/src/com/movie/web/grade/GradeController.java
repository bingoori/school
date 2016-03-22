package com.movie.web.grade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;

/**
 * Servlet implementation class GradeController
 */
@WebServlet("/grade/my_grade.do")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dis = null;
		String path = request.getServletPath();//서블릿에서 전달한 action path
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("[.]")[0];
		Command command = CommandFactory.createCommand(directory, action);
		if (action.equals("my_grade")) {
			//command = CommandFactory.createCommand(directory, "main");
			command = CommandFactory.createCommand(directory, "myGrade");
			dis = request.getRequestDispatcher(command.getView());
			//getRequestDispatcher 는 페이지 이동하는 함수 
			//request,response 는 세션이나 객체처리된 값들을 전달한다.
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
