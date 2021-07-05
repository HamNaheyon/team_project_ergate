package edu.kh.semi.boardTwo.model.vo;

import java.sql.Timestamp;

public class Comments {
	private int commentsNo;
	private String commentsContent;
	private Timestamp commentsDt;
	private int boardNo;
	private int memberNo;
	private String memberId;
	
	public Comments() {	}
	
	public int getCommentsNo() {
		return commentsNo;
	}
	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}

	public String getCommentsContent() {
		return commentsContent;
	}
	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}

	public Timestamp getCommentsDt() {
		return commentsDt;
	}
	public void setCommentsDt(Timestamp commentsDt) {
		this.commentsDt = commentsDt;
	}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	@Override
	public String toString() {
		return "Comments [commentsNo=" + commentsNo + ", commentsContent=" + commentsContent + ", commentsDt="
				+ commentsDt + ", boardNo=" + boardNo + ", memberNo=" + memberNo + ", memberId=" + memberId + "]";
	}
	
}
