package com.movie.web.admin;

import com.movie.web.member.MemberBean;

public class AdminBean extends MemberBean{
	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String string) {
		this.role = string;
	}

	@Override
	public String toString() {
		return "회원정보 [아이디=" + getId() + ", 비밀번호=" + getPassword() + ", 이름=" + getName() + ", 주소=" + getAddr() + ", 생년월일="
				+ getBirth() + ",role="+role+"]";
	}

 



}
