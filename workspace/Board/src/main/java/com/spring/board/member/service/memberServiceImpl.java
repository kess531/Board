package com.spring.board.member.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.member.dao.memberDAO;
import com.spring.board.member.dto.memberDTO;

@Service
public class memberServiceImpl implements memberService {

	@Autowired
	private memberDAO memberDao;
	@Override
	
	public List<memberDTO> memberList() {

		return memberDao.memberList();
	}

}
