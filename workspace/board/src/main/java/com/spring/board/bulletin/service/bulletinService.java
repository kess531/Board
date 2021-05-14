package com.spring.board.bulletin.service;

import java.util.List;

import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.dto.commentDTO;
import com.spring.board.bulletin.utill.Criteria;
import com.spring.board.bulletin.utill.CriteriaCmt;

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
		//글 수정
		public void bulletinUpdate(bulletinDTO dto);
		//글 삭제
		public void bulletinDelete(int bltNo);
		//글 확인
		public List<bulletinDTO> bulletinContentView(int bltNo);
		//조회수 증가
		public void bulletinViewCnt(int bltNo);
		//좋아요 증가
		public void bulletinLikeCnt(int bltNo);
		//좋아요 조회
		public String bulletinLikeSelect(int bltNo);
		
		//댓글작성
		public void commentWrite(commentDTO dto);
		//댓글 리스트
		public List<commentDTO> commentList(CriteriaCmt cmt);
		public int commentListCount(int bltNo);
		
		//댓글 삭제
		public void commentDelete(int cmtNo);
		
		//비밀번호 확인
		public String commentPwdSelect(int cmtNo);
}
