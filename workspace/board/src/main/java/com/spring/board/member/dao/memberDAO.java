package com.spring.board.member.dao;

import java.util.List;

import com.spring.board.member.dto.memberDTO;

public interface memberDAO {
	
	public List<memberDTO> memberList();
	//ȸ������
	public void memberInsert(memberDTO dto);
	//�α���
	public memberDTO memberLogin(memberDTO dto);
	public String memberLoginName(memberDTO dto);
	public int memberLoginCheck(String memberId);
}
