package com.spring.board.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.board.member.dao.memberDAO;
import com.spring.board.member.dto.memberDTO;
@Service
public class memberServiceImpl implements memberService {

	@Autowired
	private memberDAO memberdao;
	
	@Autowired
	PasswordEncoder passwordencoder;
	
	
	@Override
	public List<memberDTO> memberList() {
		
		return memberdao.memberList();
	}


	@Override
	public void memberInsert(memberDTO dto) {
		String encpassword= passwordencoder.encode(dto.getMemberPw());
		dto.setMemberPw(encpassword);
		memberdao.memberInsert(dto);
		
	}

}
