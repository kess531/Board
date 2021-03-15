package com.spring.board.member.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class memberDTO {


	private int memberNo;
	
	@NotEmpty
	@Length(min=5, max=20)
	private String memberId;
	@NotEmpty
	@Length(min=5, max=20)
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{5,}")
	private String memberPw;
	@NotEmpty
	@Email
	private String memberEmail;
	@NotEmpty
	@Length(min=2, max=10)
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{2,}")
	private String memberName;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	
}
