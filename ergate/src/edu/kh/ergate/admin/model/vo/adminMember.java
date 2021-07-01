package edu.kh.ergate.admin.model.vo;

import java.sql.Date;

public class adminMember {
	// 회원 공통
	private int memberNo;
	private String memberId;
	private String memberPhone;
	private String memberEmail;
	private Date enrollDate;
	private String memberStatus;
	private String memberGrade;
	
	//프리랜서
	private String memberName;
	private String minTime;
	private String maxTime;
	private String memberGender;
	private String minSalary;
	private String maxSalary;
	private String feild;
	private String work;
	private String experience;
	private String skil;
	
	//기업
	private String manager;
	private String companyName;
	private String companyNo;
	public adminMember() {
		// TODO Auto-generated constructor stub
	}
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
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMinTime() {
		return minTime;
	}
	public void setMinTime(String minTime) {
		this.minTime = minTime;
	}
	public String getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	public String getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getFeild() {
		return feild;
	}
	public void setFeild(String feild) {
		this.feild = feild;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSkil() {
		return skil;
	}
	public void setSkil(String skil) {
		this.skil = skil;
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
	@Override
	public String toString() {
		return "adminMember [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPhone=" + memberPhone
				+ ", memberEmail=" + memberEmail + ", enrollDate=" + enrollDate + ", memberStatus=" + memberStatus
				+ ", memberGrade=" + memberGrade + ", memberName=" + memberName + ", minTime=" + minTime + ", maxTime="
				+ maxTime + ", memberGender=" + memberGender + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary
				+ ", feild=" + feild + ", work=" + work + ", experience=" + experience + ", skil=" + skil + ", manager="
				+ manager + ", companyName=" + companyName + ", companyNo=" + companyNo + "]";
	}
	
	
	
	
}
