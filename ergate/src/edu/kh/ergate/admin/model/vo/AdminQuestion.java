package edu.kh.ergate.admin.model.vo;

import java.sql.Date;

public class AdminQuestion {

	private int questionNo;
	private String questionTitle;
	private String questionContent;
	private String memberId;
	private Date questionDate;
	private String memberEmail;
	private String memberGrade;
	private int memberNo;
	private String questionStatus;
	public AdminQuestion() {
		// TODO Auto-generated constructor stub
	}
	public AdminQuestion(int questionNo, String questionTitle, String questionContent, String memberId,
			Date questionDate, String memberEmail, String memberGrade, int memberNo, String questionStatus) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.memberId = memberId;
		this.questionDate = questionDate;
		this.memberEmail = memberEmail;
		this.memberGrade = memberGrade;
		this.memberNo = memberNo;
		this.questionStatus = questionStatus;
	}
	
	public AdminQuestion(int questionNo, String questionTitle, String questionContent, String memberId,
			Date questionDate, String memberEmail, String memberGrade, String questionStatus) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.memberId = memberId;
		this.questionDate = questionDate;
		this.memberEmail = memberEmail;
		this.memberGrade = memberGrade;
		this.questionStatus = questionStatus;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getQuestionDate() {
		return questionDate;
	}
	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
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
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getQuestionStatus() {
		return questionStatus;
	}
	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}
	@Override
	public String toString() {
		return "AdminQuestion [questionNo=" + questionNo + ", questionTitle=" + questionTitle + ", questionContent="
				+ questionContent + ", memberId=" + memberId + ", questionDate=" + questionDate + ", memberEmail="
				+ memberEmail + ", memberGrade=" + memberGrade + ", memberNo=" + memberNo + ", questionStatus="
				+ questionStatus + "]";
	}

	
}
