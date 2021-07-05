package edu.kh.semi.board.model.dao;

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
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Category;

/**
 * @author 함나현 hammcoder@gmail.com
 *
 */
public class InsertBoardDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public InsertBoardDAO() {

		String filePath = InsertBoardDAO.class.getResource("/edu/kh/semi/sql/board/InsertBoard-query.xml").getPath();

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** 카테고리 목록조회 Service
	 * @param conn
	 * @return category
	 * @throws Exception
	 */
	public List<Category> selectCategoryList(Connection conn)throws Exception {

		List<Category> category = new ArrayList<Category>();
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Category ca = new Category();
				ca.setCategoryCode(rs.getInt(1));
				ca.setCategoryName(rs.getString(2));
				
				category.add(ca);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		return category;
	}

	/** 다음 게시글 번호 조회 DAO 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn)throws Exception {
		
		int boardNo = 0;
		
		String sql = prop.getProperty("nextBoardNo");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				boardNo = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return boardNo;
	}

	/** 게시글 삽입 DAO
	 * @param conn
	 * @param board
	 * @param boardStyle
	 * @param writerType 
	 * @param writerType2 
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, Board board, int categoryCode, int boardStyle, int writerType)throws Exception {

		int result = 0;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board.getBoardNo());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, board.getMemberNo());
			pstmt.setInt(5, categoryCode);
			pstmt.setInt(6, writerType);
			pstmt.setInt(7, boardStyle);
			
			
			result = pstmt.executeUpdate();
	
			System.out.println("게시글 삽입 DAO : "+result);
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
			
			pstmt.setString(1, at.getFilePath());
			pstmt.setString(2, at.getFileNM());
			pstmt.setInt(3, at.getFileLevel());
			pstmt.setInt(4, at.getBoardNo());
			
			result = pstmt.executeUpdate();
			System.out.println("첨부파일 삽입 : " + result);
			
		} finally {
			close(pstmt);
			
		}
		return result;
	}

}
