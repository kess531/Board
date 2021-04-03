package com.spring.board.bulletin.dao;

import java.util.List;

import com.spring.board.bulletin.dto.bulletinDTO;

public interface bulletinDAO {
	//게시글 불러오기
	public List<bulletinDTO> bulletinList();
	//제목 검색
	public List<bulletinDTO> bulletinSearchTitle(String keyword);
	//작성자 검색
	public List<bulletinDTO> bulletinSearchMember(String keyword);
	//내용 검색
	public List<bulletinDTO> bulletinSearchContent(String keyword);
	//제목+내용 검색
	public List<bulletinDTO> bulletinSearchTotal(String keyword);
	
	
}
