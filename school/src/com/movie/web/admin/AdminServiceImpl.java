package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeMemberBean;

public class AdminServiceImpl implements AdminService{
	private AdminDAO dao = AdminDAOImpl.getDao();
private static AdminService service = new AdminServiceImpl();
	public static AdminService getService() {
	return service;
}


	@Override
	public List<GradeMemberBean> getMemberList() {
		
		return null;
	}

	@Override
	public int addScore(GradeMemberBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
