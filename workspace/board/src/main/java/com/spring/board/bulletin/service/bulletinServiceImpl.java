package com.spring.board.bulletin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.bulletin.dao.bulletinDAO;
import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.dto.commentDTO;
import com.spring.board.bulletin.utill.Criteria;
import com.spring.board.bulletin.utill.CriteriaCmt;

@Service
public class bulletinServiceImpl implements bulletinService {

	@Autowired
	private bulletinDAO bulletindao;
	
	@Override
	public List<bulletinDTO> bulletinList(Criteria criteria) {
	
		return bulletindao.bulletinList(criteria);
	}

	@Override
	public List<bulletinDTO> bulletinSearchTitle(Criteria criteria) {
		return bulletindao.bulletinSearchTitle(criteria);
	}

	@Override
	public List<bulletinDTO> bulletinSearchMember(Criteria criteria) {
		return bulletindao.bulletinSearchMember(criteria);
	}

	@Override
	public List<bulletinDTO> bulletinSearchContent(Criteria criteria) {
		return bulletindao.bulletinSearchContent(criteria);
	}

	@Override
	public List<bulletinDTO> bulletinSearchTotal(Criteria criteria) {
		return bulletindao.bulletinSearchTotal(criteria);
	}

	@Override
	public int listCountCriteria() {
		return bulletindao.listCountCriteria();
	}

	@Override
	public int listTitleCountCriteria(Criteria criteria) {
		return bulletindao.listTitleCountCriteria(criteria);
	}

	@Override
	public int listMemberCountCriteria(Criteria criteria) {
	
		return bulletindao.listMemberCountCriteria(criteria);
	}

	@Override
	public int listContentCountCriteria(Criteria criteria) {
		return bulletindao.listContentCountCriteria(criteria);
	}

	@Override
	public int listTotalCountCriteria(Criteria criteria) {
		return bulletindao.listTotalCountCriteria(criteria);
	}

	@Override
	public void bulletinWrite(bulletinDTO dto) {
		
		bulletindao.bulletinWrite(dto);
	}
	
	@Override
	public void bulletinUpdate(bulletinDTO dto) {

		bulletindao.bulletinUpdate(dto);
		
	}

	@Override
	public void bulletinDelete(int bltNo) {
		
		bulletindao.bulletinDelete(bltNo);;		
	}

	@Override
	public List<bulletinDTO> bulletinContentView(int bltNo) {
	
		return bulletindao.bulletinContentView(bltNo);
	}

	@Override
	public void bulletinViewCnt(int bltNo) {
		
		bulletindao.bulletinViewCnt(bltNo);
		
	}

	@Override
	public void bulletinLikeCnt(int bltNo) {
	
		bulletindao.bulletinLikeCnt(bltNo);
		
	}

	@Override
	public String bulletinLikeSelect(int bltNo) {
		
		return bulletindao.bulletinLikeSelect(bltNo);
	}

	@Override
	public void commentWrite(commentDTO dto) {
		
		bulletindao.commentWrite(dto);
		
	}

	@Override
	public List<commentDTO> commentList(CriteriaCmt cmt) {
		
		return bulletindao.commentList(cmt);
	}

	@Override
	public int commentListCount(int bltNo) {
		
		return bulletindao.commentListCount(bltNo);
	}

	@Override
	public void commentDelete(int cmtNo) {
		
		bulletindao.commentDelete(cmtNo);
		
	}

	@Override
	public String commentPwdSelect(int cmtNo) {
		
		return bulletindao.commentPwdSelect(cmtNo);
	}

	
	

}
