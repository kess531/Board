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


	@Override
	public String login(memberDTO dto) {
		// TODO Auto-generated method stub

	String memberpw = dto.getMemberPw();
	String memberId = dto.getMemberId();
	System.out.println("에러1");
	String rpw= memberdao.memberLogin(dto).getMemberPw();
	if(rpw == null) {
		System.out.println("에러2");
		return "failLogin";
	}
	else {
		System.out.println("에러3");
		if(passwordencoder.matches(memberpw, rpw)) {
			System.out.println("성공" + memberpw + rpw);
			return memberId;
		}
		else {
			System.out.println("실패" + memberpw + rpw);
			return null;
		}
		
	}
	
			
	}


	@Override
	public String memberLoginName(memberDTO dto) {
	
		String memberName = memberdao.memberLoginName(dto);
		return memberName;
	}


	@Override
	public int memberLoginCheck(String memberId) {
		int memberidcnt = memberdao.memberLoginCheck(memberId);
		return memberidcnt;
	}




}
