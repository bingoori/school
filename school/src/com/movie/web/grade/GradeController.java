package com.movie.web.grade;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separate;

/**
 * Servlet implementation class GradeController
 */
@WebServlet("/grade/my_grade.do")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	GradeService service = GradeServiceImpl.getService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Command command = new Command();
		ArrayList<String> arrStr = Separate.getValidityUrl(request);
		 command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
		switch (arrStr.get(1)) {
		
		case "my_grade":
		
			request.setAttribute("score", service.getGradeById(request.getParameter("id")));
			// command = CommandFactory.createCommand(directory, "main");
			command = CommandFactory.createCommand(arrStr.get(0), "myGrade");
			break;
		default:
			break;
		}
		DispatcherServlet.go(request, response, command.getView());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
