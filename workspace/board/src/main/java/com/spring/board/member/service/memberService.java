package com.spring.board.member.service;

import java.util.List;

import com.spring.board.member.dto.memberDTO;

public interface memberService {

	public List<memberDTO> memberList();
	
	public void memberInsert(memberDTO dto);
	
	public String login(memberDTO dto);
}
