package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public class AdminServiceImpl implements AdminService {
	private AdminDAO dao = AdminDAOImpl.getDao();
	private static AdminService service = new AdminServiceImpl();

	public static AdminService getService() {
		return service;
	}

	@Override
	public List<GradeMemberBean> getMemberList() {

		return dao.getMemberList();
	}

	@Override
	public int addScore(GradeBean gBean) {
		return dao.addScore(gBean);
		
	}

}
