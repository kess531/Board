package com.spring.board.member.dao;

import java.util.List;

import com.spring.board.member.dto.memberDTO;

public interface memberDAO {
	
	public List<memberDTO> memberList();
	//회원가입
	public void memberInsert(memberDTO dto);
	//로그인
	public memberDTO memberLogin(memberDTO dto);
	public String memberLoginName(memberDTO dto);
	public int memberLoginCheck(String memberId);
}
