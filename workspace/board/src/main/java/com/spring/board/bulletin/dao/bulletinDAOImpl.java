package com.spring.board.bulletin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.dto.commentDTO;
import com.spring.board.bulletin.utill.Criteria;
import com.spring.board.bulletin.utill.CriteriaCmt;

@Repository
public class bulletinDAOImpl implements bulletinDAO {
	@Autowired
	SqlSession sqlsession;
	
	private static final String namespace ="bulletin.";
	@Override
	public List<bulletinDTO> bulletinList(Criteria criteria) {
	List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinList",criteria); 
		return list;
	}
	
	@Override
	public List<bulletinDTO> bulletinSearchTitle(Criteria criteria) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinSearchTitle",criteria);
		return list;
	}

	@Override
	public List<bulletinDTO> bulletinSearchMember(Criteria criteria) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinSearchMember",criteria);
		return list;
	}

	@Override
	public List<bulletinDTO> bulletinSearchContent(Criteria criteria) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinSearchContent",criteria);
		return list;
	}

	@Override
	public List<bulletinDTO> bulletinSearchTotal(Criteria criteria) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinSearchTotal",criteria);
		return list;
	}

	@Override
	public int listCountCriteria() {
		int listCountCriteria = sqlsession.selectOne(namespace + "listCountCriteria");
		return listCountCriteria;
	}

	@Override
	public int listTitleCountCriteria(Criteria criteria) {
		System.out.println(criteria.getKeyword());
		int listTitleCountCriteria = sqlsession.selectOne(namespace + "listTitleCountCriteria",criteria);
		return listTitleCountCriteria;
	}

	@Override
	public int listMemberCountCriteria(Criteria criteria) {
		int listMemberCountCriteria = sqlsession.selectOne(namespace + "listMemberCountCriteria",criteria);
		return listMemberCountCriteria;
	}

	@Override
	public int listContentCountCriteria(Criteria criteria) {
		int listContentCountCriteria = sqlsession.selectOne(namespace + "listContentCountCriteria",criteria);
		return listContentCountCriteria;
	}

	@Override
	public int listTotalCountCriteria(Criteria criteria) {
		int listTotalCountCriteria = sqlsession.selectOne(namespace + "listTotalCountCriteria",criteria);
		return listTotalCountCriteria;
	}

	@Override
	public void bulletinWrite(bulletinDTO dto) {
		sqlsession.insert(namespace + "bulletinWrite",dto);
	}

	@Override
	public List<bulletinDTO> bulletinContentView(int bltNo) {
		List<bulletinDTO> list = sqlsession.selectList(namespace + "bulletinContentView",bltNo);
		System.out.println("dao단 리스트:" + list);
		return list;
	}

	@Override
	public void bulletinViewCnt(int bltNo) {
		sqlsession.update(namespace+"bulletinViewCnt",bltNo);
		
	}

	@Override
	public void bulletinLikeCnt(int bltNo) {
		sqlsession.update(namespace+"bulletinLikeCnt",bltNo);
	
	}

	@Override
	public String bulletinLikeSelect(int bltNo) {
		
		return sqlsession.selectOne(namespace+"bulletinLikeSelect",bltNo);
	}

	@Override
	public void commentWrite(commentDTO dto) {
		
		sqlsession.insert(namespace+"commentWrite",dto);
		
	}

	@Override
	public List<commentDTO> commentList(CriteriaCmt cmt) {
		List<commentDTO> list = sqlsession.selectList(namespace+"commentList",cmt);
		return list;
	}

	@Override
	public int commentListCount(int bltNo) {
	int commentListCount = sqlsession.selectOne(namespace+"commentListCount",bltNo);
	
		return commentListCount;
	}

	@Override
	public void commentDelete(int cmtNo) {
		
		sqlsession.delete(namespace + "commentDelete",cmtNo);
		
	}

	@Override
	public String commentPwdSelect(int cmtNo) {
		String commentPwdSelect = sqlsession.selectOne(namespace+"commentPwdSelect",cmtNo);
		System.out.println("호이~" + commentPwdSelect);
		return commentPwdSelect;
	}
	

	

}
