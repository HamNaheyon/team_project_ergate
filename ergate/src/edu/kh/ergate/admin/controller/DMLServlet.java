package edu.kh.ergate.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.ergate.admin.model.service.DMLService;
import edu.kh.ergate.admin.model.service.adminBoardService;
import edu.kh.ergate.admin.model.vo.Pagination;

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
