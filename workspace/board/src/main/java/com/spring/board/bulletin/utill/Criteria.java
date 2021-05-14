package com.spring.board.bulletin.utill;

public class Criteria {
	
	private int page;
	private int perPageNum;
	private String keyword;
	

	public Criteria() {
		this.page = 1;
		this.perPageNum = 8;
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
	
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Criteria [page = " + page + ",perPageNum = " + perPageNum + "]" + "PageStart" + getPageStart() + "keyword" +keyword;
	} 


}
