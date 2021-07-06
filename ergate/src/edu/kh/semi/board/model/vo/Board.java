package edu.kh.semi.board.model.vo;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 함나현 hammcoder@gamil.com
 *
 */
public class Board {
    
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String categoryName;
	private int readCount;
	private Timestamp createDt;
//	private Date createDt;
//	private Date modifyDt;
//	private char boardStatus;
//	private int memberNo;
//	private int categoryCd;
	private int boardType;
	/* private int boardStyle; */
	
	private List<String> filePath;
	private List<String> fileName;
	
	private int memberNo;
	private String memberId;
	private String memberGrade;
	
	public Board() {}

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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Timestamp getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Timestamp createDt) {
		this.createDt = createDt;
	}

	public List<String> getFilePath() {
		return filePath;
	}

	public void setFilePath(List<String> filePath) {
		this.filePath = filePath;
	}

	public List<String> getFileName() {
		return fileName;
	}

	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
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

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", categoryName=" + categoryName + ", readCount=" + readCount + ", createDt=" + createDt
				+ ", boardType=" + boardType + ", filePath=" + filePath + ", fileName=" + fileName + ", memberNo="
				+ memberNo + ", memberId=" + memberId + ", memberGrade=" + memberGrade + "]";
	}

	/*
	 * public int getBoardStyle() { return boardStyle; }
	 * 
	 * public void setBoardStyle(int boardStyle) { this.boardStyle = boardStyle; }
	 */

	
	
	
	
}
