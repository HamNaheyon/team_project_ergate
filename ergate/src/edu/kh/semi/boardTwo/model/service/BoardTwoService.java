package edu.kh.semi.boardTwo.model.service;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.boardTwo.model.dao.BoardTwoDAO;
import edu.kh.semi.boardTwo.model.vo.Board;
import edu.kh.semi.boardTwo.model.vo.Category;


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

	public int updateBoard1(int boardNo, Board board, List<Attachment> atList, int categoryCode, int boardStyle, int writerType) throws Exception {
		Connection conn = getConnection();
	
	
	int result = 0;
	
		board.setBoardNo(boardNo);
		
		String boardContent = board.getBoardContent();
		
		boardContent = replaceParameter(boardContent);
		boardContent = boardContent.replaceAll("\r\n", "<br>");
		
		board.setBoardContent(boardContent);
		
		result = dao.updateBoard1(conn, board, categoryCode, boardStyle, writerType,boardNo);
		
		if(result > 0) {
			
			for(Attachment at : atList) {
				at.setBoardNo(boardNo);
				result = dao.insertAttachment(conn, at);
				
				if(result == 0) {
					rollback(conn);
					break;
				}
			}
			if(result > 0) {
				commit(conn);
				System.out.println("게시글 수정 : " + result);

				result = boardNo;
			}else {
				rollback(conn);
			}
		}else {
			rollback(conn);
		}
	
	
		close(conn);
		
		return result;
	}
	private String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		return result;
	}

	

	

}
