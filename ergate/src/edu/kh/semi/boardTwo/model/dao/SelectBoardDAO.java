package edu.kh.semi.boardTwo.model.dao;


import static edu.kh.semi.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.boardTwo.model.vo.Board;

public class SelectBoardDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	
	public SelectBoardDAO() {
		
		String filePath = SelectBoardDAO.class.getResource("/edu/kh/semi/sql/detailBoard/detailBoard.xml").getPath();
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}	}
	
	/** 게시글 상세 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(Connection conn, int boardNo) throws Exception {
		
		Board board = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			board = new Board();
			board.setAtList(new ArrayList<Attachment>());
			boolean flag = true;
			while(rs.next()){
				if(flag){
	               board.setBoardNo(rs.getInt("BOARD_NO"));
	               board.setCategoryName(rs.getString("CATEGORY_NM"));
	               board.setBoardTitle(rs.getString("BOARD_TITLE"));
	               board.setMembeName(rs.getString("MEMBER_NAME"));
	               board.setReadCount(rs.getInt("READ_COUNT"));
	               board.setCreateDt(rs.getTimestamp("CREATE_DT"));
	               
	               board.setBoardContent(rs.getString("BOARD_CONTENT"));
	               board.setMemberNo(rs.getInt("MEMBER_NO"));
	               board.setModifyDate(rs.getTimestamp("MODIFY_DT"));
	               flag = false;
				}
				
				// 조회된 파일 관련 정보를 저장할 객체 선언(경로, 이름, 레벨)
				Attachment at = new Attachment();
				at.setFilePath(rs.getString("FILE_PATH"));
				at.setFileNM(rs.getString("FILE_NM"));
				at.setFileLevel(rs.getInt("FILE_LEVEL"));
				
				// 값 세팅이 완료된 Attachment 객체를 board의 atlist에 추가
				board.getAtList().add(at);
			}
		}finally {
			close(rs);
			close(pstmt);
		} 
		
		return board;
	}
	

	/** 게시글 조회수 증가 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseReadCount(Connection conn, int boardNo) throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
