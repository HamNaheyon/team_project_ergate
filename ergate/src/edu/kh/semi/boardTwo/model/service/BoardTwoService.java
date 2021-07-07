package edu.kh.semi.boardTwo.model.service;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.semi.boardTwo.model.dao.BoardTwoDAO;


public class BoardTwoService {
	
	private BoardTwoDAO dao = new BoardTwoDAO();

	public int deleteBoard(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}


}
