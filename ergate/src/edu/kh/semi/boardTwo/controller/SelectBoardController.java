package edu.kh.semi.boardTwo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.semi.boardTwo.model.service.CommentsService;
import edu.kh.semi.boardTwo.model.service.SelectBoardService;
import edu.kh.semi.boardTwo.model.vo.Board;
import edu.kh.semi.boardTwo.model.vo.Category;
import edu.kh.semi.boardTwo.model.vo.Comments;


@WebServlet("/detailBoard/*")
public class SelectBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();  			
		System.out.println("uri : "+uri);
		String contextPath = request.getContextPath(); 	
		System.out.println("contextPath : "+contextPath);
		String command = uri.substring((contextPath).length()+1); 
		System.out.println("command :"+command);
		String path = null; 
		RequestDispatcher view = null; 
		
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			
			SelectBoardService service = new SelectBoardService();
			
			int cp = request.getParameter("cp") == null ? 1 : Integer.parseInt(request.getParameter("cp"));
			System.out.println(cp);
			
			if(command.equals("detailBoard")) {
				
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				int type = Integer.parseInt(request.getParameter("style"));
				
				if(type == 2) {
					Board board = service.freeSelectBoard(boardNo);
					
					List<Comments> rList = new CommentsService().selectList(boardNo);
					
					request.setAttribute("board", board);
					request.setAttribute("rList", rList);
					
					path = "/WEB-INF/views/detail/detailFree.jsp";
				}else if(type == 1){
					Board board = service.ComSelectBoard(boardNo);

					List<Comments> rList = new CommentsService().selectList(boardNo);
					
					request.setAttribute("board", board);
					request.setAttribute("rList", rList);
					
					path = "/WEB-INF/views/detail/detailCompany.jsp";
				}
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
