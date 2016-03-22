package com.movie.web.grade;

/**
 *@package : grade
 *@file : GradeBean.java
 *@author sdwoo90@gmail.com
 *@date 2016. 3. 14.
 *@story
 */
public class GradeBean {
	private String id;
	private int hak, java, sql, jsp, spring;
	
	
	//생성자 오버로딩
	public GradeBean() {
	
	}
	
	public GradeBean(int hak,String id,int java, int sql, int jsp , int spring) {
		this.id = id;
		this.hak = hak;
		this.java = java;
		this.sql = sql;
		this.jsp = jsp;
		this.spring = spring;
	}
	public int getHak() {
		return hak;
	}

	public void setHak(int hak) {
		this.hak = hak;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getSql() {
		return sql;
	}

	public void setSql(int sql) {
		this.sql = sql;
	}

	public int getJsp() {
		return jsp;
	}

	public void setJsp(int jsp) {
		this.jsp = jsp;
	}

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "성적 [이름=" + id + ", 학점=" + hak + ", 자바=" + java + ", SQL=" + sql + ", JSP=" + jsp
				+ ", 스프링=" + spring + "]";
	}
}
