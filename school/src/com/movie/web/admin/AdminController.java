package com.movie.web.admin;

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

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/member/admin_form.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService service = AdminServiceImpl.getService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("관리자 화면");
		Command command = new Command();
		ArrayList<String> arrStr = Separate.getValidityUrl(request);
		command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
		switch (arrStr.get(1)) {
		case "admin_form":
			System.out.println("====  관리자화면 ===========");
			command = CommandFactory.createCommand(arrStr.get(0), "admin");
			break;

		default:
			break;
		}
		
		System.out.println("오픈될 페이지 :" + command.getView());
		DispatcherServlet.dispatcher(request, response, command.getView());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
