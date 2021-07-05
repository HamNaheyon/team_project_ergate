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

import edu.kh.ergate.admin.model.vo.AdminQuestion;
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
				int boardStyle = rs.getInt("BOARD_STYLE");
				adminBoard board = new adminBoard(boardNo, boardTitle, boardContent, readCount, createDT, modifyDT, boardStatus, memberNo, categoryCD, boardTypeNo, memberId,boardStyle);
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
				int boardStyle = rs.getInt("BOARD_STYLE");
				adminBoard board = new adminBoard(boardNo, boardTitle, boardContent, readCount, createDT, modifyDT, boardStatus, memberNo, categoryCD, boardTypeNo, memberId,boardStyle);
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

	public adminMember adminSel(Connection conn, int memberNo) throws Exception{
		// TODO Auto-generated method stub
		adminMember am = new adminMember();
		String sql = prop.getProperty("adminSel");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String memberId = rs.getString("MEMBER_ID");
				String memberPhone = rs.getString("MEMBER_PHONE");
				String memberEmail = rs.getString("MEMBER_EMAIL");
				Date enrollDate = rs.getDate("ENROLL_DATE");
				String memberStatus = rs.getString("MEMBER_STATUS");
				String manager = rs.getString("MANAGER");
				String companyName = rs.getString("COMPANY_NAME");
				String companyNo = rs.getString("COMPANY_NO");
				
				System.out.println(memberId);
				am.setMemberId(memberId);
				am.setMemberPhone(memberPhone);
				am.setMemberEmail(memberEmail);
				am.setEnrollDate(enrollDate);
				am.setMemberStatus(memberStatus);
				am.setManager(manager);
				am.setCompanyName(companyName);
				am.setCompanyNo(companyNo);
				
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return am;
	}

	/** 회원 전체 조회2
	 * @param conn
	 * @param pagination
	 * @return
	 */
	public List<adminMember> selectMember2(Connection conn, Pagination pagination) throws Exception{
		// TODO Auto-generated method stub
		List<adminMember> adminMemberList= new ArrayList<adminMember>();
		String sql = prop.getProperty("selectMember2");
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
				String memberName = rs.getString("MEMBER_NAME");
				String minTime = rs.getString("MIN_TIME");
				String maxTime = rs.getString("MAX_TIME");
				String minSalary = rs.getString("MIN_SALARY");
				String maxSalary = rs.getString("MAX_SALARY");
				String feild = rs.getString("FEILD");
				String work = rs.getString("WORK");
				String experience = rs.getString("EXPERIENCE");
				String skil = rs.getString("SKIL");
				adminMember am = new adminMember();
				am.setMemberNo(memberNo);
				am.setMemberId(memberId);
				am.setMemberPhone(memberPhone);
				am.setMemberEmail(memberEmail);
				am.setEnrollDate(enrollDate);
				am.setMemberStatus(memberStatus);
				am.setMemberName(memberName);
				am.setMinTime(minTime);
				am.setMaxTime(maxTime);
				am.setMinSalary(minSalary);
				am.setMaxSalary(maxSalary);
				am.setFeild(feild);
				am.setWork(work);
				am.setExperience(experience);
				am.setSkil(skil);
				
				adminMemberList.add(am);

			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return adminMemberList;
	}

	public int getMemPagination2(Connection conn, int cp, String memberGrade) throws Exception{
		// TODO Auto-generated method stub
		int map = 0;
		String sql = prop.getProperty("getMemPagination2");
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

	public adminMember adminSel2(Connection conn, int memberNo) throws Exception{
		// TODO Auto-generated method stub
		adminMember am = new adminMember();
		String sql = prop.getProperty("adminSel2");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String memberId = rs.getString("MEMBER_ID");
				String memberPhone = rs.getString("MEMBER_PHONE");
				String memberEmail = rs.getString("MEMBER_EMAIL");
				Date enrollDate = rs.getDate("ENROLL_DATE");
				String memberStatus = rs.getString("MEMBER_STATUS");
				String memberName = rs.getString("MEMBER_NAME");
				String minTime = rs.getString("MIN_TIME");
				String maxTime = rs.getString("MAX_TIME");
				String minSalary = rs.getString("MIN_SALARY");
				String maxSalary = rs.getString("MAX_SALARY");
				String feild = rs.getString("FEILD");
				String work = rs.getString("WORK");
				String experience = rs.getString("EXPERIENCE");
				String skil = rs.getString("SKIL");
			
				am.setMemberNo(memberNo);
				am.setMemberId(memberId);
				am.setMemberPhone(memberPhone);
				am.setMemberEmail(memberEmail);
				am.setEnrollDate(enrollDate);
				am.setMemberStatus(memberStatus);
				am.setMemberName(memberName);
				am.setMinTime(minTime);
				am.setMaxTime(maxTime);
				am.setMinSalary(minSalary);
				am.setMaxSalary(maxSalary);
				am.setFeild(feild);
				am.setWork(work);
				am.setExperience(experience);
				am.setSkil(skil);
				
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return am;
	}

	public int getQuestionPagination(Connection conn, int cp) throws Exception{
		// TODO Auto-generated method stub
		int map = 0;
		String sql = prop.getProperty("getQuestionPagination");
		try {
			pstmt=conn.prepareStatement(sql);
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

	public List<AdminQuestion> selectQuestion(Connection conn, Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		List<AdminQuestion>  aq= null;
		String sql = prop.getProperty("selectQuestion");
		try {
			pstmt= conn.prepareStatement(sql);
			int startRow=(pagination.getCurrentPage()-1)*pagination.getLimit()+1;
			int endRow =startRow+pagination.getLimit()-1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			aq = new ArrayList<AdminQuestion>();
			while(rs.next()) {
				int questionNo = rs.getInt("QUESTION_NO");
				String questionTitle = rs.getString("QUESTION_TITLE");
				String questionContent = rs.getString("QUESTION_CONTENT");
				Date questionDate = rs.getDate("QUESTION_DATE");
				int memberNo = rs.getInt("MEMBER_NO");
				String questionStatus = rs.getString("QUESTION_STATUS");
				String memberId = rs.getString("MEMBER_ID");
				String memberEmail = rs.getString("MEMBER_EMAIL");
				String memberGrade = rs.getString("MEMBER_GRADE");
				
				AdminQuestion a = new AdminQuestion(questionNo, questionTitle, questionContent, memberId, questionDate, memberEmail, memberGrade, memberNo, questionStatus);
				aq.add(a);
						
				
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return aq;
	}

	public AdminQuestion selectQuestionView(Connection conn, int qNo) throws Exception {
		// TODO Auto-generated method stub
		AdminQuestion aq = null;
		String sql = prop.getProperty("selectQuestionView");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int questionNo = rs.getInt(1);
				String questionTitle =rs.getString(2);
				String questionContent =rs.getString(3);
				Date questionDate = rs.getDate(4);
				String questionStatus = rs.getString(5);
				String memberId =rs.getString(6);
				String memberEmail = rs.getString(7);
				String memberGrade = rs.getString(8);
				
				aq = new AdminQuestion(questionNo, questionTitle, questionContent, memberId, questionDate, memberEmail, memberGrade, questionStatus);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return aq;
	}
	public Map<String, Object> getPagination(Connection conn, int cp, int boardTypeNo,String condition)throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = prop.getProperty("getListCount")+condition;
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
	public List<adminBoard> selectBoardList(Connection conn, Pagination pagination,String condition) throws Exception{
		// TODO Auto-generated method stub
		List<adminBoard> adminBoardList = new ArrayList<adminBoard>();
		String sql = prop.getProperty("selectBoardList1")+condition+prop.getProperty("selectBoardList2");
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
				int boardStyle = rs.getInt("BOARD_STYLE");
				adminBoard board = new adminBoard(boardNo, boardTitle, boardContent, readCount, createDT, modifyDT, boardStatus, memberNo, categoryCD, boardTypeNo, memberId,boardStyle);
				adminBoardList.add(board);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return adminBoardList;
	}
	public int getMemPagination(Connection conn, int cp, String memberGrade,String condition) throws Exception{
		// TODO Auto-generated method stub
		int map = 0;
		String sql = prop.getProperty("getMemPagination")+condition;
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
	
	public List<adminMember> selectMember(Connection conn, Pagination pagination,String condition)throws Exception{
		// TODO Auto-generated method stub
		List<adminMember> adminMemberList= new ArrayList<adminMember>();
		String sql = prop.getProperty("selectMember3")+condition+prop.getProperty("selectMember4");
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
	
	
	public int getMemPagination2(Connection conn, int cp, String memberGrade,String condition) throws Exception{
		// TODO Auto-generated method stub
		int map = 0;
		String sql = prop.getProperty("getMemPagination2")+condition;
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
	public List<adminMember> selectMember2(Connection conn, Pagination pagination,String condition) throws Exception{
		// TODO Auto-generated method stub
		List<adminMember> adminMemberList= new ArrayList<adminMember>();
		String sql = prop.getProperty("selectMember3")+condition+prop.getProperty("selectMember4");
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
				String memberName = rs.getString("MEMBER_NAME");
				String minTime = rs.getString("MIN_TIME");
				String maxTime = rs.getString("MAX_TIME");
				String minSalary = rs.getString("MIN_SALARY");
				String maxSalary = rs.getString("MAX_SALARY");
				String feild = rs.getString("FEILD");
				String work = rs.getString("WORK");
				String experience = rs.getString("EXPERIENCE");
				String skil = rs.getString("SKIL");
				adminMember am = new adminMember();
				am.setMemberNo(memberNo);
				am.setMemberId(memberId);
				am.setMemberPhone(memberPhone);
				am.setMemberEmail(memberEmail);
				am.setEnrollDate(enrollDate);
				am.setMemberStatus(memberStatus);
				am.setMemberName(memberName);
				am.setMinTime(minTime);
				am.setMaxTime(maxTime);
				am.setMinSalary(minSalary);
				am.setMaxSalary(maxSalary);
				am.setFeild(feild);
				am.setWork(work);
				am.setExperience(experience);
				am.setSkil(skil);
				
				adminMemberList.add(am);

			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return adminMemberList;
	}
	
	public int getQuestionPagination(Connection conn, int cp,String condition) throws Exception{
		// TODO Auto-generated method stub
		int map = 0;
		System.out.println("qu"+condition);
		String sql = prop.getProperty("getQuestionPagination1")+condition;
		try {
			pstmt=conn.prepareStatement(sql);
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

	public List<AdminQuestion> selectQuestion(Connection conn, Pagination pagination,String condition) throws Exception {
		// TODO Auto-generated method stub
		List<AdminQuestion>  aq= null;
		String sql = prop.getProperty("selectQuestion1")+condition+prop.getProperty("selectQuestion2");
		try {
			pstmt= conn.prepareStatement(sql);
			int startRow=(pagination.getCurrentPage()-1)*pagination.getLimit()+1;
			int endRow =startRow+pagination.getLimit()-1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			aq = new ArrayList<AdminQuestion>();
			while(rs.next()) {
				int questionNo = rs.getInt("QUESTION_NO");
				String questionTitle = rs.getString("QUESTION_TITLE");
				String questionContent = rs.getString("QUESTION_CONTENT");
				Date questionDate = rs.getDate("QUESTION_DATE");
				int memberNo = rs.getInt("MEMBER_NO");
				String questionStatus = rs.getString("QUESTION_STATUS");
				String memberId = rs.getString("MEMBER_ID");
				String memberEmail = rs.getString("MEMBER_EMAIL");
				String memberGrade = rs.getString("MEMBER_GRADE");
				
				AdminQuestion a = new AdminQuestion(questionNo, questionTitle, questionContent, memberId, questionDate, memberEmail, memberGrade, memberNo, questionStatus);
				aq.add(a);
						
				
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return aq;
	}
}
