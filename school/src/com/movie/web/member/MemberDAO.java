package com.movie.web.member;

public interface MemberDAO {

	public String insert(MemberBean member);

	public MemberBean selectById(String id, String password);

	public MemberBean selectMember(String id);

	public MemberBean update(String id, String string, int i, String string2);

	public String delete(String id, int password);
	
	public boolean isMember(String id);
	
}
