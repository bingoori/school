package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeMemberBean;

public class AdminDAOImpl implements AdminDAO{
private static AdminDAO dao = new AdminDAOImpl();

	public static AdminDAO getDao() {
	return dao;
}

public static void setDao(AdminDAO dao) {
	AdminDAOImpl.dao = dao;
}

	@Override
	public List<GradeMemberBean> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addScore(GradeMemberBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
