package com.movie.web.member;

import java.util.List;

public interface MemberService {
	
	public final static String NAME = "홍길동";

	public int join(MemberBean member);

	public MemberBean login(String id);

	public MemberBean detail(String id);

	public int update(String id, String password, String addr);

	public int delete(String id);
	
	public boolean isMember(String id,String password);
	public List<MemberBean> getList();
}
