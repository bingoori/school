package com.movie.web.member;

public interface MemberService {
	
	public final static String NAME = "홍길동";

	public String join(MemberBean member);

	public MemberBean login(String id, String password);

	public MemberBean detail(String id);

	public MemberBean update(String id, String string, int i, String string2);

	public String remove(String id, int password);
	
	public boolean isMember(String id,String password);
}
