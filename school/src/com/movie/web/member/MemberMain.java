package com.movie.web.member;

import java.util.Scanner;

public class MemberMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		MemberService service = new MemberServiceImpl();
		MemberBean BeanProperty= null;
		while (true) {

			System.out.println("[메뉴] 1.회원가입 2.로그인 3.내 정보 보기 4.내 정보 수정 5.탈퇴 6.종료");
			

		}
	}
}
