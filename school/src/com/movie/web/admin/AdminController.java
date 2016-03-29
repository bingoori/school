package com.movie.web.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.grade.GradeService;
import com.movie.web.grade.GradeServiceImpl;
import com.movie.web.member.MemberBean;

/**
 * Servlet implementation class AdminController
 */
@WebServlet({ "/admin/searchById.do","/grade/grade_add.do", "/admin/login.do","/admin/admin_login_form.do", "/admin/member_list.do", "/grade/admin_list.do",
		"/grade/grade_addform.do","/grade/grade_list.do" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = AdminServiceImpl.getService();
	private GradeService gradeService = GradeServiceImpl.getService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("관리자 화면");
		HttpSession session = request.getSession();
		GradeBean gBean = new GradeBean();
		Command command = new Command();
		AdminBean aBean = new AdminBean();
		List<GradeBean> arrList = new ArrayList<GradeBean>();
		ArrayList<String> arrStr = Separate.getValidityUrl(request);
		command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
		
		switch (arrStr.get(1)) {
		case "grade_list":
			  arrList = gradeService.selectGradeAll();
			request.setAttribute("member", arrList);
			command = CommandFactory.createCommand("grade",arrStr.get(1));
			break;
		case "login":
			
		System.out.println("관리자 로그인 진입");
		aBean.setId(request.getParameter("id"));
		aBean.setPassword(request.getParameter("password"));
		AdminBean temp = service.getAdmin(aBean);
		if(aBean.getId().equals(temp.getId())&&aBean.getPassword().equals(temp.getPassword()))
		{
			
			System.out.println("로그인 성공");
			session.setAttribute("user", temp);
			command = CommandFactory.createCommand(arrStr.get(0), "admin_form");
		}else
		{
			System.out.println("로그인 실패");
			command = CommandFactory.createCommand(arrStr.get(0), "admin_login_form");
		}
			break;
		case "searchById":
			System.out.println("====  SearchById ===========");
			break;
		
		case "admin_login_form":
	/*		System.out.println("====  관리자 로그인 페이지 이동 ===========");
			if(service.getAdmin(request.getParameter("id"),request.getParameter("password"))== true)
			{
				request.setAttribute("totalScore", service.getMemberList());
				command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));				
			}else
			{
				command = CommandFactory.createCommand(arrStr.get(0), "admin_login_form");
			}
			*/
			break;
/*	 
		case "admin_list":
			request.setAttribute("totalScore", service.getMemberList());
			command = CommandFactory.createCommand("grade", "grade_list");
			break;*/
		case "grade_addform":
			System.out.println(request.getParameter("id"));
			request.setAttribute("member",gradeService.selectGradeAll());
			command = CommandFactory.createCommand(arrStr.get(0), "grade_add");
			break;
			
		case "grade_add":
			System.out.println("===== 학점 추가 =====");
			
			System.out.println(request.getParameter("id")+"@id@");
			System.out.println(Integer.parseInt(request.getParameter("java"))+"@java@");
			gBean.setId(request.getParameter("id"));
			gBean.setJava(Integer.parseInt(request.getParameter("java")));
			gBean.setJsp(Integer.parseInt(request.getParameter("jsp")));
			gBean.setSql(Integer.parseInt(request.getParameter("sql")));
			gBean.setSpring(Integer.parseInt(request.getParameter("spring")));
			if (service.addScore(gBean) == 1) {
				command = CommandFactory.createCommand("admin", "admin_form");
			} else {
				command = CommandFactory.createCommand(arrStr.get(0), "grade_add");
			}

			break;

		default:
			break;
		}
		System.out.println("오픈될 페이지 :" + command.getView());
		DispatcherServlet.go(request, response, command.getView());

	}

}
