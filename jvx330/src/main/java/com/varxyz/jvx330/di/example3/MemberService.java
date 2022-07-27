package com.varxyz.jvx330.di.example3;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberService {
	private MemberDao memberDao;
	
	public List<Member> getAllMember(){
		return memberDao.findAllMember();
	}
	
}
