package edu.kh.semi.member.model.dao;

import static edu.kh.semi.common.JDBCTemplate.*;

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

import edu.kh.semi.member.model.vo.MemberBoard;
import edu.kh.semi.member.model.vo.MyPostPagination;

public class MyPostDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 sql 구문을 읽어와 저장할 Propertise 객체 참조 변수 선언
	private Properties prop = null;
	
	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML 파일을 읽어와 prop에 저장
	public MyPostDAO() {
		String filePath = MyPostDAO.class.getResource("/edu/kh/semi/sql/member/member-query.xml").getPath();
		
		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/** 전체 게시글 수 + 게시판 이름 조회 DAO
	 * @param conn
	 * @param cp
	 * @param memberNo 
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> getListCount(Connection conn, int cp, int memberNo)throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String sql = prop.getProperty("getListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				map.put("listCount",rs.getInt(1));
				map.put("boardName",rs.getString(2));
				
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
	 * @param memberNo 
	 * @return boardList
	 * @throws Exception
	 */
	public List<MemberBoard> boardList(Connection conn, MyPostPagination pagination, int memberNo)throws Exception {
		
		List<MemberBoard> boardList = new ArrayList<MemberBoard>();
		
		String sql = prop.getProperty("boardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			// 조회할 범위를 지정할 변수
			int startRow = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() - 1;
			
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberBoard board = new MemberBoard();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setCreateDate(rs.getTimestamp("CREATE_DT"));
				
				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return boardList;
	}

}










































