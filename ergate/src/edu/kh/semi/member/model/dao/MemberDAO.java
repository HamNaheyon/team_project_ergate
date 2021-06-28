package edu.kh.semi.member.model.dao;

import static edu.kh.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.semi.member.model.vo.ComMember;
import edu.kh.semi.member.model.vo.FreMember;

public class MemberDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	
	public MemberDAO() {
		String filePath = MemberDAO.class.getResource("/edu/kh/semi/sql/member/member-query.xml").getPath();
		
		try {
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/** 프리랜서 로그인 DAO
	 * @param conn
	 * @param freId
	 * @param frePw
	 * @return
	 * @throws Exception
	 */
	public FreMember freLogin(Connection conn, String freId, String frePw)throws Exception {
		
		FreMember freLoginMember = null;
		
		String sql = prop.getProperty("freLogin");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, freId);
			pstmt.setString(2, frePw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				freLoginMember = new FreMember(rs.getInt("MEMBER_NO"), 
								rs.getString("MEMBER_ID"), 
								rs.getString("MEMBER_NAME"), 
								rs.getString("MEMBER_PHONE"), 
								rs.getString("MEMBER_EMAIL"), 
								rs.getString("MEMBER_GRADE"), 
								rs.getString("MIN_TIME"), 
								rs.getString("MAX_TIME"), 
								rs.getString("MIN_SALARY"), 
								rs.getString("MAX_SALARY"), 
								rs.getString("FEILD"), 
								rs.getString("WORK"), 
								rs.getString("EXPERIENCE"), 
								rs.getString("SKIL"), 
								rs.getDate("ENROLL_DATE"), 
								rs.getString("MEMBER_GENDER"),
								rs.getString("JUMINNUM"));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return freLoginMember;
	}

	/** 프리랜서 회원가입 DAO
	 * @param conn
	 * @param freMember
	 * @return 
	 * @throws Exception
	 */
	public int freSignUp(Connection conn, FreMember freMember)throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("freSignUp");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, freMember.getMemberId());
			pstmt.setString(2, freMember.getMemberPw());
			pstmt.setString(3, freMember.getMemberPhone());
			pstmt.setString(4, freMember.getMemberEmail());
			pstmt.setString(5, freMember.getJuminNum());
			pstmt.setString(6, freMember.getMemberName());
			pstmt.setString(7, freMember.getMinTime());
			pstmt.setString(8, freMember.getMaxTime());
			pstmt.setString(9, freMember.getGender());
			pstmt.setString(10, freMember.getMinSalary());
			pstmt.setString(11, freMember.getMaxSalary());
			pstmt.setString(12, freMember.getFeild());
			pstmt.setString(13, freMember.getWork());
			pstmt.setString(14, freMember.getExperience());
			pstmt.setString(15, freMember.getSkil());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 아이디 중복 검사 
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String id)throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("idDupCheck");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
	            result = rs.getInt(1);
	         }
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	/** 기업 회원가입 DAO
	 * @param conn
	 * @param comMember
	 * @return result
	 * @throws Exception
	 */
	public int comSignUp(Connection conn, ComMember comMember)throws Exception {
		
		int result = 0;
		
String sql = prop.getProperty("comSignUp");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, comMember.getComId());
			pstmt.setString(2, comMember.getComPw());
			pstmt.setString(3, comMember.getComPhone());
			pstmt.setString(4, comMember.getComEmail());
			pstmt.setString(5, comMember.getJuminNum());
			pstmt.setString(6, comMember.getManager());
			pstmt.setString(7, comMember.getCompanyName());
			pstmt.setString(8, comMember.getCompanyNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 기업 로그인 DAO
	 * @param conn
	 * @param comId
	 * @param comPw
	 * @return comLoginMember
	 * @throws Exception
	 */
	public ComMember comLogin(Connection conn, String comId, String comPw)throws Exception {
			
		ComMember comLoginMember = null;
		
		String sql = prop.getProperty("comLogin");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,comId);
			pstmt.setString(2,comPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				comLoginMember = new ComMember(rs.getInt("MEMBER_NO"), 
						rs.getNString("MEMBER_ID"), 
						rs.getString("MEMBER_PHONE"),  
						rs.getString("MEMBER_EMAIL"), 
						rs.getString("JUMINNUM"), 
						rs.getString("MEMBER_GRADE"), 
						rs.getString("MANAGER"), 
						rs.getString("COMPANY_NAME"), 
						rs.getString("COMPANY_NO"), 
						rs.getDate("ENROLL_DATE"));
						
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
			
			
			
		return comLoginMember;
	}
}










































