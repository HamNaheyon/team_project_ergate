package edu.kh.semi.board.model.vo;

public class Attachment {

	private int fileNo;
	private String filePath;
	private String fileNM;
	private int fileLevel;
	private int boardNo;
	
	public Attachment() {}

	public Attachment(int fileNo, String filePath, String fileNM, int fileLevel, int boardNo) {
		super();
		this.fileNo = fileNo;
		this.filePath = filePath;
		this.fileNM = fileNM;
		this.fileLevel = fileLevel;
		this.boardNo = boardNo;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileNM() {
		return fileNM;
	}

	public void setFileNM(String fileNM) {
		this.fileNM = fileNM;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", filePath=" + filePath + ", fileNM=" + fileNM + ", fileLevel="
				+ fileLevel + ", boardNo=" + boardNo + "]";
	}
	
	
}

