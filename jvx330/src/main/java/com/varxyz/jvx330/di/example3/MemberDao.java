package com.varxyz.jvx330.di.example3;

import java.util.List;

public class MemberDao {
	public List<Member> findAllMember(){
		return List.of(new Member("java", "유비"), new Member("Spring", "관우"));
	}
}
