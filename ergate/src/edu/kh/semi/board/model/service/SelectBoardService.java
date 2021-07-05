package edu.kh.semi.board.model.service;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;


import edu.kh.semi.board.model.dao.SelectBoardDAO;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Pagination;

/**
 * @author 함나현 hammcoder@gamil.com
 *
 */
public class SelectBoardService {

	private SelectBoardDAO dao = new SelectBoardDAO();

	/** 게시판 페이징 처리 객체 생성용 Service
	 * @param cp
	 * @param boardStyle
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp, int boardStyle)throws Exception {

		Connection conn = getConnection();
		
		Map<String, Object> map = dao.getListCount(conn, cp, boardStyle);
		
		close(conn);
		
		int listCount = map.get("listCount") != null ? (int)map.get("listCount") : 0;
		
		return new Pagination(cp, listCount, boardStyle);
	}
	
	/** 카테고리별 게시판 페이징 처리 객체 생성용 Service
	 * @param cp
	 * @param boardStyle
	 * @param boardCategory
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp, int boardStyle, int boardCategory) throws Exception{
		Connection conn = getConnection();
		
		Map<String, Object> map = dao.getListCount(conn, cp, boardStyle, boardCategory);
		
		close(conn);
		
		int listCount = map.get("listCount") != null ? (int)map.get("listCount") : 0;
		String categoryNm = (String)map.get("categoryNm");
		
		return new Pagination(cp, listCount, boardStyle, boardCategory, categoryNm);
	}

	/** 게시글 목록 조회 Service
	 * @param pagination
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Pagination pagination)throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = null;
		
		
		if(pagination.getCategoryNm() == null) { // 카테고리가 선택되지 않았을 
			boardList = dao.selectBoardList(conn, pagination);
		}else { // 카테고리가 선택 되었을 때
			boardList = dao.selectCategoryList(conn, pagination);
		}
		
		close(conn);
		
		return boardList;
	}
	
	// 검색 조건에 따라 SQL에 사용할 조건식을 만들어 반환하는 메서드
	private String createCondition(String searchKey, String searchValue) {
		String condition = null;
		
		
		// codition 양 끝에는 띄어쓰기를 반드시 추가하여 
		// SQL구문이 연속되서 작성되는 것을 방지함
		switch(searchKey) {
		case "title" : 
			condition = " AND BOARD_TITLE LIKE '%" + searchValue + "%' ";
			break;
		case "content" : 
			condition = " AND BOARD_CONTENT LIKE '%" + searchValue + "%' ";
			break;
		case "titcont" : 
	         condition = " AND (BOARD_TITLE LIKE '%" + searchValue+ "%' " +
	        		 	 " OR BOARD_CONTENT LIKE '%" + searchValue+ "%') ";
			break;
		case "writer" : 
			condition = " AND MEMBER_NAME LIKE '%" + searchValue + "%' ";
			break;
		}
		return condition;
	}


	/** 게시판 페이징 처리 객체 생성용 Service (검색)
	 * @param cp
	 * @param boardStyle
	 * @param searchKey
	 * @param searchValue
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp, int boardStyle, String searchKey, String searchValue)throws Exception {

		Connection conn = getConnection();
		
		String condition = createCondition(searchKey, searchValue);
		
		Map<String, Object> map = dao.getListCount(conn, cp, boardStyle, condition);
		
		close(conn);
		
		int listCount = map.get("listCount") != null ? (int)map.get("listCount") : 0;
		
		return new Pagination(cp, listCount, boardStyle);
	}
	
	/** 게시글 목록 조회 Service (검색)
	 * @param pagination
	 * @param searchKey
	 * @param searchValue
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Pagination pagination, String searchKey, String searchValue)throws Exception {
		
		Connection conn = getConnection();
		
		String condition = createCondition(searchKey, searchValue);
		
		List<Board> boardList = null;
		
		
		if(pagination.getCategoryNm() == null) { // 카테고리가 선택되지 않았을 
			boardList = dao.selectBoardList(conn, pagination , condition);
		}else { // 카테고리가 선택 되었을 때
			boardList = dao.selectCategoryList(conn, pagination, condition);
		}
		
		close(conn);
		
		return boardList;
	}
	
	/** 카테고리별 게시판 페이징 처리 객체 생성용 Service (검색)
	 * @param cp
	 * @param boardStyle
	 * @param boardCategory
	 * @param boardCategory
	 * @param boardCategory
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp, int boardStyle, int boardCategory, String searchKey, String searchValue)throws Exception{
		Connection conn = getConnection();
		
		String condition = createCondition(searchKey, searchValue);
		
		Map<String, Object> map = dao.getListCount(conn, cp, boardStyle, boardCategory, condition);
		
		close(conn);
		
		int listCount = map.get("listCount") != null ? (int)map.get("listCount") : 0;
		String categoryNm = (String)map.get("categoryNm");
		
		return new Pagination(cp, listCount, boardStyle, boardCategory, categoryNm);
	}



	
}
