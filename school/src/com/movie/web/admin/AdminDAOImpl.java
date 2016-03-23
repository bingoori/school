package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public class AdminDAOImpl implements AdminDAO{
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체 2
	private ResultSet rs; // 쿼리결과 (리턴값 회수 객체)
private static AdminDAO dao = new AdminDAOImpl();

	public static AdminDAO getDao() {
	return dao;
}

public static void setDao(AdminDAO dao) {
	AdminDAOImpl.dao = dao;
}
public AdminDAOImpl() {
	conn = DatabaseFactory.getDatabase(Vendor.ORACLE,Constants.ID,Constants.PASSWORD).getConnection();
}
	@Override
	public List<GradeMemberBean> getMemberList() {
		GradeMemberBean grademember;
		List<GradeMemberBean> arrList = new ArrayList<GradeMemberBean>();
		try {
			String sql = " SELECT * FROM GradeMember ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				grademember = new GradeMemberBean();
				grademember.setId(rs.getString("id"));
				grademember.setPassword(rs.getString("password"));
				grademember.setName(rs.getString("name"));
				grademember.setAddr(rs.getString("addr"));
				grademember.setBirth(rs.getInt("birth"));
				grademember.setHak(rs.getInt("score_seq"));
				grademember.setJava(rs.getInt("java"));
				grademember.setJsp(rs.getInt("jsp"));
				grademember.setSpring(rs.getInt("spring"));
				grademember.setSql(rs.getInt("sql"));
				arrList.add(grademember);
				
			}
		} catch (SQLException e) {
			System.out.println("getMemberList에서 에러 발생");
			e.printStackTrace();
		}
		return arrList;
	}

	@Override
	public int addScore(GradeBean gBean) {
		int result = 0;
		try {
			String sql = " INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) VALUES (score_seq.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gBean.getId());
			pstmt.setInt(2, gBean.getJava());
			pstmt.setInt(3, gBean.getJsp());
			pstmt.setInt(4, gBean.getSql());
			pstmt.setInt(5, gBean.getSpring());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("getMemberList에서 에러 발생");
			e.printStackTrace();
		}
		return result;
	}

}
