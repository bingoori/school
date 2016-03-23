package com.movie.web.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separate;
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

/**
 * Servlet implementation class AdminController
 */
@WebServlet({"/member/grade_add.do","/member/admin_form.do","/member/admin_list.do","/grade/grade_addform.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService service = AdminServiceImpl.getService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("관리자 화면");
		Command command = new Command();
		List<GradeMemberBean> arrList = new ArrayList<GradeMemberBean>();
		ArrayList<String> arrStr = Separate.getValidityUrl(request);
		command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
		switch (arrStr.get(1)) {
		case "admin_form":
			System.out.println("====  관리자화면 ===========");
			command = CommandFactory.createCommand(arrStr.get(0), "admin");
			break;
		case "admin_list":
			arrList = service.getMemberList();
			request.setAttribute("totalScore", arrList);
			command = CommandFactory.createCommand("grade", "grade_list");
			break;
		case "grade_addform":
			command = CommandFactory.createCommand(arrStr.get(0), "grade_add");
			break;
		case "grade_add":
		   GradeBean gBean = new GradeBean();
		    gBean.setId(request.getParameter("id"));
		    gBean.setJava(Integer.parseInt(request.getParameter("java")));
		    gBean.setJsp(Integer.parseInt(request.getParameter("jsp")));
		    gBean.setSql(Integer.parseInt(request.getParameter("sql")));
		    gBean.setSpring(Integer.parseInt(request.getParameter("spring")));
		    if(service.addScore(gBean)==1){
		    	command = CommandFactory.createCommand(arrStr.get(0), "admin");		    	
		    }else{
		    	command = CommandFactory.createCommand(arrStr.get(0), "grade_add");
		    }

			
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
