package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Map;

public interface GradeDAO {
	// 성적표 등록  C
	public void insert(GradeMemberBean gradememberBean); //기능은 추상화하고 속성은 추상화하지 않는다.
	// 성적표 리스트 출력 R
	public ArrayList<GradeMemberBean> selectAll();
	// 성적표 조회(학번) R
	public GradeMemberBean selectGradeByHak(int hak);
	// 성적표 조회(이름) R
	public GradeBean selectGradeById(String id);
	// 성적표 조회(이름) R
	public ArrayList<GradeMemberBean> selectGradeByName(String name);
	// R 카운트 조회
	public int Count();
	// 성적표 수정 U
	public String update(int hak,int java,int jsp,int sql,int spring);
	// 성적표 삭제 D
	public String delete(String id);
	// 전제 성적조회
	public GradeBean selectGradeAll();
}
