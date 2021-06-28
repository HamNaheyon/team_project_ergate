package edu.kh.semi.member.model.vo;

import java.sql.Date;

public class FreMember {

	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String memberGrade;
	private String minTime;
	private String maxTime;
	private String minSalary;
	private String maxSalary;
	private String feild;
	private String work;
	private String experience;
	private String skil;
	private Date enrollDate;
	private String gender;
	private String juminNum;
	
	public FreMember() {}

	
	
	
	public FreMember(int memberNo, String memberId, String memberName, String memberPhone, String memberEmail,
			String memberGrade, String minTime, String maxTime, String minSalary, String maxSalary, String feild,
			String work, String experience, String skil, Date enrollDate, String gender, String juminNum) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberGrade = memberGrade;
		this.minTime = minTime;
		this.maxTime = maxTime;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.feild = feild;
		this.work = work;
		this.experience = experience;
		this.skil = skil;
		this.enrollDate = enrollDate;
		this.gender = gender;
		this.juminNum = juminNum;
	}

	

	/** 회원 가입 VO
	 * @param memberId
	 * @param memberPw
	 * @param memberName
	 * @param memberPhone
	 * @param memberEmail
	 * @param minTime
	 * @param maxTime
	 * @param minSalary
	 * @param maxSalary
	 * @param feild
	 * @param work
	 * @param experience
	 * @param skil
	 * @param gender
	 * @param juminNum
	 */
	public FreMember(String memberId, String memberPw, String memberName, String memberPhone, String memberEmail,
			String minTime, String maxTime, String minSalary, String maxSalary, String feild, String work,
			String experience, String skil, String gender, String juminNum) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.minTime = minTime;
		this.maxTime = maxTime;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.feild = feild;
		this.work = work;
		this.experience = experience;
		this.skil = skil;
		this.gender = gender;
		this.juminNum = juminNum;
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

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
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

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJuminNum() {
		return juminNum;
	}

	public void setJuminNum(String juminNum) {
		this.juminNum = juminNum;
	}

	@Override
	public String toString() {
		return "FreMember [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberGrade="
				+ memberGrade + ", minTime=" + minTime + ", maxTime=" + maxTime + ", minSalary=" + minSalary
				+ ", maxSalary=" + maxSalary + ", feild=" + feild + ", work=" + work + ", experience=" + experience
				+ ", skil=" + skil + ", enrollDate=" + enrollDate + ", gender=" + gender + ", juminNum=" + juminNum
				+ "]";
	}

	
}
