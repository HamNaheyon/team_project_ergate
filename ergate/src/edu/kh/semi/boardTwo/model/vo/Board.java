package edu.kh.semi.boardTwo.model.vo;

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
//	private int boardTypeNo;
	
	private List<String> filePath;
	private List<String> fileName;
	
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

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", categoryName=" + categoryName + ", readCount=" + readCount + ", createDt=" + createDt
				+ ", filePath=" + filePath + ", fileName=" + fileName + "]";
	}


	
}
