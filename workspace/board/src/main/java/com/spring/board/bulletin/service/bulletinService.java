package com.spring.board.bulletin.service;

import java.util.List;

import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.utill.Criteria;

public interface bulletinService {

	//게시글 불러오기
		public List<bulletinDTO> bulletinList(Criteria criteria);
		//제목 검색
		public List<bulletinDTO> bulletinSearchTitle(Criteria criteria);
		//작성자 검색
		public List<bulletinDTO> bulletinSearchMember(Criteria criteria);
		//내용 검색
		public List<bulletinDTO> bulletinSearchContent(Criteria criteria);
		//제목+내용 검색
		public List<bulletinDTO> bulletinSearchTotal(Criteria criteria);
		
		//페이징
		public int listCountCriteria();
		public int listTitleCountCriteria(Criteria criteria);
		public int listMemberCountCriteria(Criteria criteria);
		public int listContentCountCriteria(Criteria criteria);
		public int listTotalCountCriteria(Criteria criteria);
		
		//글 작성
		public void bulletinWrite(bulletinDTO dto);
}
