//package edu.kh.semi.boardTwo.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import edu.kh.semi.boardTwo.model.service.SelectBoardService;
//import edu.kh.semi.boardTwo.model.vo.Board;
//
//
//@WebServlet("/board/*")
//public class SelectBoardController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String uri = request.getRequestURI();  			
//		String contextPath = request.getContextPath(); 	
//		String command = uri.substring((contextPath + "/board/").length()); 
//	
//		String path = null; 
//		RequestDispatcher view = null; 
//		
//		String icon = null;
//		String title = null;
//		String text = null;
//		
//		try {
//			
//			SelectBoardService service = new SelectBoardService();
//			
//			int cp = request.getParameter("cp") == null ? 1 : Integer.parseInt(request.getParameter("cp"));
//			
//			if(command.equals("view")) {
//				
//				int boardNo = Integer.parseInt(request.getParameter("no"));
//				
//				Board board = service.selectBoard(boardNo);
//				
//				request.setAttribute("board", board);
//				
//				path = "/WEB-INF/views/detail/detailFree.jsp";
//				
//				view = request.getRequestDispatcher(path);
//				view.forward(request, response);
//				
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
