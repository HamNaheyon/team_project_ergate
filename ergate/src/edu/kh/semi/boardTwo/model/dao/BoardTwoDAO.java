package edu.kh.semi.boardTwo.model.dao;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

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

}
