package com.movie.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Index.jsp 에서 들어옴");
		Command command = new Command();
		MemberService service = new MemberServiceImpl();
		String id = "",password = "";
		String path = request.getServletPath();
		System.out.println(path + "getServletPath");
		// String queryString = " ";
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("[.]")[0];
		System.out.println(action + "@@@@@@@action");
		command = CommandFactory.createCommand(directory, action);

		switch (action) {
		case "join":
		id = request.getParameter("id");
			System.out.println("ID :" + id);
			break;
		case "login":
			System.out.println("====  로그인 ===========");
			service.login(request.getParameter("id"), request.getParameter("password"));
			
			command = CommandFactory.createCommand(directory, "detail");
			break;
		case "login_form":
			command = CommandFactory.createCommand(directory, "login_form");
			break;
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}
		System.out.println("오픈된 페이지 : " + command.getView());
		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);
	}

	// 페이지
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
