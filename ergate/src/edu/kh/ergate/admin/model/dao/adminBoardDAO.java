package edu.kh.ergate.admin.model.dao;
import java.io.FileInputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import edu.kh.ergate.admin.model.vo.Pagination;
import edu.kh.ergate.admin.model.vo.adminBoard;
import edu.kh.ergate.admin.model.vo.adminMember;

import static edu.kh.ergate.common.JDBCTemplate.*;

public class adminBoardDAO {
	private Statement stmt=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private Properties prop =null;
	
	public adminBoardDAO() {
	prop = new Properties();
	try {
		String filePath = adminBoardDAO.class.getResource("/edu/kh/ergate/sql/adminBoard/board-query.xml").getPath();
		
		prop.loadFromXML(new FileInputStream(filePath));
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

	/**기업게시판 전체조회
	 * @param conn
	 * @return adminBoardList
	 * @throws Exception
	 */
	public List<adminBoard> selectComBoardList(Connection conn) throws Exception{
		// TODO Auto-generated method stub
		List<adminBoard> adminBoardList = null;
		String sql = prop.getProperty("selectComBoardList");
		try {
			stmt = conn.createStatement();
			adminBoardList = new ArrayList<adminBoard>();
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				/*
				 * StringBuffer output = new StringBuffer(); Reader input =
				 * rs.getCharacterStream("BOARD_CONTENT"); char[] buffer = new char[1024]; int
				 * byteRead = 0; while((byteRead=input.read(buffer,0,1024))!=-1) {
				 * output.append(buffer,0,byteRead); }
				 */
				int boardNo =rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				int readCount = rs.getInt("READ_COUNT");
				Timestamp createDT = rs.getTimestamp("CREATE_DT");
				Timestamp modifyDT = rs.getTimestamp("MODIFY_DT");
				String boardStatus = rs.getString("BOARD_STATUS");
				int memberNo=rs.getInt("MEMBER_NO");
				int categoryCD = rs.getInt("CATEGORY_CD");
				int boardTypeNo= rs.getInt("BOARD_TYPE_NO");
				String memberId = rs.getString("MEMBER_ID");
				
				adminBoard board = new adminBoard(boardNo, boardTitle, boardContent, readCount, createDT, modifyDT, boardStatus, memberNo, categoryCD, boardTypeNo, memberId);
				adminBoardList.add(board);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return adminBoardList;
	}

	/**기업 게시판 페이징 처리
	 * @param conn
	 * @param cp
	 * @param boardTypeNo
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getPagination(Connection conn, int cp, int boardTypeNo)throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = prop.getProperty("getListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardTypeNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("listCount",rs.getInt(1));
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return map;
	}

	/**기업 게시글 목록 전체 조회
	 * @param conn
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<adminBoard> selectBoardList(Connection conn, Pagination pagination) throws Exception{
		// TODO Auto-generated method stub
		List<adminBoard> adminBoardList = new ArrayList<adminBoard>();
		String sql = prop.getProperty("selectBoardList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pagination.getboardTypeNo());
			int startRow=(pagination.getCurrentPage()-1)*pagination.getLimit()+1;
			int endRow =startRow+pagination.getLimit()-1;
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardNo =rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				int readCount = rs.getInt("READ_COUNT");
				Timestamp createDT = rs.getTimestamp("CREATE_DT");
				Timestamp modifyDT = rs.getTimestamp("MODIFY_DT");
				String boardStatus = rs.getString("BOARD_STATUS");
				int memberNo=rs.getInt("MEMBER_NO");
				int categoryCD = rs.getInt("CATEGORY_CD");
				int boardTypeNo= rs.getInt("BOARD_TYPE_NO");
				String memberId = rs.getString("MEMBER_ID");
				adminBoard board = new adminBoard(boardNo, boardTitle, boardContent, readCount, createDT, modifyDT, boardStatus, memberNo, categoryCD, boardTypeNo, memberId);
				adminBoardList.add(board);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return adminBoardList;
	}
	
	/** 기업 회원 목록 조회
	 * @param conn
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<adminMember> selectMember(Connection conn, Pagination pagination)throws Exception{
		// TODO Auto-generated method stub
		List<adminMember> adminMemberList= new ArrayList<adminMember>();
		String sql = prop.getProperty("selectMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pagination.getMemberGrade());
			int startRow=(pagination.getCurrentPage()-1)*pagination.getLimit()+1;
			int endRow =startRow+pagination.getLimit()-1;
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String memberId = rs.getString("MEMBER_ID");
				String memberPhone = rs.getString("MEMBER_PHONE");
				String memberEmail = rs.getString("MEMBER_EMAIL");
				Date enrollDate = rs.getDate("ENROLL_DATE");
				String memberStatus = rs.getString("MEMBER_STATUS");
				String manager = rs.getString("MANAGER");
				String companyName = rs.getString("COMPANY_NAME");
				String companyNo = rs.getString("COMPANY_NO");
				adminMember am = new adminMember();
				am.setMemberNo(memberNo);
				am.setMemberId(memberId);
				am.setMemberPhone(memberPhone);
				am.setMemberEmail(memberEmail);
				am.setEnrollDate(enrollDate);
				am.setMemberStatus(memberStatus);
				am.setManager(manager);
				am.setCompanyName(companyName);
				am.setCompanyNo(companyNo);
				adminMemberList.add(am);

			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return adminMemberList;
	}

	/**기업 회원 조회 목록 페이징 처리
	 * @param conn
	 * @param cp
	 * @param memberGrade
	 * @return
	 * @throws Exception
	 */
	public int getMemPagination(Connection conn, int cp, String memberGrade) throws Exception{
		// TODO Auto-generated method stub
		int map = 0;
		String sql = prop.getProperty("getMemPagination");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberGrade);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				map=rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return map;
	}

}
