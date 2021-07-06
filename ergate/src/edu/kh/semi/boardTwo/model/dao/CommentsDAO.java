package edu.kh.semi.boardTwo.model.dao;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.semi.boardTwo.model.vo.Comments;

public class CommentsDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public CommentsDAO() {
	
		String filePath = CommentsDAO.class.getResource("/edu/kh/semi/sql/detailBoard/comments-query.xml").getPath();
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/** 댓글 조회
	 * @param conn
	 * @param boardNo
	 * @return list
	 * @throws Exception
	 */
	public List<Comments> selectList(Connection conn, int boardNo) throws Exception {
		
		List<Comments> list = new ArrayList<Comments>();
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comments comments = new Comments();
				
				comments.setCommentsNo(rs.getInt("COMMENT_NO"));
				comments.setCommentsContent(rs.getString("COMMENT_CONTENT"));
				comments.setCommentsDt(rs.getTimestamp("COMMENT_DT"));
				comments.setBoardNo(rs.getInt("BOARD_NO"));
				comments.setMemberNo(rs.getInt("MEMBER_NO"));
				comments.setMemberId(rs.getString("MEMBER_ID"));
				
				list.add(comments);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	/** 댓글 작성
	 * @param conn
	 * @param comments
	 * @return result
	 * @throws Exception
	 */
	public int insertComments(Connection conn, Comments comments) throws Exception {
		int result = 0;
		
		String sql = prop.getProperty("insertComments");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, comments.getCommentsContent());
			pstmt.setInt(3, comments.getMemberNo());
			pstmt.setInt(2, comments.getBoardNo());
			
			result = pstmt.executeUpdate();
			
			System.out.println("result : "+result);
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 댓글 삭제
	 * @param conn
	 * @param comments
	 * @return result
	 * @throws Exception
	 */
	public int updateComments(Connection conn, Comments comments) throws Exception {
		int result = 0;
		
		String sql = prop.getProperty("updateComments");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, comments.getCommentsContent());
			pstmt.setInt(2, comments.getCommentsNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 댓글 삭제
	 * @param conn
	 * @param commentsNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteComments(Connection conn, int commentsNo) throws Exception {
		int result = 0;
		
		String sql = prop.getProperty("deleteComments");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentsNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	

}
