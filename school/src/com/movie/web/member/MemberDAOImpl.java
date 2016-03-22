package com.movie.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.movie.web.global.Constants;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체 2
	private ResultSet rs; // 쿼리결과 (리턴값 회수 객체)

	public MemberDAOImpl() {

	}

	@Override
	public String insert(MemberBean member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean selectById(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean selectMember(String id) {
		MemberBean temp = new MemberBean();
		try {
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id =" + "'" + id + "'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setPassword(rs.getString("password"));
				temp.setName(rs.getString("name"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
		} catch (Exception e) {
			System.out.println("selectById에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 :" + temp.getId());
		return temp;
	}

	@Override
	public MemberBean update(String id, String string, int i, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id, int password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMember(String id, String password) {
		boolean result = false;
		try {
			rs = stmt.executeQuery(
					"SELECT id AS id FROM Member WHERE id =" + "'" + id + "'" + "AND password=" + "'" + password + "'");
			// rs.last(); // 커서이동
			// count = rs.getRow();
			String strId = "";
			while (rs.next()) {
				strId = rs.getString("id");
				// count = rs.getInt(1);
			}
			if (strId.equals("")) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("selectById에서 에러 발생");
			e.printStackTrace();
		}

		return result;
	}

}
