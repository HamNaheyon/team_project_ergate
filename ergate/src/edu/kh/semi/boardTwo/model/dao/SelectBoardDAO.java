//package edu.kh.semi.boardTwo.model.dao;
//
//
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Properties;
//
//import edu.kh.semi.boardTwo.model.vo.Board;
//
//public class SelectBoardDAO {
//	
//	private Statement stmt = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
//	private Properties prop = null;
//	
//	public SelectBoardDAO() {
//		
//		String filePath = SelectBoardDAO.class.getResource("/edu/kh/semi/sql/board/selectboard-query.xml").getPath();
//		
//		try {
//			prop = new Properties();
//			
//			prop.loadFromXML(new FileInputStream(filePath));
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}	}
//	
//	/** 게시글 상세 조회 DAO
//	 * @param conn
//	 * @param boardNo
//	 * @return board
//	 * @throws Exception
//	 */
//	public Board selectBoard(Connection conn, int boardNo) {
//		
//		Board board = null;
//		
//		String sql = prop.getProperty("selectBoard");
//		
//		return null;
//	}
//
//}
