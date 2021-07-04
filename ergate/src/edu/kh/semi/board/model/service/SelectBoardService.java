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


	
}
