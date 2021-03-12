package com.spring.board.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


	@Override
	public String login(memberDTO dto) {
		// TODO Auto-generated method stub
	String pw = dto.getMemberPw();
	String Id = dto.getMemberId();
	String rpw= memberdao.memberLogin(dto).getMemberPw();
	if(passwordencoder.matches(pw, rpw)) {
		System.out.println("성공" + pw + rpw);
		return Id;
	}
	else {
		System.out.println("실패" + pw + rpw);
		return null;
	}
	
			
	}




}
