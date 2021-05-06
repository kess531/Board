package com.spring.board.bulletin.utill;

import org.springframework.beans.factory.annotation.Autowired;

//�Խ��� ����¡ �ϴ� �ι� ���
public class PageMakerCmt {

	private int totalCount;     // �Խ��� ��ü ������ ����
	private int displayPageNum = 10;   // �Խ��� ȭ�鿡�� �ѹ��� ������ ������ ��ȣ�� ���� ( 1,2,3,4,5,6,7,9,10)
	private int startPage;      // ���� ȭ�鿡�� ���̴� startPage ��ȣ
	private int endPage;        // ���� ȭ�鿡 ���̴� endPage ��ȣ
	private boolean prev;       // ����¡ ���� ��ư Ȱ��ȭ ����
	private boolean next;       // ����¡ ���� ��ư Ȱ��ȭ ����
	
	@Autowired
	private CriteriaCmt cmt;       // �ռ� ������ Criteria�� ���Թ޴´�.

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		endPage = (int) (Math.ceil(cmt.getPage() / (double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cmt.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		System.out.println("totalcount" + totalCount);
		System.out.println("���� ������ : " + startPage);
		System.out.println("������ ������ : " + endPage);
		System.out.println("�Խñ�: " + tempEndPage );
		prev = startPage == 1 ? false : true;
		
		next = endPage * cmt.getPerPageNum() >= totalCount ? false : true;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public CriteriaCmt getCmt() {
		return cmt;
	}

	public void setCmt(CriteriaCmt cmt) {
		this.cmt = cmt;
	}


	

		
}
