package edu.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpsConfigurator;

import edu.kh.semi.member.model.service.MemberService;
import edu.kh.semi.member.model.vo.ComMember;

@WebServlet("/member/com_update")
public class ComUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ComMember comLoginMember = (ComMember)session.getAttribute("comLoginMember");
				
		int memberNo = comLoginMember.getMemberNo();
		
		String comEmail = request.getParameter("email");
		String[] phone = request.getParameterValues("phone");
		String comPhone = String.join("-", phone);
		
		
		ComMember comMember = new ComMember(memberNo,comEmail,comPhone);		
		try {
			MemberService service = new MemberService();
			
			int result = service.updateComMember(comMember);
			
			
			if(result > 0) {
				session.setAttribute("icon", "success"); // success, warning, error, info
				session.setAttribute("title", "수정 성공");	
				session.setAttribute("text", "회원 정보 수정에 성공하였습니다");	

				comLoginMember.setComPhone(comPhone);
				comLoginMember.setComEmail(comEmail);
			}else {
				session.setAttribute("icon", "error"); // success, warning, error, info
				session.setAttribute("title", "수정 실패");	
				session.setAttribute("text", "회원 정보 수정에 실패하였습니다.");	
			}
			
			response.sendRedirect( "com_myPage" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
