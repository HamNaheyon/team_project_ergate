package edu.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.service.MemberService;
import edu.kh.semi.member.model.vo.FreMember;

@WebServlet("/member/fre_secession")
public class FreSecessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/member/fre_secession.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		FreMember freLoginMember = (FreMember)session.getAttribute("freLoginMember");
		
		int freNo = freLoginMember.getMemberNo();
		String frePw = request.getParameter("currentPwd");
		
		try {
			
			int result = new MemberService().freSecession(freNo,frePw);
			
			String path = null;
			String icon = null;
			String title = null;
			String text = null;
			
			if (result > 0) { 
				icon = "success";
				title = "회원 탈퇴 성공";
				text = "이용해 주셔서 감사합니다.";

				path = request.getContextPath();
				session.invalidate();
				
			} else {
				icon = "error";
				title = "회원 탈퇴 실패";
				text = "비밀번호가 일치하지 않습니다.";
				
				path = "fre_secession";
			}
			
			session = request.getSession();
			
			session.setAttribute("icon", icon);
			session.setAttribute("title", title);
			session.setAttribute("text", text);

			response.sendRedirect(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
