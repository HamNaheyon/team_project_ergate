package edu.kh.semi.boardTwo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.semi.boardTwo.model.service.BoardTwoService;

@WebServlet("/BoardTwo/*")
public class BoardTwoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();  			
		String contextPath = request.getContextPath(); 	
		String command = uri.substring((contextPath).length()+1); 
		String path = null; 
		RequestDispatcher view = null; 
		
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			BoardTwoService service = new BoardTwoService();
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
