package com.spring.board.bulletin.utill;

public class CriteriaCmt {
	private int page;
	private int perPageNum;
	private int bltNo;
	

	public int getBltNo() {
		return bltNo;
	}

	public void setBltNo(int bltNo) {
		this.bltNo = bltNo;
	}

	public CriteriaCmt() {
		this.page = 1;
		this.perPageNum = 2;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	} 
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CriteriaCmt [page = " + page + ",perPageNum = " + perPageNum + "]" + "PageStart" + getPageStart() ;
	} 

}
