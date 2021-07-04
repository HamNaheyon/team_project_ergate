package edu.kh.ergate.admin.model.vo;

import java.sql.Timestamp;

public class adminBoard {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int readCount;
	private Timestamp createDT;
	private Timestamp modifyDT;
	private String boardStatus;
	private int memberNo;
	private int categoryCD;
	private int boardTypeNo;
	private String memberId;
	private int boardStyle;
	public adminBoard() {
		// TODO Auto-generated constructor stub
	}
	public adminBoard(int boardNo, String boardTitle, String boardContent, int readCount, Timestamp createDT,
			Timestamp modifyDT, String boardStatus, int memberNo, int categoryCD, int boardTypeNo, String memberId, int boardStyle) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.readCount = readCount;
		this.createDT = createDT;
		this.modifyDT = modifyDT;
		this.boardStatus = boardStatus;
		this.memberNo = memberNo;
		this.categoryCD = categoryCD;
		this.boardTypeNo = boardTypeNo;
		this.memberId = memberId;
		this.boardStyle = boardStyle;
	}
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
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Timestamp getCreateDT() {
		return createDT;
	}
	public void setCreateDT(Timestamp createDT) {
		this.createDT = createDT;
	}
	public Timestamp getModifyDT() {
		return modifyDT;
	}
	public void setModifyDT(Timestamp modifyDT) {
		this.modifyDT = modifyDT;
	}
	public String getBoardStatus() {
		return boardStatus;
	}
	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getCategoryCD() {
		return categoryCD;
	}
	public void setCategoryCD(int categoryCD) {
		this.categoryCD = categoryCD;
	}
	public int getBoardTypeNo() {
		return boardTypeNo;
	}
	public void setBoardTypeNo(int boardTypeNo) {
		this.boardTypeNo = boardTypeNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBoardStyle() {
		return boardStyle;
	}
	public void setBoardStyle(int boardStyle) {
		this.boardStyle = boardStyle;
	}
	@Override
	public String toString() {
		return "adminBoard [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", readCount=" + readCount + ", createDT=" + createDT + ", modifyDT=" + modifyDT + ", boardStatus="
				+ boardStatus + ", memberNo=" + memberNo + ", categoryCD=" + categoryCD + ", boardTypeNo=" + boardTypeNo
				+ ", memberId=" + memberId + ", boardStyle=" + boardStyle + "]";
	}
	
	
	
}
