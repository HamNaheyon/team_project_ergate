package edu.kh.semi.boardTwo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.semi.board.model.service.SelectBoardService;
import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.boardTwo.model.service.BoardTwoService;
import edu.kh.semi.boardTwo.model.service.CommentsService;
import edu.kh.semi.boardTwo.model.vo.Board;
import edu.kh.semi.boardTwo.model.vo.Category;
import edu.kh.semi.boardTwo.model.vo.Comments;
import edu.kh.semi.common.MyFileRenamePolicy;
import edu.kh.semi.member.model.vo.ComMember;
import edu.kh.semi.member.model.vo.FreMember;

@WebServlet("/BoardTwo/*")
public class BoardTwoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/BoardTwo/").length());

		String path = null;
		RequestDispatcher view = null;

		String icon = null;
		String title = null;
		String text = null;

		try {
			BoardTwoService service = new BoardTwoService();

			if (command.equals("deleteBoard")) {

				HttpSession session = request.getSession();
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));

				int result = service.deleteBoard(boardNo);

				response.getWriter().print(result);

				if (result > 0) {
					icon = "success";
					title = "게시글 삭제 성공";
					session.setAttribute("icon", icon);
					session.setAttribute("title", title);
					response.sendRedirect(request.getContextPath());
				} else {
					icon = "error";
					title = "게시글 삭제 실패";
					session.setAttribute("icon", icon);
					session.setAttribute("title", title);
					path = request.getHeader("referer");
					response.sendRedirect(path);
				}
			} else if (command.equals("updateBoard")) {

				HttpSession session = request.getSession();

				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				int type = Integer.parseInt(request.getParameter("style"));
				int memberType = Integer.parseInt(request.getParameter("type"));
				
				edu.kh.semi.boardTwo.model.service.SelectBoardService service1 = new edu.kh.semi.boardTwo.model.service.SelectBoardService();
				
				
				if(type == 2) {
					Board board = service1.freeSelectBoard(boardNo);
					
					board.setBoardContent(board.getBoardContent().replaceAll("<br>", "\r\n"));
					
					List<Comments> rList = new CommentsService().selectList(boardNo);
					request.setAttribute("style", type);
					request.setAttribute("board", board);
					request.setAttribute("rList", rList);

					path = "/WEB-INF/views/detail/updateBoard.jsp";
					
				}else if(type == 1){
					if(memberType == 1) {
						Board board = service1.comFreeSelectBoard(boardNo);
						
						board.setBoardContent(board.getBoardContent().replaceAll("<br>", "\r\n"));
						
						List<Comments> rList = new CommentsService().selectList(boardNo);
						request.setAttribute("style", type);
						request.setAttribute("board", board);
						request.setAttribute("rList", rList);
						
						System.out.println("board : " + board);
						path = "/WEB-INF/views/detail/updateBoard.jsp";
						
					}else if(memberType == 2){
						Board board = service1.comSelectBoard(boardNo);
						
						board.setBoardContent(board.getBoardContent().replaceAll("<br>", "\r\n"));
						
						List<Comments> rList = new CommentsService().selectList(boardNo);
						request.setAttribute("style", type);
						System.out.println("board : " + board);
						request.setAttribute("board", board);
						request.setAttribute("rList", rList);
						
						path = "/WEB-INF/views/detail/updateBoard.jsp";
					}
				}
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}
			else if(command.equals("updateBoard1")) {
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				int boardStyle = Integer.parseInt(request.getParameter("style")); // 포트폴리오 / 제안서 (전 boardType)
				//System.out.println("gsdfsdfsd :     "+boardStyle);
				//int type = Integer.parseInt(request.getParameter("type")); // 포트폴리오 / 제안서 (전 boardType)
				
				HttpSession session = request.getSession();
				
				int memberNo = 0; // 로그인한 회원 번호
				int writerType = 0; // 글쓴 사람이 프리인가, 기업인가 (현 boardType)
				
				if( session.getAttribute("comLoginMember") != null  ) {
					memberNo = ((ComMember)session.getAttribute("comLoginMember")).getMemberNo();
					writerType = 2;
					
				}else {
					memberNo = ((FreMember)session.getAttribute("freLoginMember")).getMemberNo();
					writerType = 1;
				}
				
				

				int maxSize = 1024 * 1024 * 40; 
				
				String root = session.getServletContext().getRealPath("/");
				System.out.println("root : " + root);
				
				String filePath = "resources/img/";
				
				switch(boardStyle) {
				case 1 : filePath += "ppboard/"; break;  // 제안서
				case 2 : filePath += "pfboard/"; break;  // 포트폴리오
				}
				
				System.out.println("실제 저장경로 : " + root + filePath);
				
				MultipartRequest mpRequest
				= new MultipartRequest(request, root+filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
				List<Attachment> atList = new ArrayList<Attachment>();
				
				Enumeration<String> images = mpRequest.getFileNames();
				
				while(images.hasMoreElements()) {
					String name = images.nextElement();
//					System.out.println("name : " + name);
					
//					System.out.println("변경 된 파일 명 : " + mpRequest.getFilesystemName(name));
//					System.out.println("변경 전 파일 명 : " + mpRequest.getOriginalFileName(name));
					
					if(mpRequest.getFilesystemName(name) != null) {
						Attachment at = new Attachment();
						
						at.setFilePath(filePath);
						at.setFileNM(mpRequest.getFilesystemName(name) );
						
						if(!(name.substring(0, 3).equals("img"))) {
							at.setFileLevel(1);
							System.out.println("Tjasdfsdfsdf        : " + name.substring(0,4));
						}else {
							at.setFileLevel(Integer.parseInt(name.substring("img".length())));
						}

						atList.add(at);
					}
				}
				for(Attachment a: atList) {
					System.out.println(a);
				}
				
				String boardTitle = mpRequest.getParameter("boardTitle");
				String boardContent = mpRequest.getParameter("boardContent");
				
				int categoryCode = Integer.parseInt(mpRequest.getParameter("categoryCd")); // 웹 / 앱
				
				
				Board board = new Board();
				board.setBoardTitle(boardTitle);
				board.setBoardContent(boardContent);
				board.setMemberNo(memberNo);
				
				System.out.println(board);
				
				int result = service.updateBoard1(boardNo, board, atList, categoryCode, boardStyle, writerType);
				
				if(result > 0) {
					System.out.println(result);
					icon = "success";
					title = "게시글 수정 성공";
					path = "../detailBoard?boardNo=" + result + "&cp=1&style=" + boardStyle + "&type=" + writerType;
//					path = "../detailBoard/detailBoard?no=" + result + "&cp=1&type=" + boardStyle;
					
				}else {
					icon = "error";
					title = "게시글 수정 실패";
					path = request.getHeader("referer");
					
				}
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				response.sendRedirect(path);
			
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
