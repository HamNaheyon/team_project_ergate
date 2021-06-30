package edu.kh.semi.questions.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.vo.ComMember;
import edu.kh.semi.member.model.vo.FreMember;
import edu.kh.semi.questions.model.service.QuestionsService;
import edu.kh.semi.questions.model.vo.Questions;



@WebServlet("/questions")
public class QuestionsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/questions.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		FreMember freLoginMember = (FreMember)session.getAttribute("freLoginMember");
		ComMember comLoginMember = (ComMember)session.getAttribute("comLoginMember");
		
		int comNo = comLoginMember.getMemberNo();
		int freNo = freLoginMember.getMemberNo();
		String questionsTitle = request.getParameter("title");
		String questionsContent = request.getParameter("contents");
		
		/* 확인용
 		 * System.out.println(questionTitle); 
 		 * System.out.println(questionsContent);
		 */
		
		Questions questions = new Questions(comNo, freNo, questionsTitle, questionsContent);
		
		try {
			
			/*int result = new MemberService().signUp(member);*/
			int result = new QuestionsService().freQuestionsSend(questions);
			
			String icon = null;
			String title = null;
			String text = null;
			
			if(result > 0) { 
				icon = "success";
				title = "문의가 접수되었습니다.";
				text = "답변은 이메일로 전송됩니다.";
			}else {
				icon = "error";
				title = "문의 접수 실패";
				text = "문의 접수의 오류가 발생하였습니다.";
			}
			
			session.setAttribute("icon", icon);
			session.setAttribute("title", title);
			session.setAttribute("text", text);
			
			// 메인 페이지로 돌아간다 -> redirect 
			// 메인 페이지를 응답하는 요청 주소로 재요청 하기
			response.sendRedirect(request.getContextPath());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
