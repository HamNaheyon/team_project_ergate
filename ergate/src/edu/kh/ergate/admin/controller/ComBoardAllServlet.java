package edu.kh.ergate.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.ergate.admin.model.service.adminBoardService;
import edu.kh.ergate.admin.model.vo.Pagination;
import edu.kh.ergate.admin.model.vo.adminBoard;
import edu.kh.ergate.admin.model.vo.adminMember;



@WebServlet("/admin/*")
public class ComBoardAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();// 요청 주소                   // /ergate/admin/ComboardAll
		System.out.println(uri);
		String contextPath = request.getContextPath();// 최상위 주소 // /ergate
		String command = uri.substring((contextPath+"/admin/").length());//list
		System.out.println(command);
		String path= null; //응답화면 주소 또는 경로
		RequestDispatcher view = null; //요청 위임 객체 저장 참조 변수
		
		//sweetalert용 변수
		String icon =null;
		String title =null;
		String text = null;
		
		try {
			adminBoardService service = new adminBoardService();
			int cp =request.getParameter("cp")== null ? 1 : 
				Integer.parseInt(request.getParameter("cp"));
			System.out.println(cp);
			if(command.equals("ComBoardAll")) {
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				Pagination pagination = service.getPagination(cp,boardTypeNo);
				
				List<adminBoard> adminBoardList = service.selectBoardList(pagination);
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminBoardList", adminBoardList);
				
				path ="/WEB-INF/views/admin/ComBoardAll.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}else if(command.equals("ComBoardB")) {
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				Pagination pagination = service.getPagination(cp,boardTypeNo);
				System.out.println(pagination);
				List<adminBoard> adminBoardList = service.selectBoardList(pagination);
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminBoardList", adminBoardList);
				
				path ="/WEB-INF/views/admin/ComBoardB.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}else if(command.equals("ComMemberAll")) {
				String memberGrade =request.getParameter("type");
				Pagination pagination = service.getMemPagination(cp,memberGrade);
				
				List<adminMember> adminMemberList = service.selectMember(pagination);	
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				request.getRequestDispatcher("/WEB-INF/views/admin/ComMemberAll.jsp").forward(request, response);
			}else if(command.equals("ComMemberDel")) {
				String memberGrade =request.getParameter("type");
				Pagination pagination = service.getMemPagination(cp,memberGrade);
				List<adminMember> adminMemberList = service.selectMember(pagination);	
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				request.getRequestDispatcher("/WEB-INF/views/admin/ComMemberDel.jsp").forward(request, response);
			}else if(command.equals("ComMemberSel")) {
				int memberNo = Integer.parseInt(request.getParameter("memberNo"));
				adminMember adminMember = service.adminSel(memberNo);
				request.setAttribute("adminMember", adminMember);
				request.getRequestDispatcher("/WEB-INF/views/admin/ComMemberSel.jsp").forward(request, response);
			
			
			}else if(command.equals("freBoardAll")) {
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				Pagination pagination = service.getPagination(cp,boardTypeNo);
				
				List<adminBoard> adminBoardList = service.selectBoardList(pagination);
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminBoardList", adminBoardList);
				
				request.getRequestDispatcher("/WEB-INF/views/admin/FreBoardAll.jsp").forward(request, response);
			}else if(command.equals("freBoardB")) {
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				Pagination pagination = service.getPagination(cp,boardTypeNo);
				System.out.println(pagination);
				List<adminBoard> adminBoardList = service.selectBoardList(pagination);
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminBoardList", adminBoardList);
				
				request.getRequestDispatcher("/WEB-INF/views/admin/FreBoardB.jsp").forward(request, response);
			}else if(command.equals("freMemberAll")) {
				String memberGrade =request.getParameter("type");
				Pagination pagination = service.getMemPagination2(cp,memberGrade);
				
				List<adminMember> adminMemberList = service.selectMember2(pagination);	
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				request.getRequestDispatcher("/WEB-INF/views/admin/FreMemberAll.jsp").forward(request, response);
			}else if(command.equals("freMemberDel")) {
				String memberGrade =request.getParameter("type");
				Pagination pagination = service.getMemPagination2(cp,memberGrade);
				List<adminMember> adminMemberList = service.selectMember2(pagination);	
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				request.getRequestDispatcher("/WEB-INF/views/admin/FreMemberDel.jsp").forward(request, response);
			}else if(command.equals("FreMemberSel")) {
				int memberNo = Integer.parseInt(request.getParameter("memberNo"));
				adminMember adminMember = service.adminSel2(memberNo);
				request.setAttribute("adminMember", adminMember);
				request.getRequestDispatcher("/WEB-INF/views/admin/FreMemberSel.jsp").forward(request, response);
			}else if(command.equals("logout")) {
				request.getSession().invalidate();
				request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			adminBoardService service = new adminBoardService();
//			List<adminBoard> adminBoardList = service.selectComBoardList();
//			request.setAttribute("adminBoardList", adminBoardList);
//			System.out.println(adminBoardList);
//			request.getRequestDispatcher("/WEB-INF/views/admin/ComBoardAll.jsp").forward(request, response);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
