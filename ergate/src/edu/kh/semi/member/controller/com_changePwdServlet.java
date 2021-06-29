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

@WebServlet("/member/com_changePwd")
public class com_changePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/com_changePwd.jsp");
		
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPwd = request.getParameter("currentPwd");
		String newPwd1 = request.getParameter("newPwd1");
		
		System.out.println(currentPwd);
		
		HttpSession session = request.getSession();
		
		ComMember comLoginMember = (ComMember)session.getAttribute("loginMember");
		
		int comNo = comLoginMember.getMemberNo();
		
		String comPw = comLoginMember.getComPw();
		
		try {
			
			int result = new MemberService().comChangePwd(currentPwd, newPwd1, comNo);
			
			if(currentPwd.equals(comPw) ) {
				
				session.setAttribute("icon","warning");
				session.setAttribute("title", "현재 비밀번호가 같지 않습니다.");	
				
			}else if(result>0) {
				
				session.setAttribute("icon", "success"); 
				session.setAttribute("title", "비밀번호 변경 성공");	
				
			}else {
				
				session.setAttribute("icon", "error"); 
				session.setAttribute("title", "비밀번호 변경 실패");	
				
			}
			
			response.sendRedirect("myPage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
