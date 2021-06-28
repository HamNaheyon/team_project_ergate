package edu.kh.semi.member.model.vo;

import java.sql.Date;

public class ComMember {
	
	private int memberNo;
	private String comId;
	private String comPw;
	private String comPhone;
	private String comEmail;
	private String juminNum;
	private String memberGrade;
	private String manager;
	private String companyName;
	private String companyNo;
	private Date enrollDate;
	
	
	

	/** 로그인 VO
	 * @param memberNo
	 * @param comId
	 * @param comPhone
	 * @param comEmail
	 * @param juminNum
	 * @param memberGrade
	 * @param manager
	 * @param companyName
	 * @param companyNo
	 * @param enrollDate
	 */
	public ComMember(int memberNo, String comId, String comPhone, String comEmail, String juminNum, String memberGrade,
			String manager, String companyName, String companyNo, Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.comId = comId;
		this.comPhone = comPhone;
		this.comEmail = comEmail;
		this.juminNum = juminNum;
		this.memberGrade = memberGrade;
		this.manager = manager;
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.enrollDate = enrollDate;
	}


	public ComMember(String comId, String comPw, String comPhone, String comEmail, String juminNum, String manager,
			String companyName, String companyNo) {
		super();
		this.comId = comId;
		this.comPw = comPw;
		this.comPhone = comPhone;
		this.comEmail = comEmail;
		this.juminNum = juminNum;
		this.manager = manager;
		this.companyName = companyName;
		this.companyNo = companyNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getComId() {
		return comId;
	}


	public void setComId(String comId) {
		this.comId = comId;
	}


	public String getComPw() {
		return comPw;
	}


	public void setComPw(String comPw) {
		this.comPw = comPw;
	}


	public String getComPhone() {
		return comPhone;
	}


	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}


	public String getComEmail() {
		return comEmail;
	}


	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}


	public String getJuminNum() {
		return juminNum;
	}


	public void setJuminNum(String juminNum) {
		this.juminNum = juminNum;
	}


	public String getMemberGrade() {
		return memberGrade;
	}


	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}


	@Override
	public String toString() {
		return "ComMember [memberNo=" + memberNo + ", comId=" + comId + ", comPw=" + comPw + ", comPhone=" + comPhone
				+ ", comEmail=" + comEmail + ", juminNum=" + juminNum + ", memberGrade=" + memberGrade + ", manager="
				+ manager + ", companyName=" + companyName + ", companyNo=" + companyNo + ", enrollDate=" + enrollDate
				+ "]";
	}
	
	
	
	
}
