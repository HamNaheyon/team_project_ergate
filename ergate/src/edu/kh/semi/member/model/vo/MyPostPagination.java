package edu.kh.semi.member.model.vo;

public class MyPostPagination {

	private int currentPage;
	private int listCount;
	
	private int limit = 10;
	private int pageSize = 10;
	
	private int maxPage;
	private int startPage;
	private int endPage;
	
	private int prevPage;
	private int nextPage;
	
	private String boardName;
	private int memberNo;
	
	/** pagination
	 * @param currentPage
	 * @param listCount
	 * @param boardName
	 */
	public MyPostPagination(int currentPage, int listCount, String boardName) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.boardName = boardName;
		makePagination();
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getListCount() {
		return listCount;
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;
		
		makePagination();
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
		
		makePagination();
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
		makePagination();
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getPrevPage() {
		return prevPage;
	}


	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}


	public int getNextPage() {
		return nextPage;
	}


	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	

	
	public String getBoardName() {
		return boardName;
	}


	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	

		public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	
	

		@Override
	public String toString() {
		return "MyPostPagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", boardName=" + boardName
				+ ", memberNo=" + memberNo + "]";
	}


		// 페이징 처리에 필요한 값을 계산하는 메소드
		private void makePagination() {
			
			// maxPage == 마지막 페이지이 == 총 페이지 수 
			
			maxPage = (int)Math.ceil( (double)listCount / limit );
			
			// startPage == 페이지 번호 목록 시작 번호
			// ex) 1, 11, 21, 31 ....
			startPage = (currentPage -1 ) / pageSize * pageSize + 1;
			
			// endpage == 페이지 번호 목록 끝 번호
			// ex) 10, 20, 30, 40 ....
			endPage = startPage + pageSize - 1;
			
			// ** 보여지는 페이지 번호 목록의 끝 번호가 maxPage보다 클 경우
			
			// 현재 페이지 : 52
			// 페이지 번호 목록 : 51 52 53 54 55 56 57 58 59 60
			// 끝 페이지 55
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			// 이전, 다음 페이지 번호 목록으로 이동
			if(currentPage < 10) 	prevPage = 1;
			else					prevPage = (currentPage - 1) / pageSize * pageSize;
			
			nextPage = (currentPage + pageSize - 1) / pageSize * pageSize + 1;
			
			if(nextPage > maxPage) {
				nextPage = maxPage;
			}
			
		}
	
	
	
}
