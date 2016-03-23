package com.movie.web.member;

import java.util.HashMap;

public class MemberServiceImpl implements MemberService {

	private HashMap<String, MemberBean> map; // Bean객체를 키값으로 지정
	private MemberDAO dao = MemberDAOImpl.getInstatnce();
    private static MemberService service = new MemberServiceImpl();
    
	public static MemberService getService() {
		return service;
	}

	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}

	@Override
	public int join(MemberBean member) {
		
		return dao.insert(member);
	}

	@Override
	public MemberBean login(String id) {
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 경우에 따라서
		// 메시지를 전달해줘야 함
		return dao.selectMember(id);
	}

	@Override
	public int update(String id , String password, String addr) {
		// 회원 수정
	
		return dao.update(id, password, addr);
	}

	@Override
	public int remove(String id, int password) {
		// 회원 삭제
		return 1;
	}

	@Override
	public MemberBean detail(String id) {
		return dao.selectMember(id);
	}

	@Override
	public boolean isMember(String id, String password) {

		return dao.isMember(id, password);
	}

}
