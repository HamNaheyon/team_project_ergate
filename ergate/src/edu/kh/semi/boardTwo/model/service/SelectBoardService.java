package edu.kh.semi.boardTwo.model.service;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.semi.boardTwo.model.dao.SelectBoardDAO;
import edu.kh.semi.boardTwo.model.vo.Board;

public class SelectBoardService {

	private SelectBoardDAO dao = new SelectBoardDAO();
	
	/**프리랜서 게시글 상세 조회Service
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board freeSelectBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		Board board = dao.freeSelectBoard(conn, boardNo);
		
		if(board.getBoardTitle() != null) {
			int result = dao.increaseReadCount(conn, boardNo);
			
			if(result > 0) {
				commit(conn);
				board.setReadCount(board.getReadCount() + 1);
			}else {
				rollback(conn);
			}
		}
		return board;
	}

	public Board ComSelectBoard(int boardNo) throws Exception {
		Connection conn = getConnection();
		
		Board board = dao.ComSelectBoard(conn, boardNo);
		
		if(board.getBoardTitle() != null) {
			int result = dao.increaseReadCount(conn, boardNo);
			
			if(result > 0) {
				commit(conn);
				board.setReadCount(board.getReadCount() + 1);
			}else {
				rollback(conn);
			}
		}
		return board;
	}
}
