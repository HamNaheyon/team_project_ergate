//package edu.kh.semi.board.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import edu.kh.semi.board.model.service.InsertBoardService;
//import edu.kh.semi.board.model.vo.Category;
//import edu.kh.semi.member.model.vo.ComMember;
//
//@WebServlet("/board2/*")
//public class InsertBoardController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String uri = request.getRequestURI();
//
//		String contextPath = request.getContextPath();
//		
//		String command = uri.substring((contextPath + "/board2/").length());
//		
//		String path = null;
//		RequestDispatcher view = null;
//		
//		String icon = null;
//		String title = null;
//		String text = null;
//		
//		try {
//			InsertBoardService service = new InsertBoardService();
//			
//			int cp = request.getParameter("cp") == null ? 1 :
//				Integer.parseInt(request.getParameter("cp"));
//			
//			if(command.equals("insertForm")) {
//				List<Category> category = service.selectCategoryList();
//				
//				request.setAttribute("category", category);
//				
//				path = "/WEB-INF/views/board/posting.jsp";
//				view = request.getRequestDispatcher(path);
//				view.forward(request, response);
//				
//			}
//			else if(command.equals("insert")) {
//				int boardType = Integer.parseInt(request.getParameter("type"));
//				
//				HttpSession session = request.getSession();
//				int memberNo = ((ComMember)session.getAttribute("loginMember")).getMemberNo();
//				
//				System.out.println(boardType);
//				System.out.println(memberNo);
//
//				int maxSize = 1024 * 1024 * 20; 
//				
//				String root = session.getServletContext().getRealPath("/");
//				System.out.println("root : " + root);
//				
//				String filePath = "resources/images/";
//				
//				switch(boardType) {
//				case 1 : filePath += "freeboard/"; break; // resources/images/freeboard
//				case 2 : filePath += "infoboard/"; break; // resources/images/freeboard
//				case 3 : filePath += "QnAboard/"; break;
//				}
//				
//				System.out.println("실제 저장경로 : " + root + filePath);
//				
//				MultipartRequest mpRequest
//				= new MultipartRequest(request, root+filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
//				
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
