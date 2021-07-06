package edu.kh.semi.boardTwo.model.vo;

import java.sql.Timestamp;
import java.util.List;

public class Board {
    
	private int boardNo;
	private String boardTitle;
	
	private String memberGrade;
	
	private String categoryName;
	private int readCount;
	private String memberId;
	
	private Timestamp createDt;	
	
	private List<String> filePath;
	private List<String> fileName;
	private List<String> fileLevel;
	
	private String boardContent;   		// 글 내용
	private int memberNo; 		   		// 작성 회원 번호
	private Timestamp modifyDate;  		// 마지막 수정일
	private List<Attachment> atList;
	private String memberEmail;
	
	//----------------------------------------------------------- 포트폴리오
	private String minTime; // 최소 연락 가능 시간
	private String maxTime; // 최대 연락 가능 시간
	private String minSalary; // 최소 희망 급여 
	private String maxSalary; // 최대 희망 급여
	private String work;  // 근무 형태
	private String experience; // 경험
	private String skil; // 스킬
	
	//---------------------------------------------------------------- 제안서
	
	private String manager;
	private String companyName;
	
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
	
	
	
	public int getMemberNo() {
		return memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	
	/*public List<Attachment> getAtList() {
		return atList;
	}

	public void setAtList(List<Attachment> atList) {
		this.atList = atList;
	}*/
	
	// ----------------------------------------------

	public String getMinTime() {
		return minTime;
	}

	public void setMinTime(String minTime) {
		this.minTime = minTime;
	}

	public String getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkil() {
		return skil;
	}

	public void setSkil(String skil) {
		this.skil = skil;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	//-------------------------------------------------------------------

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	public List<String> getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(List<String> fileLevel) {
		this.fileLevel = fileLevel;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", memberGrade=" + memberGrade
				+ ", categoryName=" + categoryName + ", readCount=" + readCount + ", memberId=" + memberId
				+ ", createDt=" + createDt + ", filePath=" + filePath + ", fileName=" + fileName + ", fileLevel="
				+ fileLevel + ", boardContent=" + boardContent + ", memberNo=" + memberNo + ", modifyDate=" + modifyDate
				+ ", atList=" + atList + ", memberEmail=" + memberEmail + ", minTime=" + minTime + ", maxTime="
				+ maxTime + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + ", work=" + work + ", experience="
				+ experience + ", skil=" + skil + ", manager=" + manager + ", companyName=" + companyName + "]";
	}

}
