package edu.kh.semi.questions.model.service;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.semi.questions.model.dao.QuestionsDAO;
import edu.kh.semi.questions.model.vo.Questions;



public class QuestionsService {
	
	private QuestionsDAO dao = new QuestionsDAO();

	public int freQuestionsSend(Questions frequestions) throws Exception {
		
		Connection conn = getConnection();
		
		frequestions.setQuestionsContent(replaceParameter(frequestions.getQuestionsContent()));
		frequestions.setQuestionsTitle(replaceParameter(frequestions.getQuestionsTitle()));
		
		frequestions.setQuestionsContent(frequestions.getQuestionsContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		frequestions.setQuestionsTitle(frequestions.getQuestionsTitle().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		
		int result = dao.freQuestionsSend(conn, frequestions);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);

		return result;
	}

	public int comQuestionsSend(Questions comquestions) throws Exception {
		
		Connection conn = getConnection();

		comquestions.setQuestionsContent(replaceParameter(comquestions.getQuestionsContent()));
		comquestions.setQuestionsTitle(replaceParameter(comquestions.getQuestionsTitle()));
		
		comquestions.setQuestionsContent(comquestions.getQuestionsContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		comquestions.setQuestionsTitle(comquestions.getQuestionsTitle().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		
		int result = dao.comQuestionsSend(conn, comquestions);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);

		return result;
	}
	
	private String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		return result;
	}

}
