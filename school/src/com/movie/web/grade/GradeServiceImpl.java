package com.movie.web.grade;

import java.util.ArrayList;
import java.util.List;

public class GradeServiceImpl implements GradeService {
	/*
	 * private String name; private int hak, java, sql, jsp, spring;
	 */

	// 멤버 필드
	// 속성을 모아놓은곳 (Bean)
	private ArrayList<GradeBean> gradeList;
	private GradeDAO dao = GradeDAOImpl.getInstance();
	private static GradeService service = new GradeServiceImpl();
	
	public static GradeService getService() {
		return service;
	}

	// Vector<GradeBean> gradeList = new Vector<GradeBean>(); //인스턴스변수
	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>(); // 인스턴스 변수 초기화
	}
	// 메서드 내부에 위치하면 참조변수(공유를 안하므로)
	// 멤버 메소드 에어리어
	// 기능을 모아놓은곳(Service)

	@Override
	public void insert(GradeMemberBean gradememberBean) {
		// 성적표 등록 C
		dao.insert(gradememberBean);
	}

	@Override
	public ArrayList<GradeMemberBean> getList() {
		// 성적표 리스트 출력 R

		return dao.selectAll();

	}

	@Override
	public GradeMemberBean getGradeByHak(int hak) {

		return dao.selectGradeByHak(hak);

	}

	@Override
	public ArrayList<GradeMemberBean> getGradesByName(String name) {
		// 성적표 조회(이름) R

		return dao.selectGradeByName(name);
	}

	@Override
	public String update(int hak, int java, int jsp, int sql, int spring) {
		// 성적표 수정 U
		String temp = "수정하려는 학번의 정보가 없습니다.";
		if (dao.selectGradeByHak(hak) != null) {
			/*
			 * GradeBean searchGrade = getGradeByHak(hak);
			 * searchGrade.setJava(java); searchGrade.setSql(sql);
			 * searchGrade.setJsp(jsp); searchGrade.setSpring(spring);
			 */
			dao.update(hak, java, jsp, sql, spring);
			temp = "수정이 완료되었습니다.";
		}

		/*
		 * this.delete(grade.getHak()); this.input(grade);
		 */
		return temp;
	}

	@Override
	public String delete(String id) {
		return dao.delete(id);
	}

	@Override
	public int getCount() {
		// R 카운트 조회

		return dao.Count();

	}

	@Override
	public GradeBean getGradeById(String id) {

		return dao.selectGradeById(id);
		
	}

	@Override
	public List<GradeBean> selectGradeAll() {
		
		return dao.selectGradeAll();
	}

}
