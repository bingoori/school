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

@WebServlet({ "/member/update_form.do", "/member/login_form.do", "/member/join_form.do", "/member/join.do",
		"/member/login.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = MemberServiceImpl.getService();

	// 페이지 이동시에는 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberBean mBean = new MemberBean();

		Command command = new Command();
		
		String id = "", password = "";
		String path = request.getServletPath();
		// String queryString = " ";
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("[.]")[0];

		command = CommandFactory.createCommand(directory, action);

		switch (action) {
		case "join":
			id = request.getParameter("id");
			System.out.println("ID :" + id);
			break;
		case "login":
			System.out.println("====  로그인 ===========");
			System.out.println(request.getParameter("id") + "" + request.getParameter("password") + "@@@@@");
			if (service.isMember(request.getParameter("id"), request.getParameter("password")) == true) {
				mBean = service.login(request.getParameter("id"), request.getParameter("password"));
				request.setAttribute("member", mBean);
				command = CommandFactory.createCommand(directory, "detail");
			} else {
				System.out.println("==== 로그인 실패 =========");
				command = CommandFactory.createCommand(directory, "login_form");
			}
			break;
		case "login_form":
			command = CommandFactory.createCommand(directory, "login_form");
			break;
		case "update_form":
			System.out.println("==== update_form ====");
			mBean = service.detail(request.getParameter("id"));
			request.setAttribute("member", mBean);
			command = CommandFactory.createCommand(directory, action);
			break;
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}
		System.out.println("오픈될 페이지 :" + command.getView());
		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);
	}

	// 페이지
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
