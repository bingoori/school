package com.movie.web.member;

public interface MemberDAO {

	public int insert(MemberBean member);

	public MemberBean selectById(String id, String password);

	public MemberBean selectMember(String id);

	public int update(String id,String password, String addr);

	public int delete(String id, int password);
	
	public boolean isMember(String id,String password);
	
}
