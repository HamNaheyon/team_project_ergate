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
	 * @param boardType
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp, int boardType)throws Exception {

		Connection conn = getConnection();
		
		Map<String, Object> map = dao.getListCount(conn, cp, boardType);
		
		close(conn);
		
		int listCount = map.get("listCount") != null ? (int)map.get("listCount") : 0;
		String boardName = (String)map.get("boardName");
		
		return new Pagination(cp, listCount, boardType, boardName);
	}

	/** 게시글 목록 조회 Service
	 * @param pagination
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Pagination pagination)throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectBoardList(conn, pagination);
		
		close(conn);
		
		return boardList;
	}

	/** 게시글 상세 조회Service
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo)throws Exception {

		Connection conn = getConnection();
		
		Board board = dao.selectBoard(conn, boardNo);
		
		if(board.getBoardTitle() != null) {
			int result = dao.increaseReadCount(conn, boardNo);
			
			if(result > 0) {
				commit(conn);
				
				board.setReadCount(board.getReadCount() + 1);
			}
		}
		
		return board;
	}
	
}
