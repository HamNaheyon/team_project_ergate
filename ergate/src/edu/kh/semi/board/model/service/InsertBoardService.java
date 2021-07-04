package edu.kh.semi.board.model.service;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.semi.board.model.dao.InsertBoardDAO;
import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Category;

/**
 * @author 함나현 hammcoder@gmail.com
 *
 */
public class InsertBoardService {

	private InsertBoardDAO dao = new InsertBoardDAO();
	/**
	 * @return
	 * @throws Exception
	 */
	public List<Category> selectCategoryList()throws Exception {

		Connection conn = getConnection();
		
		List<Category> category = dao.selectCategoryList(conn);
		
		close(conn);
		return category;
	}
	
	
	/** 게시글 삽입 Service
	 * @param board
	 * @param atList
	 * @param boardType
	 * @param writerType 
	 * @param writerType2 
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Board board, List<Attachment> atList, int categoryCode, int boardType, int writerType)throws Exception {
		Connection conn = getConnection();
		
		int boardNo = dao.nextBoardNo(conn);
		
		int result = 0;
		
		if(boardNo > 0) {
			board.setBoardNo(boardNo);
			
			String boardContent = board.getBoardContent();
			
			boardContent = replaceParameter(boardContent);
			boardContent = boardContent.replaceAll("\r\n", "<br>");
			
			board.setBoardContent(boardContent);
			
			result = dao.insertBoard(conn, board, categoryCode, boardType, writerType);
			
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
					System.out.println("게시글 삽입성공 : " + result);

					result = boardNo;
				}else {
					rollback(conn);
				}
			}else {
				rollback(conn);
			}
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
