package com.spring.board.bulletin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.bulletin.dto.bulletinDTO;

@Repository
public class bulletinDAOImpl implements bulletinDAO {
	@Autowired
	SqlSession sqlsession;
	
	private static final String namespace ="bulletin.";
	@Override
	public List<bulletinDTO> bulletinList() {
	List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinList"); 
		return list;
	}
	
	@Override
	public List<bulletinDTO> bulletinSearchTitle(String keyword) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinSearchTitle",keyword);
		return list;
	}

	@Override
	public List<bulletinDTO> bulletinSearchMember(String keyword) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinSearchMember",keyword);
		return list;
	}

	@Override
	public List<bulletinDTO> bulletinSearchContent(String keyword) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinSearchContent",keyword);
		return list;
	}

	@Override
	public List<bulletinDTO> bulletinSearchTotal(String keyword) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinSearchTotal",keyword);
		return list;
	}

}
