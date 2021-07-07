package edu.kh.semi.questions.model.service;

import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.semi.questions.model.dao.QuestionsDAO;
import edu.kh.semi.questions.model.vo.Questions;



public class QuestionsService {
	
	private QuestionsDAO dao = new QuestionsDAO();

	public int freQuestionsSend(Questions frequestions) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.freQuestionsSend(conn, frequestions);

		String questionsContent = frequestions.getQuestionsContent(); // <script> \r\n
		questionsContent = replaceParameter(questionsContent); // &lt;script&gt;
		questionsContent = questionsContent.replaceAll("\r\n", "<br>"); // &lt;script&gt; <br>
		frequestions.setQuestionsContent(questionsContent);
		
		frequestions.setQuestionsContent( replaceParameter( frequestions.getQuestionsContent()) );
		frequestions.setQuestionsTitle( replaceParameter( frequestions.getQuestionsTitle()) );
		frequestions.setQuestionsContent( frequestions.getQuestionsContent().replaceAll("\r\n", "<br>") );
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);

		return result;
	}

	public int comQuestionsSend(Questions comLoginMember) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.comQuestionsSend(conn, comLoginMember);
		
		String questionsContent = comLoginMember.getQuestionsContent(); // <script> \r\n
		questionsContent = replaceParameter(questionsContent); // &lt;script&gt;
		questionsContent = questionsContent.replaceAll("\r\n", "<br>"); // &lt;script&gt; <br>
		comLoginMember.setQuestionsContent(questionsContent);
		
		comLoginMember.setQuestionsContent( replaceParameter( comLoginMember.getQuestionsContent()) );
		comLoginMember.setQuestionsTitle( replaceParameter( comLoginMember.getQuestionsTitle()) );
		comLoginMember.setQuestionsContent( comLoginMember.getQuestionsContent().replaceAll("\r\n", "<br>") );

		
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
