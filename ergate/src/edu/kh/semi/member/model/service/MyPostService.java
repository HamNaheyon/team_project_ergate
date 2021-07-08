package edu.kh.semi.member.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static edu.kh.semi.common.JDBCTemplate.*;

import edu.kh.semi.member.model.dao.MyPostDAO;
import edu.kh.semi.member.model.vo.MemberBoard;
import edu.kh.semi.member.model.vo.MyPostPagination;
import edu.kh.semi.member.model.vo.Question;

public class MyPostService {

	private MyPostDAO dao = new MyPostDAO();
	
	/** 내 게시글 페이징 처리 객체 생성용 Service
	 * @param cp
	 * @param memberNo 
	 * @return pagination
	 * @throws Exception
	 */
	public MyPostPagination getPagination(int cp, int memberNo)throws Exception {
		
		Connection conn = getConnection();
		
		Map<String,Object> map = dao.getListCount(conn,cp, memberNo);
		
		close(conn);
		
		int listCount = map.get("listCount") != null ? (int)map.get("listCount") : 0;
		
		String boardName = (String)map.get("boardName");
		
		return new MyPostPagination(cp, listCount, boardName);
	}
	
	/** 내 문의 사페이징 처리 객체 생성용 Service
	 * @param cp
	 * @param memberNo 
	 * @return pagination
	 * @throws Exception
	 */
	public MyPostPagination getQuestionPagination(int cp, int memberNo)throws Exception {
		
		Connection conn = getConnection();
		
		Map<String,Object> map = dao.getQuestionPagination(conn,cp, memberNo);
		
		close(conn);
		
		int listCount = (int)map.get("listCount");
		
		return new MyPostPagination(cp, listCount);
	}

	/** 게시글 목록 조회 Service
	 * @param pagination
	 * @param memberNo 
	 * @return boardList
	 * @throws Exception
	 */
	public List<MemberBoard> boardList(MyPostPagination pagination, int memberNo)throws Exception {
		
		Connection conn = getConnection();
		
		List<MemberBoard> boardList = dao.boardList(conn,pagination,memberNo);
		
		close(conn);
		
		return boardList;
	}

	/** 내 문의 사항 조회 Service
	 * @param pagination
	 * @param memberNo
	 * @return questionList
	 * @throws Exception
	 */
	public List<Question> QuestionList(MyPostPagination pagination, int memberNo)throws Exception {
		
		Connection conn = getConnection();
		
		List<Question> questionList = dao.QuestionList(conn,pagination,memberNo);
		
		close(conn);
		
		return questionList;
	}

	/** 내 문의사항 상세 조회 Service
	 * @param questionNo
	 * @return
	 * @throws Exception
	 */
	public Question selectQuestion(int questionNo)throws Exception {

		Connection conn = getConnection();
		
		Question question = dao.selectQuestion(conn,questionNo);
		
		close(conn);
		
		return question;
	}

}
