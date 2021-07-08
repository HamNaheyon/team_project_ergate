package edu.kh.semi.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.service.MyPostService;
import edu.kh.semi.member.model.vo.ComMember;
import edu.kh.semi.member.model.vo.FreMember;
import edu.kh.semi.member.model.vo.MemberBoard;
import edu.kh.semi.member.model.vo.MyPostPagination;
import edu.kh.semi.member.model.vo.Question;

@WebServlet("/com_myQuestion/*")
public class ComMyQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/com_myQuestion/").length());

		String path = null;
		RequestDispatcher view = null;

		try {

			MyPostService service = new MyPostService();

			HttpSession session = request.getSession();

			ComMember comLoginMember = (ComMember)session.getAttribute("comLoginMember");
			
			int memberNo = comLoginMember.getMemberNo();

			// 현재 페이지
			int cp = request.getParameter("cp") == null ? 1 : Integer.parseInt(request.getParameter("cp"));

			// 문의사항 목록 조회
			if (command.equals("list")) {

				
				 MyPostPagination pagination = service.getQuestionPagination(cp,memberNo);
				 
				 List<Question> questionList = service.QuestionList(pagination,memberNo);
				  
				 pagination.setMemberNo(memberNo);
				 
				 session.setAttribute("pagination", pagination);
				 session.setAttribute("questionList", questionList);
				  
				 path = "/WEB-INF/views/member/com_myQuestion.jsp";
				 view = request.getRequestDispatcher(path); 
				 view.forward(request, response);
				 

				// 문의사항 상세 조회
			} else if (command.equals("view")) {
				
				int questionNo = Integer.parseInt(request.getParameter("questionNo"));
				
				Question question = service.selectQuestion(questionNo);
				
				request.setAttribute("question", question);
				
				// 왜 안가
				path = "/WEB-INF/views/member/Question.jsp"; 
				view = request.getRequestDispatcher(path); 
				view.forward(request, response);  
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}