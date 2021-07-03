package edu.kh.semi.boardTwo.model.vo;

import java.sql.Timestamp;
import java.util.List;

import edu.kh.semi.board.model.vo.Attachment;

public class Board {
    
	private int boardNo;
	private String boardTitle;
	private String categoryName;
	private int readCount;
	private String membeName;
	
	private Timestamp createDt;	
	private List<String> filePath;
	private List<String> fileName;
	private String boardContent;   		// 글 내용
	private int memberNo; 		   		// 작성 회원 번호
	private Timestamp modifyDate;  		// 마지막 수정일
	private List<Attachment> atList;
	
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
	
// 	----------------------------------------------------------------
	
	
	public String getMembeName() {
		return membeName;
	}
	
	public void setMembeName(String membeName) {
		this.membeName = membeName;
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public List<Attachment> getAtList() {
		return atList;
	}

	public void setAtList(List<Attachment> atList) {
		this.atList = atList;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", categoryName=" + categoryName
				+ ", readCount=" + readCount + ", membeName=" + membeName + ", createDt=" + createDt + ", filePath="
				+ filePath + ", fileName=" + fileName + ", boardContent=" + boardContent + ", memberNo=" + memberNo
				+ ", modifyDate=" + modifyDate + ", atList=" + atList + "]";
	}

	
}
