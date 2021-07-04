package edu.kh.ergate.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.ergate.admin.model.service.DMLService;
import edu.kh.ergate.admin.model.service.adminBoardService;
import edu.kh.ergate.admin.model.vo.Pagination;
import edu.kh.ergate.admin.model.vo.adminBoard;
import edu.kh.ergate.admin.model.vo.adminMember;

/**
 * Servlet implementation class DMLServlet
 */
@WebServlet("/admin2/*")
public class DMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();// 요청 주소                   // /ergate/admin/ComboardAll
		System.out.println(uri);
		String contextPath = request.getContextPath();// 최상위 주소 // /ergate
		String command = uri.substring((contextPath+"/admin2/").length());//list
		System.out.println(command);
		String path= null; //응답화면 주소 또는 경로
		RequestDispatcher view = null; //요청 위임 객체 저장 참조 변수
		
		//sweetalert용 변수
		String icon =null;
		String title =null;
		String text = null;
		try {
			DMLService service = new DMLService();
			System.out.println("cp"+request.getParameter("cp"));
			int cp =request.getParameter("cp")== null ? 1 : 
				Integer.parseInt(request.getParameter("cp"));
			if(command.equals("comDel")) {
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				
				int result = service.boardDel(boardNo,boardTypeNo);
				if(result>0) {
					icon="success";
					title="블라인드 성공";
				}
				else {
					icon="error";
					title="블라인드 실패";
				}
				
				Pagination pagination = new adminBoardService().getPagination(cp,boardTypeNo);
				List<adminBoard> adminBoardList = new adminBoardService().selectBoardList(pagination);
				
				HttpSession session = request.getSession();
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				session.setAttribute("pagination", pagination);
				session.setAttribute("adminBoardList", adminBoardList);
				
				response.sendRedirect(request.getContextPath()+"/admin/ComBoardB?type=2&cp="+cp);
				
			}
			else if(command.equals("comRe")) {
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				
				int result = service.boardRe(boardNo,boardTypeNo);
				if(result>0) {
					icon="success";
					title="블라인드 복구 성공";
				}
				else {
					icon="error";
					title="블라인드 복구 실패";
				}
				
				Pagination pagination = new adminBoardService().getPagination(cp,boardTypeNo);
				List<adminBoard> adminBoardList = new adminBoardService().selectBoardList(pagination);
				
				HttpSession session = request.getSession();
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				session.setAttribute("pagination", pagination);
				session.setAttribute("adminBoardList", adminBoardList);
				
				response.sendRedirect(request.getContextPath()+"/admin/ComBoardB?type=2&cp="+cp);
			}
			else if(command.equals("comMemDel")) {
				int memberNo = Integer.parseInt(request.getParameter("memberNo"));
				String memberGrade =request.getParameter("type");
				
				int result = service.memberDel(memberNo);
				if(result>0) {
					icon="success";
					title="회원 탈퇴 성공";
				}
				else {
					icon="error";
					title="회원 탈퇴 실패";
				}
				
				
				Pagination pagination = new adminBoardService().getMemPagination(cp,memberGrade);
				
				List<adminMember> adminMemberList = new adminBoardService().selectMember(pagination);	
				HttpSession session = request.getSession();
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				
				response.sendRedirect(request.getContextPath()+"/admin/ComMemberDel?type=G&cp="+cp);
			}
			else if(command.equals("comMemRe")) {
				int memberNo = Integer.parseInt(request.getParameter("memberNo"));
				String memberGrade =request.getParameter("type");
				
				int result = service.memberRe(memberNo);
				if(result>0) {
					icon="success";
					title="회원 복구 성공";
				}
				else {
					icon="error";
					title="회원 복구 실패";
				}
				
				
				Pagination pagination = new adminBoardService().getMemPagination(cp,memberGrade);
				
				List<adminMember> adminMemberList = new adminBoardService().selectMember(pagination);	
				HttpSession session = request.getSession();
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				
				response.sendRedirect(request.getContextPath()+"/admin/ComMemberDel?type=G&cp="+cp);
			}
			else if(command.equals("freDel")) {
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				System.out.println("freDel:   "+boardTypeNo);
				int result = service.boardDel(boardNo,boardTypeNo);
				if(result>0) {
					icon="success";
					title="블라인드 성공";
				}
				else {
					icon="error";
					title="블라인드 실패";
				}
				
				Pagination pagination = new adminBoardService().getPagination(cp,boardTypeNo);
				System.out.println("pagination :   "+pagination);
				List<adminBoard> adminBoardList = new adminBoardService().selectBoardList(pagination);
				System.out.println("adminBoardList :   "+adminBoardList);
				HttpSession session = request.getSession();
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				session.setAttribute("pagination", pagination);
				session.setAttribute("adminBoardList", adminBoardList);
				
				response.sendRedirect(request.getContextPath()+"/admin/freBoardB?type=1&cp="+cp);
				
			}
			else if(command.equals("freRe")) {
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				
				int result = service.boardRe(boardNo,boardTypeNo);
				if(result>0) {
					icon="success";
					title="블라인드 복구 성공";
				}
				else {
					icon="error";
					title="블라인드 복구 실패";
				}
				
				Pagination pagination = new adminBoardService().getPagination(cp,boardTypeNo);
				List<adminBoard> adminBoardList = new adminBoardService().selectBoardList(pagination);
				
				HttpSession session = request.getSession();
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				session.setAttribute("pagination", pagination);
				session.setAttribute("adminBoardList", adminBoardList);
				
				response.sendRedirect(request.getContextPath()+"/admin/freBoardB?type=1&cp="+cp);
			}
			else if(command.equals("freMemDel")) {
				int memberNo = Integer.parseInt(request.getParameter("memberNo"));
				String memberGrade =request.getParameter("type");
				
				int result = service.memberDel(memberNo);
				if(result>0) {
					icon="success";
					title="회원 탈퇴 성공";
				}
				else {
					icon="error";
					title="회원 탈퇴 실패";
				}
				
				
				Pagination pagination = new adminBoardService().getMemPagination2(cp,memberGrade);
				
				List<adminMember> adminMemberList = new adminBoardService().selectMember2(pagination);	
				System.out.println("adminMemberList ::::::"+adminMemberList);
				HttpSession session = request.getSession();
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				
				response.sendRedirect(request.getContextPath()+"/admin/freMemberDel?type=F&cp="+cp);
			}
			else if(command.equals("freMemRe")) {
				int memberNo = Integer.parseInt(request.getParameter("memberNo"));
				String memberGrade =request.getParameter("type");
				
				int result = service.memberRe(memberNo);
				if(result>0) {
					icon="success";
					title="회원 복구 성공";
				}
				else {
					icon="error";
					title="회원 복구 실패";
				}
				
				
				Pagination pagination = new adminBoardService().getMemPagination2(cp,memberGrade);
				
				List<adminMember> adminMemberList = new adminBoardService().selectMember2(pagination);	
				HttpSession session = request.getSession();
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				
				response.sendRedirect(request.getContextPath()+"/admin/freMemberDel?type=F&cp="+cp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
