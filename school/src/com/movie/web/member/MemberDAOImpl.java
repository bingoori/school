package com.movie.web.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체 2
	private ResultSet rs; // 쿼리결과 (리턴값 회수 객체)
	private static MemberDAO instatnce = new MemberDAOImpl();

	public static MemberDAO getInstatnce() {
		return instatnce;
	}

	public MemberDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
		// conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID,
		// Constants.PASSWORD).getConnection();

	}

	@Override
	public int insert(MemberBean member) {
		
		int result = 0;
		try {
			String sql = " INSERT INTO Member(id,password,name,addr,birth) VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddr());
			pstmt.setInt(5, member.getBirth());
			result = pstmt.executeUpdate();
			
      	
			/*
			 * create table Grade( hak number PRIMARY KEY, id VARCHAR2(30) NOT
			 * NULL, java number, sql number, jsp number, spring number );
			 */
			/*
			 * CREATE TABLE Member( id VARCHAR2(30) PRIMARY KEY, password
			 * VARCHAR2(30) NOT NULL, name VARCHAR2(26) NOT NULL, addr
			 * VARCHAR2(100), birth NUMBER );
			 */
			/*
			 * int hak,String id,int java, int jsp, int sql, int spring, String
			 * password, String name, String addr, int birth
			 */
			// SELECT * FROM GradeMember WHERE hak = 9000127;
		} catch (Exception e) {
			System.out.println("insert()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("회원가입 성공 여부 "+result);
		return result;
	}

	@Override
	public MemberBean selectById(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean selectMember(String id) {
		System.out.println("@@@@  " + id + "  @@@@");
		MemberBean temp = new MemberBean();
		try {
			stmt = conn.createStatement();
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
			stmt = conn.createStatement();
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
