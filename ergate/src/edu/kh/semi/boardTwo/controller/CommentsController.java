package edu.kh.semi.boardTwo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.kh.semi.boardTwo.model.service.CommentsService;
import edu.kh.semi.boardTwo.model.vo.Comments;

@WebServlet("/comments/*")
public class CommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/comments/").length());
		
		try {
			
			CommentsService service = new CommentsService();
			
			if(command.equals("list")) {
				
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				
				List<Comments> list = service.selectList(boardNo);
				
				Gson gson = new GsonBuilder().setDateFormat("yyyy년 MM월 dd일 HH:mm").create();
				gson.toJson(list, response.getWriter());
				
			}else if(command.equals("insertComments")) {
				int memberNo = Integer.parseInt(request.getParameter("memberNo"));
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				String commentsContent = request.getParameter("commentsContent");
				
				Comments comments = new Comments();
				
				comments.setMemberNo(memberNo);
				comments.setBoardNo(boardNo);
				comments.setCommentsContent(commentsContent);
				
				int result = service.insertComments(comments);
			}else if(command.equals("updateComments")) {
				int commentsNo = Integer.parseInt(request.getParameter("commentsNo"));
				String commentsContent = request.getParameter("commentsContent");
				
				Comments comments = new Comments();
				
				comments.setCommentsNo(commentsNo);
				comments.setCommentsContent(commentsContent);
				
				int result = service.updateComments(comments);
				
				response.getWriter().print(result);
			}else if(command.equals("deleteComments")) {
				int commentsNo = Integer.parseInt(request.getParameter("commentsNo"));
				
				int result = service.deleteComments(commentsNo);
				
				response.getWriter().print(result);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
