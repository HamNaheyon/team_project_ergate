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
	public Map<String, Object> getListCount(Connection conn, int cp, int boardStyle) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = prop.getProperty("getListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardStyle);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("listCount", rs.getInt(1));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return map;
	}
	

	/** 카테고리별 게시글 전체 게시글 수 + 게시판 이름 조회 DAO
	 * @param conn
	 * @param cp
	 * @param boardType
	 * @param boardCategory
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> getListCount(Connection conn, int cp, int boardStyle, int boardCategory) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = prop.getProperty("selectCategory");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardCategory);
			pstmt.setInt(2, boardStyle);
			pstmt.setInt(3, boardCategory);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("listCount", rs.getInt(1));
				map.put("categoryNm", rs.getString(2));
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
			pstmt.setInt(1,  pagination.getBoardStyle());
			int startRow = (pagination.getCurrentPage() -1 ) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() -1;
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setCategoryName(rs.getString("CATEGORY_NM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setCreateDt(rs.getTimestamp("CREATE_DT"));
				board.setBoardType(rs.getInt("BOARD_TYPE_NO"));
				
				List<String> filePath = new ArrayList<String>();
				List<String> fileName = new ArrayList<String>();
				
				filePath.add(rs.getString("FILE_PATH"));
				fileName.add(rs.getString("FILE_NM"));
				
				board.setFilePath(filePath);
				board.setFileName(fileName);
				
				// System.out.println(filePath);
				
				boardList.add(board);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	
	/** 카테고리별 게시글 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectCategoryList(Connection conn, Pagination pagination) throws Exception {
		List<Board> boardList = new ArrayList<Board>();
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  pagination.getBoardStyle());
			pstmt.setInt(2,  pagination.getCategoryCd());
			int startRow = (pagination.getCurrentPage() -1 ) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() -1;
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setCategoryName(rs.getString("CATEGORY_NM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setCreateDt(rs.getTimestamp("CREATE_DT"));
				board.setBoardType(rs.getInt("BOARD_TYPE_NO"));

				List<String> filePath = new ArrayList<String>();
				List<String> fileName = new ArrayList<String>();
				
				filePath.add(rs.getString("FILE_PATH"));
				fileName.add(rs.getString("FILE_NM"));
				
				board.setFilePath(filePath);
				board.setFileName(fileName);
				
				// System.out.println(filePath);
				
				boardList.add(board);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	
	/** 전체 게시글 수 + 게시판 이름 조회 DAO (검색)
	 * @param conn
	 * @param cp
	 * @param boardType
	 * @param searchKey
	 * @param searchValue
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> getListCount(Connection conn, int cp, int boardStyle, String condition) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		String sql = prop.getProperty("getSearchCount") + condition ;
		
		// System.out.println(sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardStyle);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("listCount", rs.getInt(1));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return map;
	}

	/** 게시글 목록 조회 DAO (검색)
	 * @param conn
	 * @param pagination
	 * @param searchKey
	 * @param searchValue
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination, String condition)throws Exception {
		List<Board> boardList = new ArrayList<Board>();
		
		String sql = prop.getProperty("searchBoardList1") + condition + prop.getProperty("searchBoardList2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  pagination.getBoardStyle());
			int startRow = (pagination.getCurrentPage() -1 ) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() -1;
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setCategoryName(rs.getString("CATEGORY_NM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setCreateDt(rs.getTimestamp("CREATE_DT"));
				board.setBoardType(rs.getInt("BOARD_TYPE_NO"));
				
				

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
	
	/** 카테고리별 게시글 전체 게시글 수 + 게시판 이름 조회 DAO (검색)
	 * @param conn
	 * @param cp
	 * @param boardType
	 * @param boardCategory
	 * @param condition
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> getListCount(Connection conn, int cp, int boardStyle, int boardCategory, String condition) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = prop.getProperty("getcategorySearchCount") + condition + ")";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardCategory);
			pstmt.setInt(2, boardStyle);
			pstmt.setInt(3, boardCategory);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("listCount", rs.getInt(1));
				map.put("categoryNm", rs.getString(2));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return map;
	}	

	
	/** 카테고리별 게시글 목록 조회 DAO (검색)
	 * @param conn
	 * @param pagination
	 * @param condition
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectCategoryList(Connection conn, Pagination pagination, String condition) throws Exception {
		List<Board> boardList = new ArrayList<Board>();
		
		String sql = prop.getProperty("searchCategoryList1") + condition + prop.getProperty("searchCategoryList2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  pagination.getBoardStyle());
			pstmt.setInt(2,  pagination.getCategoryCd());
			int startRow = (pagination.getCurrentPage() -1 ) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() -1;
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setCategoryName(rs.getString("CATEGORY_NM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setCreateDt(rs.getTimestamp("CREATE_DT"));
				board.setBoardType(rs.getInt("BOARD_TYPE_NO"));

				List<String> filePath = new ArrayList<String>();
				List<String> fileName = new ArrayList<String>();
				
				filePath.add(rs.getString("FILE_PATH"));
				fileName.add(rs.getString("FILE_NM"));
				
				board.setFilePath(filePath);
				board.setFileName(fileName);
				
				// System.out.println(filePath);
				
				boardList.add(board);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	
	
	
}
