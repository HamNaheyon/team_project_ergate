package edu.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.service.MemberService;
import edu.kh.semi.member.model.vo.ComMember;
import edu.kh.semi.member.model.vo.FreMember;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String freId = null;
		String frePw = null;
		String comId = null;
		String comPw = null;
		
		if(request.getParameter("freId") != null) {
			freId = request.getParameter("freId");
			frePw = request.getParameter("frePw");
		}else {
			comId = request.getParameter("comId");
			comPw = request.getParameter("comPw");
		}
		
		
		
		
		try {
			
			HttpSession session = request.getSession();
			
			MemberService service = new MemberService();
			
			FreMember freLoginMember = null;
			
			ComMember comLoginMember = null;
			
			if(freId != null) {
				freLoginMember = service.freLogin(freId,frePw);
			}else {
				comLoginMember = service.comLogin(comId,comPw);
				
			}
			
			session.removeAttribute("icon");
			session.removeAttribute("title");
			session.removeAttribute("text");
			if(freLoginMember == null) {
				session.setAttribute("icon", "error"); // success, warning, error,
				session.setAttribute("title", "로그인 실패");
				session.setAttribute("text","아이디 또는 비밀번호가 일치하지 않습니다.");
				
			} else if(freLoginMember.getMemberGrade().equals("A")) {
				String path="/WEB-INF/views/admin/adminmain.jsp";
	            RequestDispatcher view = request.getRequestDispatcher(path);
	            view.forward(request, response);
			}else if(freLoginMember != null) {
				session.setAttribute("freLoginMember",freLoginMember );
				/* response.sendRedirect(request.getContextPath()); */
				response.sendRedirect( request.getHeader("referer") );
			}
			
			session.removeAttribute("icon");
			session.removeAttribute("title");
			session.removeAttribute("text");
			if(freLoginMember == null) {
				if(comLoginMember ==null) {
					session.setAttribute("icon", "error"); // success, warning, error,
					session.setAttribute("title", "로그인 실패");
					session.setAttribute("text","아이디 또는 비밀번호가 일치하지 않습니다.");
					
				}
				else if(comLoginMember.getMemberGrade().equals("A")) {
					String path="/WEB-INF/views/admin/adminmain.jsp";
		            RequestDispatcher view = request.getRequestDispatcher(path);
		            view.forward(request, response);
				}else if(comLoginMember != null) {
					session.setAttribute("comLoginMember",comLoginMember );
					/* response.sendRedirect(request.getContextPath()); */
					response.sendRedirect( request.getHeader("referer") );
				}
			}
			if(freLoginMember == null && comLoginMember == null)
			response.sendRedirect(request.getContextPath());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}