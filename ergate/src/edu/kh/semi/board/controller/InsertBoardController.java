package edu.kh.semi.board.controller;

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

import edu.kh.semi.board.model.service.InsertBoardService;
import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Category;
import edu.kh.semi.common.MyFileRenamePolicy;
import edu.kh.semi.member.model.vo.ComMember;

/**
 * @author 함나현 hammcoder@gmail.com
 *
 */
@WebServlet("/board2/*")
public class InsertBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		String contextPath = request.getContextPath();
		
		String command = uri.substring((contextPath + "/board2/").length());
		
		String path = null;
		RequestDispatcher view = null;
		
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			InsertBoardService service = new InsertBoardService();
			
			int cp = request.getParameter("cp") == null ? 1 :
				Integer.parseInt(request.getParameter("cp"));
			
			if(command.equals("insertForm")) {
				List<Category> category = service.selectCategoryList();
				
				request.setAttribute("category", category);
				
				path = "/WEB-INF/views/board/posting.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			else if(command.equals("insert")) {
				int boardType = Integer.parseInt(request.getParameter("type"));
				
				HttpSession session = request.getSession();
				int memberNo = ((ComMember)session.getAttribute("comLoginMember")).getMemberNo();
				int memberNo2 = ((ComMember)session.getAttribute("freLoginMember")).getMemberNo();
				
				System.out.println(boardType);
				System.out.println(memberNo);
				System.out.println(memberNo2);

				int maxSize = 1024 * 1024 * 20; 
				
				String root = session.getServletContext().getRealPath("/");
				System.out.println("root : " + root);
				
				String filePath = "resources/images/";
				
				switch(boardType) {
				case 1 : filePath += "freboard/"; break; 
				case 2 : filePath += "comboard/"; break; 
				}
				
				System.out.println("실제 저장경로 : " + root + filePath);
				
				MultipartRequest mpRequest
				= new MultipartRequest(request, root+filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
				List<Attachment> atList = new ArrayList<Attachment>();
				
				Enumeration<String> images = mpRequest.getFileNames();
				
				while(images.hasMoreElements()) {
					String name = images.nextElement();
					System.out.println("name : " + name);
					
					System.out.println("변경 된 파일 명 : " + mpRequest.getFilesystemName(name));
					System.out.println("변경 전 파일 명 : " + mpRequest.getOriginalFileName(name));
					
					if(mpRequest.getFilesystemName(name) != null) {
						Attachment at = new Attachment();
						
						at.setFilePath(filePath);
						at.setFileNM(mpRequest.getFilesystemName(name) );
						at.setFileLevel(Integer.parseInt(name.substring("img".length())));
					
						atList.add(at);
					}
				}
				for(Attachment a: atList) {
					System.out.println(a);
				}
				
				String boardTitle = mpRequest.getParameter("boardTitle");
				String boardContent = mpRequest.getParameter("boardContent");
				int categoryCode = Integer.parseInt(mpRequest.getParameter("categoryCode"));
				
				
				Board board = new Board();
				board.setBoardTitle(boardTitle);
				board.setBoardContent(boardContent);
				// board.setCategoryCode(categoryCode);
				// board.setMemberNo(memberNo);
				
				
				int result = service.insertBoard(board, atList, boardType);
				
				if(result > 0) {
					System.out.println(result);
					icon = "success";
					title = "게시글 등록 성공";
					path = "../board/view?no=" + result + "&cp=1&type=" + boardType;
					
				}else {
					icon = "error";
					title = "게시글 등록 실패";
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
