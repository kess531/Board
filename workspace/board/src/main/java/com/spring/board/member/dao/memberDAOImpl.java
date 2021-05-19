package com.spring.board.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.member.dto.memberDTO;


@Repository
public class memberDAOImpl implements memberDAO {

	//SqlSession 객체 자동주입
	@Autowired
	SqlSession sqlsession;
	
	private static final String namespace ="member.";
	@Override
	public List<memberDTO> memberList() {
		List<memberDTO> list = sqlsession.selectList(namespace + "memberList");
		return list;
	}

	@Override
	public void memberInsert(memberDTO dto) {
		sqlsession.insert(namespace + "memberInsert",dto);
		
	}

	@Override
	public memberDTO memberLogin(memberDTO dto) {
		return sqlsession.selectOne(namespace + "memberLogin",dto);
	}

	@Override
	public String memberLoginName(memberDTO dto) {
		
		return sqlsession.selectOne(namespace + "memberLoginName",dto);
	}

	@Override
	public int memberLoginCheck(String memberId) {
		int memberidcnt =  sqlsession.selectOne(namespace + "memberLoginCheck",memberId);
		return memberidcnt;
	}


	
}

	
