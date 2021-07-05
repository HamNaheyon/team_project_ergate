package edu.kh.semi.boardTwo.model.service;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.semi.boardTwo.model.dao.CommentsDAO;
import edu.kh.semi.boardTwo.model.vo.Comments;

public class CommentsService {
	
	private CommentsDAO dao = new CommentsDAO();

	
	/** 댓글 목록 조회
	 * @param boardNo
	 * @return list
	 * @throws Exception
	 */
	public List<Comments> selectList(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Comments> list = dao.selectList(conn, boardNo);
		
		close(conn); 
		
		return list;
	}

	/** 댓글 삽입
	 * @param comments
	 * @return result
	 * @throws Exception
	 */
	public int insertComments(Comments comments) throws Exception{
		Connection conn = getConnection();
		
		comments.setCommentsContent(replaceParameter(comments.getCommentsContent()));
		comments.setCommentsContent(comments.getCommentsContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		
		int result = dao.insertComments(conn, comments);
		
		if(result >0) commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	/** 댓글 수정
	 * @param comments
	 * @return result
	 * @throws Exception
	 */
	public int updateComments(Comments comments) throws Exception {
		
		Connection conn = getConnection();
		
		comments.setCommentsContent(replaceParameter(comments.getCommentsContent()));
		comments.setCommentsContent(comments.getCommentsContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		
		int result = dao.updateComments(conn, comments);
		
		if(result >0) commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 댓글 삭제
	 * @param commentsNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteComments(int commentsNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteComments(conn, commentsNo);
		
		if(result >0) commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	private String replaceParameter(String param) {
		Connection conn = getConnection();
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt");
			result = result.replaceAll(">", "&gt;");
			result = result.replace("\"", "&quot");
		}
		close(conn);
		return result;
	}

}
