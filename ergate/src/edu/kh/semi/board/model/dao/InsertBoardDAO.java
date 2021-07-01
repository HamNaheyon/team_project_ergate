//package edu.kh.semi.board.model.dao;
//
//import static edu.kh.ergate.common.JDBCTemplate.*;
//
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//import edu.kh.semi.board.model.vo.Category;
//
///**
// * @author 함나현 hammcoder@gmail.com
// *
// */
//public class InsertBoardDAO {
//
//	private Statement stmt = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
//	
//	private Properties prop = null;
//	
//	public InsertBoardDAO() {
//
//		String filePath = InsertBoardDAO.class.getResource("/edu/kh/semi/sql/board/InsertBoard-query.xml").getPath();
//
//		try {
//			prop = new Properties();
//			prop.loadFromXML(new FileInputStream(filePath));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	
//	/** 카테고리 목록조회 Service
//	 * @param conn
//	 * @return category
//	 * @throws Exception
//	 */
//	public List<Category> selectCategoryList(Connection conn)throws Exception {
//
//		List<Category> category = new ArrayList<Category>();
//		
//		String sql = prop.getProperty("selectCategoryList");
//		
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			
//			while(rs.next()) {
//				Category ca = new Category();
//				ca.setCategoryCode(rs.getInt(1));
//				ca.setCategoryName(rs.getString(2));
//				
//				category.add(ca);
//			}
//		} finally {
//			close(rs);
//			close(stmt);
//		}
//		
//		return category;
//	}
//
//}
