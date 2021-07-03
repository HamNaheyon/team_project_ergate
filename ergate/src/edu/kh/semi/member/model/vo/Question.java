package edu.kh.semi.member.model.vo;

import java.sql.Timestamp;

public class Question {
	
	private int questionNo;
	private String questionTitle;
	private Timestamp questionDate;
	private int memberNo;
	private String questionStatus;
	
	public Question() {}

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

	public Timestamp getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Timestamp questionDate) {
		this.questionDate = questionDate;
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
		return "Question [questionNo=" + questionNo + ", questionTitle=" + questionTitle + ", questionDate="
				+ questionDate + ", memberNo=" + memberNo + ", questionStatus=" + questionStatus + "]";
	}

	
}
