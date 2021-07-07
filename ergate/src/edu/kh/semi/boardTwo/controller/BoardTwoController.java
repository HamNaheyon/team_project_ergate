package edu.kh.semi.boardTwo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.board.model.service.SelectBoardService;
import edu.kh.semi.boardTwo.model.service.BoardTwoService;
import edu.kh.semi.boardTwo.model.vo.Board;

@WebServlet("/BoardTwo/*")
public class BoardTwoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();  			
		String contextPath = request.getContextPath(); 	
		String command = uri.substring( (contextPath + "/BoardTwo/").length() ); 
		
		String path = null; 
		RequestDispatcher view = null; 
		
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			BoardTwoService service = new BoardTwoService();
			
			if(command.equals("deleteBoard")) {
				
				HttpSession session = request.getSession();
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				
				int result = service.deleteBoard(boardNo);
				
				response.getWriter().print(result);
				
				if(result >0) {
					icon = "success";
					title = "게시글 삭제 성공";
					path = "$request.getContextPath()";
					response.sendRedirect(request.getContextPath());
				}else {
					icon = "error";
					title = "게시글 삭제 실패";
					path = request.getHeader("referer");
				}
				
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				response.sendRedirect(path);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
