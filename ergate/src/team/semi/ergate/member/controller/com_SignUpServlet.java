package team.semi.ergate.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.semi.ergate.member.model.service.MemberService;
import team.semi.ergate.member.model.vo.ComMember;
import team.semi.ergate.member.model.vo.FreMember;

@WebServlet("/member/com_signUp")
public class com_SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/com_signUp.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comId = request.getParameter("id");
		String comPw = request.getParameter("pwd1");
		String comEmail = request.getParameter("email");
		String[] phone = request.getParameterValues("phone");
		String comPhone = String.join("-", phone);
		String manager = request.getParameter("manager");
		String companyName = request.getParameter("company");
		String companyNo = request.getParameter("companyNo");
				
		String[] jumin = request.getParameterValues("juminNum");
		String juminNum = String.join("-", jumin);
		
		ComMember comMember = new ComMember(comId, comPw, comPhone, comEmail, juminNum, manager, companyName, companyNo);
				
		HttpSession session = request.getSession();
		try {
			
			MemberService service = new MemberService();
			
			int result = service.comSignUp(comMember);
			
			
			if(result > 0) {
				session.setAttribute("icon", "success"); // success, warning, error, info
				session.setAttribute("title", "회원가입 성공");
			}else {
				session.setAttribute("icon", "erroe"); // success, warning, error, info
				session.setAttribute("title", "회원가입 실패");
			}
			
			response.sendRedirect(request.getContextPath());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}


}
