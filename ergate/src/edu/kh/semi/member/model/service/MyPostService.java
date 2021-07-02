package edu.kh.semi.member.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static edu.kh.semi.common.JDBCTemplate.*;

import edu.kh.semi.member.model.dao.MyPostDAO;
import edu.kh.semi.member.model.vo.MemberBoard;
import edu.kh.semi.member.model.vo.MyPostPagination;

public class MyPostService {

	private MyPostDAO dao = new MyPostDAO();
	
	/** 페이징 처리 객체 생성용 Service
	 * @param cp
	 * @param memberNo 
	 * @return pagination
	 * @throws Exception
	 */
	public MyPostPagination getPagination(int cp, int memberNo)throws Exception {
		
		Connection conn = getConnection();
		
		Map<String,Object> map = dao.getListCount(conn,cp, memberNo);
		
		close(conn);
		
		int listCount = (int)map.get("listCount");
		String boardName = (String)map.get("boardName");
		
		return new MyPostPagination(cp, listCount, boardName);
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

}
