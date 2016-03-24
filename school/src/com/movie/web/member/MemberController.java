package com.movie.web.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separate;

@WebServlet({ "/member/update_form.do", "/member/login_form.do", "/member/join_form.do", "/member/join.do",
		"/member/login.do", "/member/update.do", "/member/delete.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = MemberServiceImpl.getService();

	// 페이지 이동시에는 doGet
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberBean mBean = new MemberBean();
		Command command = new Command();
		ArrayList<String> arrStr = Separate.getValidityUrl(request);
		// str[0] = directory
		// str[1] = action;
		command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
		switch (arrStr.get(1)) {
	
		case "login":
			System.out.println("====  로그인 ===========");
			System.out.println(request.getParameter("id") + "" + request.getParameter("password") + "@@@@@");
			if (service.isMember(request.getParameter("id"), request.getParameter("password")) == true) {
				mBean = service.login(request.getParameter("id"));
				request.setAttribute("member", mBean);
				command = CommandFactory.createCommand(arrStr.get(0), "detail");
			} else {
				System.out.println("==== 로그인 실패 =========");
				command = CommandFactory.createCommand(arrStr.get(0), "login_form");
			}
			break;
		case "login_form":
			command = CommandFactory.createCommand(arrStr.get(0), "login_form");
			break;
		case "update_form":
			System.out.println("==== update_form ====");
			mBean = service.detail(request.getParameter("id"));
			request.setAttribute("member", mBean);
			command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
			break;
		case "join":
			mBean.setId(request.getParameter("id"));
			mBean.setPassword(request.getParameter("password"));
			mBean.setName(request.getParameter("name"));
			mBean.setAddr(request.getParameter("addr"));
			mBean.setBirth(Integer.parseInt(request.getParameter("birth")));

			if (service.join(mBean) == 1) {
				command = CommandFactory.createCommand(arrStr.get(0), "login_form");
			} else {
				command = CommandFactory.createCommand(arrStr.get(0), "join_form");
			}
			break;
		case "update":
			if (service.update(request.getParameter("id"), request.getParameter("password"),
					request.getParameter("addr")) == 1) {
				mBean = service.login(request.getParameter("id"));
				request.setAttribute("member", mBean);
				command = CommandFactory.createCommand(arrStr.get(0), "detail");
			} else {
				command = CommandFactory.createCommand(arrStr.get(0), "update_form");
			}
			break;
		case "delete":
			System.out.println("@@@@@delete@@@@@");
			int result = service.delete(request.getParameter("id"));
			System.out.println(result);
			if (result == 1) {
				command = CommandFactory.createCommand(arrStr.get(0), "login_form");

			} else {
				command = CommandFactory.createCommand(arrStr.get(0), "detail");
			}
		default:
			command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
			break;
		}
		System.out.println("오픈될 페이지 :" + command.getView());
		DispatcherServlet.dispatcher(request, response, command.getView());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}



}
