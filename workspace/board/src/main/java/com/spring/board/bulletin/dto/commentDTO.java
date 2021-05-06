package com.spring.board.bulletin.dto;

public class commentDTO {

	private int cmtNo;
	private int bltNo;
	private String cmtContent;
	private String memberName;
	private String cmtDate;
	private String cmtPassword;
	
	public int getCmtNo() {
		return cmtNo;
	}
	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}
	public int getBltNo() {
		return bltNo;
	}
	public void setBltNo(int bltNo) {
		this.bltNo = bltNo;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCmtDate() {
		return cmtDate;
	}
	public void setCmtDate(String cmtDate) {
		this.cmtDate = cmtDate;
	}
	public String getCmtPassword() {
		return cmtPassword;
	}
	public void setCmtPassword(String cmtPassword) {
		this.cmtPassword = cmtPassword;
	}
	
	
	
	
}
