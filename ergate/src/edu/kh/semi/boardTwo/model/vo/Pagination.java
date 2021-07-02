package edu.kh.semi.boardTwo.model.vo;

/**
 * @author 함나현 hammcoder@gamil.com
 *
 */
public class Pagination {

	private int currentPage;
	private int listCount;
	
	private int limit = 15;
	private int pageSize = 10;
	
	private int maxPage;
	private int startPage;
	private int endPage;
	
	private int prevPage;
	private int nextPage;
	
	private int boardType;
	private String boardName;
	
	
	public Pagination(int currentPage, int listCount, int boardType, String boardName) {
		
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.boardType = boardType;
		this.boardName = boardName;
		
		makePagination();
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;

		makePagination();
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


	public int getBoardType() {
		return boardType;
	}


	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}


	public String getBoardName() {
		return boardName;
	}


	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}


	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", boardType=" + boardType
				+ ", boardName=" + boardName + "]";
	}
	
	
	private void makePagination() {
		
		maxPage = (int)Math.ceil((double)listCount/limit);
		
		startPage = (currentPage - 1) / pageSize * pageSize + 1;
		
		endPage = startPage + pageSize - 1;
		
		if(endPage > maxPage) {
			endPage=maxPage;
		}
		
		if(currentPage < 10) prevPage = 1;
		else				 prevPage = (currentPage -1) / pageSize * pageSize;
		
		nextPage = (currentPage + pageSize -1)/ pageSize * pageSize +1;
		
		if(nextPage > maxPage) {
			nextPage = maxPage;
		}
	}
	
	
	
}
