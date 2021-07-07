package edu.kh.semi.boardTwo.model.dao;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.semi.boardTwo.model.vo.Attachment;
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 프리랜서 게시글 상세 조회 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board freeSelectBoard(Connection conn, int boardNo) throws Exception {

		Board board = null;

		String sql = prop.getProperty("freeSelectBoard");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			board = new Board();

			board.setAtList(new ArrayList<Attachment>());

			boolean flag = true;

			while (rs.next()) {
				if (flag) {
					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setCategoryName(rs.getString("CATEGORY_NM"));
					board.setBoardTitle(rs.getString("BOARD_TITLE"));
					board.setMemberId(rs.getString("MEMBER_ID"));
					board.setReadCount(rs.getInt("READ_COUNT"));

					board.setMinTime(rs.getString("MIN_TIME"));
					board.setMaxTime(rs.getString("MAX_TIME"));
					board.setMinSalary(rs.getString("MIN_SALARY"));
					board.setMaxSalary(rs.getString("MAX_SALARY"));
					board.setWork(rs.getString("WORK"));
					board.setExperience(rs.getString("EXPERIENCE"));
					board.setSkil(rs.getString("SKIL"));
					board.setMemberGrade(rs.getString("MEMBER_GRADE"));

					board.setBoardContent(rs.getString("BOARD_CONTENT"));
					board.setMemberNo(rs.getInt("MEMBER_NO"));
					board.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					flag = false;
				}

				
				/*
				 * List<String> filePath = new ArrayList<String>(); List<String> fileName = new
				 * ArrayList<String>(); List<String> fileLevel = new ArrayList<String>();
				 * 
				 * filePath.add(rs.getString("FILE_PATH"));
				 * fileName.add(rs.getString("FILE_NM"));
				 * fileLevel.add(rs.getString("FILE_LEVEL"));
				 * 
				 * board.setFilePath(filePath); board.setFileName(fileName);
				 * board.setFileLevel(fileLevel);
				 */
				 

				Attachment at = new Attachment();
				at.setFilePath(rs.getString("FILE_PATH"));
				at.setFileName(rs.getString("FILE_NM"));
				at.setFileLevel(rs.getInt("FILE_LEVEL"));

				// 값 세팅이 완료된 Attachment 객체를
				// board의 atList에 추가
				board.getAtList().add(at);
			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return board;
	}

	/**
	 * 기업 게시글 상세 조회 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board comSelectBoard(Connection conn, int boardNo) throws Exception {

		Board board = null;

		String sql = prop.getProperty("ComSelectBoard");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();
			board = new Board();
			board.setAtList(new ArrayList<Attachment>());
			boolean flag = true;
			while (rs.next()) {
				if (flag) {
					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setBoardTitle(rs.getString("BOARD_TITLE"));
					board.setReadCount(rs.getInt("READ_COUNT"));
					// COMPANY_NAME, MANAGER,
					board.setCompanyName(rs.getString("COMPANY_NAME"));
					board.setManager(rs.getString("MANAGER"));

					board.setMemberGrade(rs.getString("MEMBER_GRADE"));

					board.setBoardContent(rs.getString("BOARD_CONTENT"));
					board.setMemberNo(rs.getInt("MEMBER_NO"));
					board.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					flag = false;
				}

//				// 조회된 파일 관련 정보를 저장할 객체 선언(경로, 이름, 레벨)
				Attachment at = new Attachment();
				at.setFilePath(rs.getString("FILE_PATH"));
				at.setFileName(rs.getString("FILE_NM"));
				at.setFileLevel(rs.getInt("FILE_LEVEL"));

				// 값 세팅이 완료된 Attachment 객체를
				// board의 atList에 추가
				board.getAtList().add(at);
			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return board;
	}
	
	public Board comFreeSelectBoard(Connection conn, int boardNo) throws Exception {

		Board board = null;

		String sql = prop.getProperty("freeSelectBoard");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();
			
			board = new Board();
			board.setAtList(new ArrayList<Attachment>());
			
			boolean flag = true;
			
			while (rs.next()) {
				if (flag) {
					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setCategoryName(rs.getString("CATEGORY_NM"));
					board.setBoardTitle(rs.getString("BOARD_TITLE"));
					board.setMemberId(rs.getString("MEMBER_ID"));
					board.setReadCount(rs.getInt("READ_COUNT"));

					board.setMinTime(rs.getString("MIN_TIME"));
					board.setMaxTime(rs.getString("MAX_TIME"));
					board.setMinSalary(rs.getString("MIN_SALARY"));
					board.setMaxSalary(rs.getString("MAX_SALARY"));
					board.setWork(rs.getString("WORK"));
					board.setExperience(rs.getString("EXPERIENCE"));
					board.setSkil(rs.getString("SKIL"));
					board.setMemberGrade(rs.getString("MEMBER_GRADE"));

					board.setBoardContent(rs.getString("BOARD_CONTENT"));
					board.setMemberNo(rs.getInt("MEMBER_NO"));
					board.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					flag = false;
				}


//				// 조회된 파일 관련 정보를 저장할 객체 선언(경로, 이름, 레벨)
				Attachment at = new Attachment();
				at.setFilePath(rs.getString("FILE_PATH"));
				at.setFileName(rs.getString("FILE_NM"));
				at.setFileLevel(rs.getInt("FILE_LEVEL"));

				// 값 세팅이 완료된 Attachment 객체를
				// board의 atList에 추가
				board.getAtList().add(at);
			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return board;
	}

	/**
	 * 게시글 조회수 증가 DAO
	 * 
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
