package com.spring.board.member.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.member.dto.memberDTO;

@Repository
public class memberDAOImpl implements memberDAO {

	@Autowired
	SqlSession sqlsession;
	
	private static final String namespace = "member.";
	
	@Override
	public List<memberDTO> memberList() {
		
		List<memberDTO> list = sqlsession.selectList(namespace + "memberList");
		
		return list;
	}

}
