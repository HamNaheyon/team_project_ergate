package edu.kh.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.semi.board.model.service.SelectBoardService;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Pagination;

/**
 * @author 함나현 hammcoder@gamil.com
 *
 */
@WebServlet("/board/*")
public class SelectBoardAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		String contextPath = request.getContextPath();
		
		String command = uri.substring((contextPath + "/board/").length());
		
		String path = null;
		RequestDispatcher view = null;
		
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			
			SelectBoardService service = new SelectBoardService();
			
			int cp = request.getParameter("cp") == null ? 1 :
				Integer.parseInt(request.getParameter("cp"));
//			int ca = request.getParameter("ca") == null ? 1 :
//				Integer.parseInt(request.getParameter("ca"));
			
			if(command.equals("list")) {
				int boardType = Integer.parseInt(request.getParameter("type"));
				
				Pagination pagination = service.getPagination(cp, boardType);
//				Category category = service.getCategory(ca, categoryCode);
				
				List<Board> boardList = service.selectBoardList(pagination);
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("boardList", boardList);
				
				path = "/WEB-INF/views/board/BoardMain.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				System.out.println(boardList);
			}else if(command.contentEquals("view")) {
				int boardNo = Integer.parseInt(request.getParameter("no"));
				
				Board board = service.selectBoard(boardNo);
				
				request.setAttribute("board", board);
				
				path = "/WEB-INF/views/board/BoardMain.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				
				System.out.println(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
