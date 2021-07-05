package edu.kh.ergate.admin.model.service;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.ergate.admin.model.dao.adminBoardDAO;
import edu.kh.ergate.admin.model.vo.AdminQuestion;
import edu.kh.ergate.admin.model.vo.Pagination;
import edu.kh.ergate.admin.model.vo.adminBoard;
import edu.kh.ergate.admin.model.vo.adminMember;

import static edu.kh.ergate.common.JDBCTemplate.*;

public class adminBoardService {

	private adminBoardDAO dao = new adminBoardDAO();

	/** 기업게시판 전체 조회
	 * @return adminBoardList
	 * @throws Exception
	 */
	public List<adminBoard> selectComBoardList() throws Exception{
		
		Connection conn = getConnection();
		List<adminBoard> adminBoardList = dao.selectComBoardList(conn);
		close(conn);
		return adminBoardList;
	}

	/** 기업게시판 전체 조회 페이징처리
	 * @param cp
	 * @param boardTypeNo
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp, int boardTypeNo) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Map<String,Object> map = dao.getPagination(conn,cp,boardTypeNo);
		close(conn);
		int listCount = map.get("listCount") != null ? (int)map.get("listCount") : 0;

		return new Pagination(cp, listCount, boardTypeNo);
	}
	/**기업 회원 전체 조회 페이징 처리
	 * @param cp
	 * @param memberGrade
	 * @return
	 * @throws Exception
	 */
	public Pagination getMemPagination(int cp, String memberGrade)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int map = dao.getMemPagination(conn,cp,memberGrade);
		close(conn);
		int listCount = map;
		return new Pagination(cp,listCount,memberGrade);
	}

	/** 기업게시판 전체 목록 조회
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<adminBoard> selectBoardList(Pagination pagination)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		List<adminBoard> adminBoardList = dao.selectBoardList(conn,pagination);
		close(conn);
		return adminBoardList;
	}

	/**기업 회원 전체 목록 조회 
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<adminMember> selectMember(Pagination pagination)throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		List<adminMember> adminMemberList = dao.selectMember(conn,pagination);
		close(conn);
		return adminMemberList;
	}

	/**기업 상세조회 정보 
	 * @param memberNo
	 * @return adminMember
	 * @throws Exception
	 */
	public adminMember adminSel(int memberNo) throws Exception{
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		adminMember adminMember = dao.adminSel(conn,memberNo);
		close(conn);
		return adminMember;
	}

	/**회원 전체 조회 2
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<adminMember> selectMember2(Pagination pagination)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		List<adminMember> adminMemberList = dao.selectMember2(conn,pagination);
		close(conn);
		return adminMemberList;
	}

	public Pagination getMemPagination2(int cp, String memberGrade) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int map = dao.getMemPagination2(conn,cp,memberGrade);
		close(conn);
		int listCount = map;
		return new Pagination(cp,listCount,memberGrade);
	}

	public adminMember adminSel2(int memberNo)throws Exception {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		adminMember adminMember = dao.adminSel2(conn,memberNo);
		close(conn);
		return adminMember;
	}

	public Pagination getQuestionPagination(int cp) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int map = dao.getQuestionPagination(conn,cp);
		close(conn);
		int listCount = map;
		return new Pagination(cp,listCount);
	}

	public List<AdminQuestion> selectQuestion(Pagination pagination)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		List<AdminQuestion> adminBoardList = dao.selectQuestion(conn,pagination);
		close(conn);
		return adminBoardList;
	}

	public AdminQuestion selectQuestionView(int qNo) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		AdminQuestion aq = dao.selectQuestionView(conn,qNo);
		close(conn);
		return aq;
	}

	
	public Pagination getPagination(int cp, int boardTypeNo,String searchKey,String searchValue) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String condition = createCondition(searchKey, searchValue);
		Map<String,Object> map = dao.getPagination(conn,cp,boardTypeNo,condition);
		close(conn);
		int listCount = map.get("listCount") != null ? (int)map.get("listCount") : 0;

		return new Pagination(cp, listCount, boardTypeNo);
	}
	public List<adminBoard> selectBoardList(Pagination pagination,String searchKey,String searchValue)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String condition = createCondition(searchKey, searchValue);
		List<adminBoard> adminBoardList = dao.selectBoardList(conn,pagination,condition);
		close(conn);
		return adminBoardList;
	}
	
	public Pagination getMemPagination(int cp, String memberGrade,String searchKey,String searchValue)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String condition = createCondition(searchKey, searchValue);
		int map = dao.getMemPagination(conn,cp,memberGrade,condition);
		close(conn);
		int listCount = map;
		return new Pagination(cp,listCount,memberGrade);
	}
	public List<adminMember> selectMember(Pagination pagination,String searchKey,String searchValue)throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String condition = createCondition(searchKey, searchValue);
		List<adminMember> adminMemberList = dao.selectMember(conn,pagination,condition);
		close(conn);
		return adminMemberList;
	}
	
	public Pagination getMemPagination2(int cp, String memberGrade,String searchKey,String searchValue) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String condition = createCondition(searchKey, searchValue);
		int map = dao.getMemPagination2(conn,cp,memberGrade,condition);
		close(conn);
		int listCount = map;
		return new Pagination(cp,listCount,memberGrade);
	}
	public List<adminMember> selectMember2(Pagination pagination,String searchKey,String searchValue)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String condition = createCondition(searchKey, searchValue);
		List<adminMember> adminMemberList = dao.selectMember2(conn,pagination,condition);
		close(conn);
		return adminMemberList;
	}
	public Pagination getQuestionPagination(int cp,String searchKey,String searchValue) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String condition = createCondition(searchKey, searchValue);
		int map = dao.getQuestionPagination(conn,cp,condition);
		close(conn);
		int listCount = map;
		return new Pagination(cp,listCount);
	}
	public List<AdminQuestion> selectQuestion(Pagination pagination,String searchKey,String searchValue)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String condition = createCondition(searchKey, searchValue);
		List<AdminQuestion> adminBoardList = dao.selectQuestion(conn,pagination,condition);
		close(conn);
		return adminBoardList;
	}
	private String createCondition(String searchKey,String searchValue) {
		String condition = null;
		//condition 양끝에는 띄어쓰기를 반드시 추가하여
		//sql구문이 연속되서 작성되는 것을 반지함
		switch(searchKey) {
		case "title":
			condition = "AND BOARD_TITLE LIKE '%" + searchValue + "%'";
			break;
		case "number":
			condition = "AND BOARD_NO LIKE '%" + searchValue + "%'";
			break;
		case "id":
			condition = "AND MEMBER_ID LIKE '%" + searchValue + "%'";
			break;
		case "date":
			condition = "AND CREATE_DT LIKE '%" + searchValue + "%'";
			break;
		case "bl":
			condition = "AND BOARD_STATUS LIKE '%" + searchValue + "%'";
			break;
		case "comMemberNo":
			condition = "AND MEMBER_NO LIKE '%" + searchValue + "%'";
			break;
		case "comMemName":
			condition = "AND COMPANY_NAME LIKE '%" + searchValue + "%'";
			break;
		case "freMemName":
			condition = "AND MEMBER_NAME LIKE '%" + searchValue + "%'";
			break;
		case "comMemNum":
			condition = "AND COMPANY_NO LIKE '%" + searchValue + "%'";
			break;
		case "comMemDt":
			condition = "AND ENROLL_DATE LIKE '%" + searchValue + "%'";
			break;
		case "comMemEmail":
			condition = "AND MEMBER_EMAIL LIKE '%" + searchValue + "%'";
			break;
		case "comMemGrade":
			condition = " MEMBER_STATUS LIKE '%" + searchValue + "%'";
			break;
		case "qNo":
			condition = " QUESTION_NO LIKE '%" + searchValue + "%'";
			break;
		case "qTitle":
			condition = " QUESTION_TITLE LIKE '%" + searchValue + "%'";
			break;
		case "qDate":
			condition = " QUESTION_DATE LIKE '%" + searchValue + "%'";
			break;
		case "qStyle":
			condition = " MEMBER_GRADE LIKE '%" + searchValue + "%'";
			break;
		case "qId":
			condition = " MEMBER_ID LIKE '%" + searchValue + "%'";
			break;
		case "qEmail":
			condition = " MEMBER_Email LIKE '%" + searchValue + "%'";
			break;
		
		}
		return condition;
	
	}

}
