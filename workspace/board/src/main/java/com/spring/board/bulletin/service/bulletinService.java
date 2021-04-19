package com.spring.board.bulletin.service;

import java.util.List;

import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.utill.Criteria;

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
}
