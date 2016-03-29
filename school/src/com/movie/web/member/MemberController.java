package com.movie.web.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.admin.AdminBean;
import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separate;

@WebServlet({"/member/logout.do", "/member/list.do", "/member/update_form.do", "/member/login_form.do", "/member/join_form.do",
		"/member/join.do", "/member/login.do", "/member/update.do", "/member/delete.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = MemberServiceImpl.getService();

	// 페이지 이동시에는 doGet
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberBean mBean = new MemberBean();
	    AdminBean aBean = new AdminBean();
		Command command = new Command();
		ArrayList<String> arrStr = Separate.getValidityUrl(request);
		
		// str[0] = directory
		// str[1] = action;
		command = CommandFactory.createCommand(arrStr.get(0), arrStr.get(1));
		switch (arrStr.get(1)) {
		case "list":
			request.setAttribute("member", service.getList());
			command = CommandFactory.createCommand(arrStr.get(0), "member_list");
			break;

		case "login":
			System.out.println("====  로그인 성공 ===========");
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("password"));
			if (service.isMember(request.getParameter("id"), request.getParameter("password")) == true) {
				mBean = service.login(request.getParameter("id"));
				aBean.setId(mBean.getId());
				aBean.setPassword(mBean.getPassword());
				aBean.setName(mBean.getName());
				aBean.setAddr(mBean.getAddr());
				aBean.setBirth(mBean.getBirth());
				aBean.setRole(null);
				session.setAttribute("user", aBean);
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
/*			Map<String,String[]> map = new HashMap<String,String[]>();
			map = request.getParameterMap();
			String[] arr = map.get("subject");
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				buff.append(arr[i]+"/");			
			}*/
			String[] arr = request.getParameterValues("subject");
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				buff.append(arr[i]+"/");			
			}
			mBean.setId(request.getParameter("id"));
			mBean.setPassword(request.getParameter("password"));
			mBean.setName(request.getParameter("name"));
			mBean.setAddr(request.getParameter("addr"));
			mBean.setBirth(Integer.parseInt(request.getParameter("addr")));
			mBean.setMajor(request.getParameter("addr"));
			mBean.setSubject(buff.toString());

			if (service.join(mBean) == 1) {
				command = CommandFactory.createCommand(arrStr.get(0), "login_form");
			} else {
				command = CommandFactory.createCommand(arrStr.get(0), "join_form");
			}
			break;
		case "update":
			System.out.println(request.getParameter("id")+""+ request.getParameter("password")+""+
					request.getParameter("addr")+"laisdcuhasdc");
			if (service.update(request.getParameter("id"), request.getParameter("password"),
					request.getParameter("addr")) == 1) {
				aBean.setId(request.getParameter("id"));
				aBean.setPassword(request.getParameter("password"));
				aBean.setName(request.getParameter("name"));
				aBean.setAddr(request.getParameter("addr"));
				aBean.setBirth(Integer.parseInt(request.getParameter("birth")));
				aBean.setRole(null);
				session.setAttribute("user", aBean);
				command = CommandFactory.createCommand(arrStr.get(0), "detail");
			} else {
				command = CommandFactory.createCommand(arrStr.get(0), "update_form");
			}
			break;
		case "logout":
			session.invalidate(); // 세션 종료 , bom 이 상위 객체이므로 bom을 비우면 dom의 값도 날라감
			command = CommandFactory.createCommand(arrStr.get(0), "login_form");
			break;
		case "delete":
			System.out.println("@@@@@delete@@@@@");
			int result = service.delete(request.getParameter("id"));
			System.out.println(result);
			if (result == 1) {
				command = CommandFactory.createCommand(arrStr.get(0), "login_form");
				session.invalidate();
			} else {
				command = CommandFactory.createCommand(arrStr.get(0), "detail");
			}
			break;
		default:
			// command = CommandFactory.createCommand(arrStr.get(0),
			// arrStr.get(1));
			break;
		}
		System.out.println("오픈될 페이지 :" + command.getView());
		DispatcherServlet.go(request, response, command.getView());
	}

}
