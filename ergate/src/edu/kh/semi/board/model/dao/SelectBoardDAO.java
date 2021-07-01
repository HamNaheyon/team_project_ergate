package edu.kh.semi.board.model.dao;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Pagination;

/**
 * @author 함나현 hammcoder@gmail.com
 *
 */
public class SelectBoardDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	

	public SelectBoardDAO() {

		String filePath = SelectBoardDAO.class.getResource("/edu/kh/semi/sql/board/selectboard-query.xml").getPath();
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	/** 전체 게시글 수 + 게시판 이름 조회 DAO
	 * @param conn
	 * @param cp
	 * @param boardType
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> getListCount(Connection conn, int cp, int boardType)throws Exception{

		Map<String, Object> map = new HashMap<String, Object>();
		
		String sql = prop.getProperty("getListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardType);
			pstmt.setInt(2, boardType);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				map.put("listCount", rs.getInt(1));
				map.put("boardName", rs.getString(2));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
				
		return map;
	}


	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination)throws Exception {

		List<Board> boardList = new ArrayList<Board>();
		
		String sql = prop.getProperty("selectBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,  pagination.getBoardType());
			
			int startRow = (pagination.getCurrentPage() -1 ) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() -1;
			
			pstmt.setInt(2,  startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setCategoryName(rs.getString("CATEGORY_NM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setCreateDt(rs.getTimestamp("CREATE_DT"));
				
				List<String> filePath = new ArrayList<String>();
				List<String> fileName = new ArrayList<String>();
				
				filePath.add(rs.getString("FILE_PATH"));
				fileName.add(rs.getString("FILE_NM"));
				
				board.setFilePath(filePath);
				board.setFileName(fileName);
				
				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}


	/** 게시글 상세 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(Connection conn, int boardNo)throws Exception {

		Board board = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			board = new Board();
			
//			board.setAtList(new ArrayList<Attachment>());
			
			boolean flag = true;
			
			while(rs.next()) {
				
				if(flag) {
					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setCategoryName(rs.getString("CATEGORY_NM"));
					board.setBoardTitle(rs.getString("BOARD_TITLE"));
					board.setReadCount(rs.getInt("READ_COUNT"));
					board.setCreateDt(rs.getTimestamp("CREATE_DT"));
					
					board.setBoardContent(rs.getString("BOARD_CONTENT"));
//					board.setMemberNo(rs.getInt("MEMBER_NO"));
//					board.setModifyDate(rs.getTimestamp("MODIFY_DT"));
					
					flag = false;
				}
				Attachment at = new Attachment();
				
				at.setFilePath(rs.getString("FILE_PATH"));
				at.setFileNM(rs.getString("FILE_NM"));
//				at.setFileLevel(rs.getString("FILE_LEVEL"));
//				
//				board.getAtList().add(at);
				
				
			}
			
			
		} finally {

		}
		return null;
	}


	/** 조회 수 증가 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseReadCount(Connection conn, int boardNo)throws Exception {
		
		int result = 0;
		
		try {
		
			String sql = prop.getProperty("increaseReadCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
					
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
}
