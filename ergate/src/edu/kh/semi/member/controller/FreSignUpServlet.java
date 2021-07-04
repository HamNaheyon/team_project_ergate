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
import edu.kh.semi.member.model.vo.FreMember;

@WebServlet("/member/fre_signUp_Required")
public class FreSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/fre_signUp_Required.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String freId = request.getParameter("id");
		String frePw = request.getParameter("pwd1");
		String freName = request.getParameter("name");
		String freEmail = request.getParameter("email");
		String[] phone = request.getParameterValues("phone");
		String frePhone = String.join("-", phone);
		
		String minTime = request.getParameter("time1");
		String maxTime = request.getParameter("time2");
		
		String minSalary = request.getParameter("salary1");
		String maxSalary = request.getParameter("salary2");
		
		String feild = request.getParameter("feild");
		String work = request.getParameter("work");
		String experience = request.getParameter("experience");
		String skil = request.getParameter("skil");
		String gender = request.getParameter("gender");
		String[] jumin = request.getParameterValues("juminNum");
		String juminNum = String.join("-", jumin);
		
		FreMember freMember = new FreMember(freId, frePw, freName, frePhone, freEmail, minTime, maxTime, minSalary, maxSalary, feild, work, experience, skil, gender, juminNum);
		
		HttpSession session = request.getSession();
		try {
			
			MemberService service = new MemberService();
			
			int result = service.freSignUp(freMember);
			
			
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
