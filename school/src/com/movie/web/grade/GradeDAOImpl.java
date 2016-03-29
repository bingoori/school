package com.movie.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.member.MemberBean;

public class GradeDAOImpl implements GradeDAO {

	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체 2
	private ResultSet rs; // 쿼리결과 (리턴값 회수 객체)
    private static GradeDAO  instance = new GradeDAOImpl();
    
	public static GradeDAO getInstance() {
		return instance;
	}

	public GradeDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}

	@Override
	public void insert(GradeMemberBean gradememberBean) {
		try {
			
			
			String sql1 = " INSERT INTO Member VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, gradememberBean.getId());
			pstmt.setString(2, gradememberBean.getPassword());
			pstmt.setString(3, gradememberBean.getName());
			pstmt.setString(4, gradememberBean.getAddr());
			pstmt.setInt(5, gradememberBean.getBirth());
			pstmt.executeUpdate();
			// conn.commit();
			String sql2 = " INSERT INTO Grade VALUES(hak.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, gradememberBean.getId());
			pstmt.setInt(2, gradememberBean.getJava());
			pstmt.setInt(3, gradememberBean.getSql());
			pstmt.setInt(4, gradememberBean.getJsp());
			pstmt.setInt(5, gradememberBean.getSpring());
			pstmt.executeUpdate();
			conn.commit();
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
			System.out.println("selectByName에서 에러 발생");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<GradeMemberBean> selectAll() {
		GradeMemberBean grademember;
		ArrayList<GradeMemberBean> arrList = new ArrayList<GradeMemberBean>();
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			// SELECT * FROM GradeMember WHERE hak = 9000127;
			while (rs.next()) {
				grademember = new GradeMemberBean();
				grademember.setId(rs.getString("id"));
				grademember.setPassword(rs.getString("password"));
				grademember.setName(rs.getString("name"));
				grademember.setAddr(rs.getString("addr"));
				grademember.setBirth(rs.getInt("birth"));
				grademember.setHak(rs.getInt("hak"));
				grademember.setJava(rs.getInt("java"));
				grademember.setJsp(rs.getInt("jsp"));
				grademember.setSpring(rs.getInt("spring"));
				grademember.setSql(rs.getInt("sql"));
				arrList.add(grademember);
			}
		} catch (Exception e) {
			System.out.println("selectByName에서 에러 발생");
			e.printStackTrace();
		}
		return arrList;
	}

	@Override
	public GradeMemberBean selectGradeByHak(int hak) {
		MemberBean member = new MemberBean();
		GradeBean grade = new GradeBean();
		GradeMemberBean grademember = new GradeMemberBean();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE hak =" + "'" + hak + "'");
			// SELECT * FROM GradeMember WHERE hak = 9000127;
			while (rs.next()) {
				grademember.setId(rs.getString("id"));
				grademember.setPassword(rs.getString("password"));
				grademember.setName(rs.getString("name"));
				grademember.setAddr(rs.getString("addr"));
				grademember.setBirth(rs.getInt("birth"));
				grademember.setHak(rs.getInt("hak"));
				grademember.setJava(rs.getInt("java"));
				grademember.setJsp(rs.getInt("jsp"));
				grademember.setSpring(rs.getInt("spring"));
				grademember.setSql(rs.getInt("sql"));
			}
			/*
			 * while(rs.next()) { member.setId(rs.getString("id"));
			 * member.setPassword(rs.getString("password"));
			 * member.setName(rs.getString("name"));
			 * member.setAddr(rs.getString("addr"));
			 * member.setBirth(rs.getInt("birth"));
			 * grade.setHak(rs.getInt("hak")); grade.setId(rs.getString("id"));
			 * grade.setJava(rs.getInt("java")); grade.setJsp(rs.getInt("jsp"));
			 * grade.setSpring(rs.getInt("spring"));
			 * grade.setSql(rs.getInt("sql")); }
			 */
		} catch (Exception e) {
			System.out.println("selectById에서 에러 발생");
			e.printStackTrace();
		}
		/*
		 * map.put("member", member); map.put("grade", grade);
		 */
		return grademember;
	}

	@Override
	public ArrayList<GradeMemberBean> selectGradeByName(String name) {
		GradeMemberBean grademember;
		ArrayList<GradeMemberBean> arrList = new ArrayList<GradeMemberBean>();
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE name =" + "'" + name + "'");
			// SELECT * FROM GradeMember WHERE hak = 9000127;
			while (rs.next()) {
				grademember = new GradeMemberBean();
				grademember.setId(rs.getString("id"));
				grademember.setPassword(rs.getString("password"));
				grademember.setName(rs.getString("name"));
				grademember.setAddr(rs.getString("addr"));
				grademember.setBirth(rs.getInt("birth"));
				grademember.setHak(rs.getInt("hak"));
				grademember.setJava(rs.getInt("java"));
				grademember.setJsp(rs.getInt("jsp"));
				grademember.setSpring(rs.getInt("spring"));
				grademember.setSql(rs.getInt("sql"));
				arrList.add(grademember);
			}
		} catch (Exception e) {
			System.out.println("selectByName에서 에러 발생");
			e.printStackTrace();
		}
		return arrList;
	}

	@Override
	public int Count() {
		int count = 0;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// stmt.executeQuery("SELECT * FROM Member").last();
			// count = rs.getRow();
			// rs = stmt.executeQuery("SELECT * FROM GradeMember");
			rs = stmt.executeQuery("SELECT count(*) AS count FROM GradeMember");
			// rs.last(); // 커서이동
			// count = rs.getRow();
			System.out.println(count + "countcountcoutn");
			while (rs.next()) {
				count = rs.getInt("count");
				// count = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("selectById에서 에러 발생");
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String update(int hak, int java, int jsp, int sql, int spring) {
		try {
			pstmt = conn.prepareStatement("update Grade set java = ?, sql = ?, jsp = ?, spring = ?" + "where hak = ?");
			pstmt.setInt(1, java);
			pstmt.setInt(2, jsp);
			pstmt.setInt(3, sql);
			pstmt.setInt(4, spring);
			pstmt.setInt(5, hak);
			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			System.out.println("회원 수정에서 에러 발생");
			e.printStackTrace();

		}
		return "회원 수정 완료";
	}

	@Override
	public String delete(String id) {
		try {
			String sql1 = "delete from Member where id ='" + id + "'";
			String sql2 = "delete from Grade where id ='" + id + "'";
			stmt = conn.createStatement();
			stmt.executeQuery(sql1);
			stmt.executeQuery(sql2);
			conn.commit();

		} catch (Exception e) {
			System.out.println("selectById에서 에러 발생");
			e.printStackTrace();
			return "Failed";
		}
		return "Complete";
	}

	@Override
	public GradeBean selectGradeById(String id) {
		MemberBean member = new MemberBean();
		GradeBean grade = new GradeBean();
		// GradeMemberBean grademember = new GradeMemberBean();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Grade WHERE id =" + "'" + id + "'");
			// SELECT * FROM GradeMember WHERE hak = 9000127;
			while (rs.next()) {
				grade.setId(id);
				grade.setHak(rs.getInt("score_seq"));
				grade.setJava(rs.getInt("java"));
				grade.setJsp(rs.getInt("jsp"));
				grade.setSpring(rs.getInt("spring"));
				grade.setSql(rs.getInt("sql"));
			}
			/*
			 * while(rs.next()) { member.setId(rs.getString("id"));
			 * member.setPassword(rs.getString("password"));
			 * member.setName(rs.getString("name"));
			 * member.setAddr(rs.getString("addr"));
			 * member.setBirth(rs.getInt("birth"));
			 * grade.setHak(rs.getInt("hak")); grade.setId(rs.getString("id"));
			 * grade.setJava(rs.getInt("java")); grade.setJsp(rs.getInt("jsp"));
			 * grade.setSpring(rs.getInt("spring"));
			 * grade.setSql(rs.getInt("sql")); }
			 */
		} catch (Exception e) {
			System.out.println("selectById에서 에러 발생");
			e.printStackTrace();
		}
		/*
		 * map.put("member", member); map.put("grade", grade);
		 */
		return grade;
	}
	
	@Override
	public List<GradeBean> selectGradeAll() {
		List<GradeBean> grade = new ArrayList<GradeBean>();
		GradeBean temp;
			
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Grade ");
			
			while (rs.next()) {
				temp = new GradeBean();
				temp.setHak(rs.getInt("score_seq"));
				temp.setId(rs.getString("id"));				
				temp.setJava(rs.getInt("java"));
				temp.setJsp(rs.getInt("jsp"));
				temp.setSql(rs.getInt("sql"));
				temp.setSpring(rs.getInt("spring"));
				grade.add(temp);
			}				

		} catch (Exception e) {
			System.out.println("selectById에서 에러 발생");
			e.printStackTrace();
		}

		return grade;
	}

}
