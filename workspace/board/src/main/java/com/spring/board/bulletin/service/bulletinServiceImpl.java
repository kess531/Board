package com.spring.board.bulletin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.bulletin.dao.bulletinDAO;
import com.spring.board.bulletin.dto.bulletinDTO;

@Service
public class bulletinServiceImpl implements bulletinService {

	@Autowired
	private bulletinDAO bulletindao;
	
	@Override
	public List<bulletinDTO> bulletinList() {
	
		return bulletindao.bulletinList();
	}

	@Override
	public List<bulletinDTO> bulletinSearchTitle(String keyword) {
		return bulletindao.bulletinSearchTitle(keyword);
	}

	@Override
	public List<bulletinDTO> bulletinSearchMember(String keyword) {
		return bulletindao.bulletinSearchMember(keyword);
	}

	@Override
	public List<bulletinDTO> bulletinSearchContent(String keyword) {
		return bulletindao.bulletinSearchContent(keyword);
	}

	@Override
	public List<bulletinDTO> bulletinSearchTotal(String keyword) {
		return bulletindao.bulletinSearchTotal(keyword);
	}
	
	

}
