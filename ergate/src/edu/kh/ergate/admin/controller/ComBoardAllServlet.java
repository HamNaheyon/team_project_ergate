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
import edu.kh.ergate.admin.model.vo.AdminQuestion;
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
				//------------검색 추가---------------
				Pagination pagination=null;
				List<adminBoard> adminBoardList =null;
				
				if(request.getParameter("sv")==null) {
					pagination = service.getPagination(cp,boardTypeNo);
					
					adminBoardList = service.selectBoardList(pagination);
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					
					pagination = service.getPagination(cp,boardTypeNo,searchKey,searchValue);
					adminBoardList = service.selectBoardList(pagination,searchKey,searchValue);
					
				}
				
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminBoardList", adminBoardList);
				
				path ="/WEB-INF/views/admin/ComBoardAll.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}else if(command.equals("ComBoardB")) {
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				//------------검색 추가---------------
				Pagination pagination=null;
				List<adminBoard> adminBoardList =null;
				
				if(request.getParameter("sv")==null) {
					pagination = service.getPagination(cp,boardTypeNo);
					
					adminBoardList = service.selectBoardList(pagination);
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					
					pagination = service.getPagination(cp,boardTypeNo,searchKey,searchValue);
					adminBoardList = service.selectBoardList(pagination,searchKey,searchValue);
					
				}
				
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminBoardList", adminBoardList);
				
				path ="/WEB-INF/views/admin/ComBoardB.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}else if(command.equals("ComMemberAll")) {
				String memberGrade =request.getParameter("type");
				
				//------------검색 추가---------------
				Pagination pagination=null;
				List<adminMember> adminMemberList =null;
				
				if(request.getParameter("sv")==null) {
					pagination = service.getMemPagination(cp,memberGrade);
					
					adminMemberList = service.selectMember(pagination);	
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					
					pagination = service.getMemPagination(cp,memberGrade,searchKey,searchValue);
					adminMemberList = service.selectMember(pagination,searchKey,searchValue);
					
				}
				
				
				
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				request.getRequestDispatcher("/WEB-INF/views/admin/ComMemberAll.jsp").forward(request, response);
			}else if(command.equals("ComMemberDel")) {
				String memberGrade =request.getParameter("type");
				//------------검색 추가---------------
				Pagination pagination=null;
				List<adminMember> adminMemberList =null;
				
				if(request.getParameter("sv")==null) {
					pagination = service.getMemPagination(cp,memberGrade);
					
					adminMemberList = service.selectMember(pagination);	
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					
					pagination = service.getMemPagination(cp,memberGrade,searchKey,searchValue);
					adminMemberList = service.selectMember(pagination,searchKey,searchValue);
					
				}	
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
				//------------검색 추가---------------
				Pagination pagination=null;
				List<adminBoard> adminBoardList =null;
				
				if(request.getParameter("sv")==null) {
					pagination = service.getPagination(cp,boardTypeNo);
					
					adminBoardList = service.selectBoardList(pagination);
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					
					pagination = service.getPagination(cp,boardTypeNo,searchKey,searchValue);
					adminBoardList = service.selectBoardList(pagination,searchKey,searchValue);
					
				}
				
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminBoardList", adminBoardList);
				
				request.getRequestDispatcher("/WEB-INF/views/admin/FreBoardAll.jsp").forward(request, response);
			}else if(command.equals("freBoardB")) {
				int boardTypeNo = Integer.parseInt(request.getParameter("type"));
				//------------검색 추가---------------
				Pagination pagination=null;
				List<adminBoard> adminBoardList =null;
				
				if(request.getParameter("sv")==null) {
					pagination = service.getPagination(cp,boardTypeNo);
					
					adminBoardList = service.selectBoardList(pagination);
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					
					pagination = service.getPagination(cp,boardTypeNo,searchKey,searchValue);
					adminBoardList = service.selectBoardList(pagination,searchKey,searchValue);
					
				}

				request.setAttribute("pagination", pagination);
				request.setAttribute("adminBoardList", adminBoardList);
				
				request.getRequestDispatcher("/WEB-INF/views/admin/FreBoardB.jsp").forward(request, response);
			}else if(command.equals("freMemberAll")) {
				String memberGrade =request.getParameter("type");
				//------------검색 추가---------------
				Pagination pagination=null;
				List<adminMember> adminMemberList =null;
				
				if(request.getParameter("sv")==null) {
					pagination = service.getMemPagination2(cp,memberGrade);
					
					adminMemberList = service.selectMember2(pagination);	
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					
					pagination = service.getMemPagination2(cp,memberGrade,searchKey,searchValue);
					
					adminMemberList = service.selectMember2(pagination,searchKey,searchValue);
					
				}	
					
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
				request.getRequestDispatcher("/WEB-INF/views/admin/FreMemberAll.jsp").forward(request, response);
			}else if(command.equals("freMemberDel")) {
				String memberGrade =request.getParameter("type");
				//------------검색 추가---------------
				Pagination pagination=null;
				List<adminMember> adminMemberList =null;
				
				if(request.getParameter("sv")==null) {
					pagination = service.getMemPagination2(cp,memberGrade);
					
					adminMemberList = service.selectMember2(pagination);	
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					
					pagination = service.getMemPagination2(cp,memberGrade,searchKey,searchValue);
					
					adminMemberList = service.selectMember2(pagination,searchKey,searchValue);
					
				}	
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
				response.sendRedirect(request.getContextPath());
			}else if(command.equals("qusetions")) {
				Pagination pagination=null;
				List<AdminQuestion> adminMemberList=null;
				if(request.getParameter("sv")==null) {
					pagination = service.getQuestionPagination(cp);
					adminMemberList = service.selectQuestion(pagination);
				}else {// 검색어가 있을 경우
					String searchKey = request.getParameter("sk");
					String searchValue = request.getParameter("sv");
					pagination = service.getQuestionPagination(cp,searchKey,searchValue);
					adminMemberList = service.selectQuestion(pagination,searchKey,searchValue);
					
					
				}	
			
				request.setAttribute("pagination", pagination);
				request.setAttribute("adminMemberList", adminMemberList);
			    request.getRequestDispatcher("/WEB-INF/views/admin/qusetions.jsp").forward(request, response);
			}
			else if(command.equals("qSel")) {
				int qNo = Integer.parseInt(request.getParameter("questionNo"));
				AdminQuestion aq = service.selectQuestionView(qNo);
				request.setAttribute("aq", aq);
				request.getRequestDispatcher("/WEB-INF/views/admin/qusetionsSel.jsp").forward(request, response);
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
