package edu.kh.semi.member.model.vo;

import java.sql.Timestamp;

public class MemberBoard {

	private int boardNo;
	private String boardTitle;
	private String memberId;
	private int readCount;
	private Timestamp createDate;
	
	public MemberBoard() {}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "MemberBoard [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", memberId=" + memberId
				+ ", readCount=" + readCount + ", createDate=" + createDate + "]";
	}
	
	
	
}
