package edu.kh.semi.questions.model.vo;

import java.sql.Date;

public class Questions {
	
	private int questionsNo;
	private String questionsTitle;
	private String questionsContent;
	private Date questionsDate;
	private int memberNo;
	private String questionsStatus;
	
	private int comNo;
	private int freNo;
	
	
	public Questions() {}
	
	public Questions(int questionsNo, String questionsTitle, String questionsContent, Date questionsDate, int memberNo,
			String questionsStatus) {
		super();
		this.questionsNo = questionsNo;
		this.questionsTitle = questionsTitle;
		this.questionsContent = questionsContent;
		this.questionsDate = questionsDate;
		this.memberNo = memberNo;
		this.questionsStatus = questionsStatus;
	}



	public Questions(String questionsTitle, String questionsContent, int freNo) {
		super();
		this.questionsTitle = questionsTitle;
		this.questionsContent = questionsContent;
		this.freNo = freNo;
	}

	public Questions(int comNo, String questionsTitle, String questionsContent) {
		super();
		this.questionsTitle = questionsTitle;
		this.questionsContent = questionsContent;
		this.comNo = comNo;
	}

	public int getQuestionsNo() {
		return questionsNo;
	}
	public void setQuestionsNo(int questionsNo) {
		this.questionsNo = questionsNo;
	}

	public String getQuestionsTitle() {
		return questionsTitle;
	}
	public void setQuestionsTitle(String questionsTitle) {
		this.questionsTitle = questionsTitle;
	}

	public String getQuestionsContent() {
		return questionsContent;
	}
	public void setQuestionsContent(String questionsContent) {
		this.questionsContent = questionsContent;
	}

	public Date getQuestionsDate() {
		return questionsDate;
	}
	public void setQuestionsDate(Date questionsDate) {
		this.questionsDate = questionsDate;
	}

	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getQuestionsStatus() {
		return questionsStatus;
	}
	public void setQuestionsStatus(String questionsStatus) {
		this.questionsStatus = questionsStatus;
	}
	
	
	// -------------------------------------------------------------------------
	
	public int getComNo() {
		return comNo;
	}
	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public int getFreNo() {
		return freNo;
	}
	public void setFreNo(int freNo) {
		this.freNo = freNo;
	}


	@Override
	public String toString() {
		return "Questions [questionsNo=" + questionsNo + ", questionsTitle=" + questionsTitle + ", questionsContent="
				+ questionsContent + ", questionsDate=" + questionsDate + ", memberNo=" + memberNo
				+ ", questionsStatus=" + questionsStatus + "]";
	}
	

}
