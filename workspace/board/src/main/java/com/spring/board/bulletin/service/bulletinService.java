package com.spring.board.bulletin.service;

import java.util.List;

import com.spring.board.bulletin.dto.bulletinDTO;

public interface bulletinService {

	//�Խñ� �ҷ�����
		public List<bulletinDTO> bulletinList();
		//���� �˻�
		public List<bulletinDTO> bulletinSearchTitle(String keyword);
		//�ۼ��� �˻�
		public List<bulletinDTO> bulletinSearchMember(String keyword);
		//���� �˻�
		public List<bulletinDTO> bulletinSearchContent(String keyword);
		//����+���� �˻�
		public List<bulletinDTO> bulletinSearchTotal(String keyword);
}
