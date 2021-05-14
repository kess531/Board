package com.spring.board.bulletin.service;

import java.util.List;

import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.dto.commentDTO;
import com.spring.board.bulletin.utill.Criteria;
import com.spring.board.bulletin.utill.CriteriaCmt;

public interface bulletinService {

	//�Խñ� �ҷ�����
		public List<bulletinDTO> bulletinList(Criteria criteria);
		//���� �˻�
		public List<bulletinDTO> bulletinSearchTitle(Criteria criteria);
		//�ۼ��� �˻�
		public List<bulletinDTO> bulletinSearchMember(Criteria criteria);
		//���� �˻�
		public List<bulletinDTO> bulletinSearchContent(Criteria criteria);
		//����+���� �˻�
		public List<bulletinDTO> bulletinSearchTotal(Criteria criteria);
		
		//����¡
		public int listCountCriteria();
		public int listTitleCountCriteria(Criteria criteria);
		public int listMemberCountCriteria(Criteria criteria);
		public int listContentCountCriteria(Criteria criteria);
		public int listTotalCountCriteria(Criteria criteria);
		
		//�� �ۼ�
		public void bulletinWrite(bulletinDTO dto);
		//�� ����
		public void bulletinUpdate(bulletinDTO dto);
		//�� ����
		public void bulletinDelete(int bltNo);
		//�� Ȯ��
		public List<bulletinDTO> bulletinContentView(int bltNo);
		//��ȸ�� ����
		public void bulletinViewCnt(int bltNo);
		//���ƿ� ����
		public void bulletinLikeCnt(int bltNo);
		//���ƿ� ��ȸ
		public String bulletinLikeSelect(int bltNo);
		
		//����ۼ�
		public void commentWrite(commentDTO dto);
		//��� ����Ʈ
		public List<commentDTO> commentList(CriteriaCmt cmt);
		public int commentListCount(int bltNo);
		
		//��� ����
		public void commentDelete(int cmtNo);
		
		//��й�ȣ Ȯ��
		public String commentPwdSelect(int cmtNo);
}
