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
import edu.kh.semi.member.model.vo.FreMember;

@WebServlet("/member/fre_update")
public class FreUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		FreMember freLoginMember = (FreMember)session.getAttribute("freLoginMember");
				
		int memberNo = freLoginMember.getMemberNo();
		
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
		
		
		FreMember freMember = new FreMember(memberNo, frePhone, freEmail, minTime, maxTime, minSalary, maxSalary, feild, work, experience,skil);		
		try {
			MemberService service = new MemberService();
			
			int result = service.updateFreMember(freMember);
			
			System.out.println(result);
			if(result > 0) {
				session.setAttribute("icon", "success"); // success, warning, error, info
				session.setAttribute("title", "수정 성공");	
				session.setAttribute("text", "회원 정보 수정에 성공하였습니다");	
				
				freLoginMember.setMemberPhone(frePhone);
				freLoginMember.setMemberEmail(freEmail);
				freLoginMember.setMinTime(minTime);
				freLoginMember.setMaxTime(maxTime);
				freLoginMember.setMinSalary(minSalary);
				freLoginMember.setMaxSalary(maxSalary);
				freLoginMember.setFeild(feild);
				freLoginMember.setWork(work);
				freLoginMember.setExperience(experience);
				freLoginMember.setSkil(skil);
				
			}else {
				session.setAttribute("icon", "error"); // success, warning, error, info
				session.setAttribute("title", "수정 실패");	
				session.setAttribute("text", "회원 정보 수정에 실패하였습니다.");	
			}
			
			response.sendRedirect("fre_myPage");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
