package com.spring.board.bulletin.dto;

import java.util.Date;

public class bulletinDTO {
	
	private int bltNo;
	private String bltTitle;
	private String bltContent;
	private String bltType;
	private int bltCnt;
	private int bltLike;
	private String bltDate;
	private String memberName;
	public int getBltNo() {
		return bltNo;
	}
	public void setBltNo(int bltNo) {
		this.bltNo = bltNo;
	}
	public String getBltTitle() {
		return bltTitle;
	}
	public void setBltTitle(String bltTitle) {
		this.bltTitle = bltTitle;
	}
	public String getBltContent() {
		return bltContent;
	}
	public void setBltContent(String bltContent) {
		this.bltContent = bltContent;
	}
	public String getBltType() {
		return bltType;
	}
	public void setBltType(String bltType) {
		this.bltType = bltType;
	}
	public int getBltCnt() {
		return bltCnt;
	}
	public void setBltCnt(int bltCnt) {
		this.bltCnt = bltCnt;
	}
	public int getBltLike() {
		return bltLike;
	}
	public void setBltLike(int bltLike) {
		this.bltLike = bltLike;
	}
	public String getBltDate() {
		return bltDate;
	}
	public void setBltDate(String bltDate) {
		this.bltDate = bltDate;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
}
