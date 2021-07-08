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

import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.boardTwo.model.vo.Board;
import edu.kh.semi.boardTwo.model.vo.Category;

public class BoardTwoDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public BoardTwoDAO() {
		String filePath = CommentsDAO.class.getResource("/edu/kh/semi/sql/detailBoard/detailBoard2.xml").getPath();
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		int result = 0;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard1(Connection conn, Board board, int categoryCode, int boardStyle, int writerType, int boardNo) throws Exception {
		int result = 0;
		
		String sql = prop.getProperty("updateBoard1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, categoryCode);
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, boardNo);
			
			result = pstmt.executeUpdate();
	
			System.out.println("게시글 수정 DAO : "+result);
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 첨부파일(이미지) 정보삽입 DAO
	 * @param conn
	 * @param at
	 * @return
	 * @throws Exception
	 */
	public int insertAttachment(Connection conn, Attachment at)throws Exception {

		int result = 0;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(at);
			pstmt.setString(1, at.getFileNM());
			System.out.println(at.getFileNM());
			pstmt.setInt(2, at.getFileLevel());
			System.out.println(at.getFileLevel());
			pstmt.setInt(3, at.getBoardNo());
			System.out.println(at.getFileNo());
			pstmt.setInt(4, at.getFileLevel());
			System.out.println(at.getFileLevel());
			
			result = pstmt.executeUpdate();
			System.out.println("첨부파일 삽입 : " + result);
			
		} finally {
			close(pstmt);
			
		}
		return result;
	}

	

}
