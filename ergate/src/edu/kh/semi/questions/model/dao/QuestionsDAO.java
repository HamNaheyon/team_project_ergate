package edu.kh.semi.questions.model.dao;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.semi.questions.model.vo.Questions;


public class QuestionsDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL 구문을 읽어와 저장할 Properties 객체 참조 변수 선언
	private Properties prop = null;
	
	public QuestionsDAO() {
		
		String filePath = QuestionsDAO.class.getResource("/edu/kh/semi/sql/questions/questions.xml").getPath();
		// 													/edu/kh/semi/sql/member/member-query.xml
		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int freQuestionsSend(Connection conn, Questions frequestions) throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("questionsSend");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, frequestions.getQuestionsTitle());
			pstmt.setString(2, frequestions.getQuestionsContent());
//			pstmt.setInt(3, questions.getComNo());
			pstmt.setInt(3, frequestions.getFreNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int comQuestionsSend(Connection conn, Questions comquestions) throws Exception {
int result = 0;
		
		String sql = prop.getProperty("questionsSend");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, comquestions.getQuestionsTitle());
			pstmt.setString(2, comquestions.getQuestionsContent());
			pstmt.setInt(3, comquestions.getComNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	
}
