package edu.kh.semi.member.model.service;

import static edu.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.semi.member.model.dao.MemberDAO;
import edu.kh.semi.member.model.vo.ComMember;
import edu.kh.semi.member.model.vo.FreMember;


public class MemberService {

	private MemberDAO dao = new MemberDAO();

	/** 프리랜서 로그인 Service
	 * @param freId
	 * @param frePw
	 * @return
	 * @throws Exception
	 */
	public FreMember freLogin(String freId, String frePw)throws Exception {
		
		Connection conn = getConnection();
		
		FreMember freLoginMember = dao.freLogin(conn,freId,frePw);
		
		close(conn);
		
		
		return freLoginMember;
	}

	/** 기업 회원가입 Service
	 * @param freMember
	 * @return
	 * @throws Exception
	 */
	public int freSignUp(FreMember freMember)throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.freSignUp(conn,freMember);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/** 아이디 중복 검사 service
	 * @param id
	 * @return
	 */
	public int idDupCheck(String id)throws Exception{
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn,id);
		
		close(conn);
		
		return result;
	}

	/** 기업 회원가입 Service
	 * @param comMember
	 * @return result
	 * @throws Exception
	 */
	public int comSignUp(ComMember comMember)throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.comSignUp(conn,comMember);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	/** 기업 로그인 Service
	 * @param comId
	 * @param comPw
	 * @return comLoginMember
	 * @throws Exception
	 */
	public ComMember comLogin(String comId, String comPw)throws Exception {
		
		Connection conn = getConnection();
		
		
		ComMember comLoginMember = dao.comLogin(conn,comId,comPw);
		
		close(conn);
		
		
		return comLoginMember;
	}
	
	/** 기업 회원 탈퇴 Service
	 * @param comNo
	 * @param comPw
	 * @return result
	 * @throws Exception
	 */
	public int comSecession(int comNo, String comPw)throws Exception{
		
		Connection conn = getConnection();

		int result = dao.comSecession(conn,comNo,comPw);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 프리랜서 회원 탈퇴 Service
	 * @param freNo
	 * @param frePw
	 * @return result
	 * @throws Exception
	 */
	public int freSecession(int freNo, String frePw)throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.freSecession(conn,freNo,frePw);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 기업 비밀번호 변경 Service
	 * @param currentPwd
	 * @param newPwd1
	 * @param comNo
	 * @return result
	 * @throws Exception
	 */
	public int comChangePwd(String currentPwd, String newPwd1, int comNo)throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.comChangePwd(conn ,currentPwd, newPwd1, comNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/** 프리 비밀번호 변경 Service
	 * @param currentPwd
	 * @param newPwd1
	 * @param freNo
	 * @return
	 * @throws Exception
	 */
	public int freChangePwd(String currentPwd, String newPwd1, int freNo)throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.freChangePwd(conn ,currentPwd, newPwd1, freNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/** 기업 정보 수정 Service
	 * @param comMember
	 * @return result
	 * @throws Exception
	 */
	public int updateComMember(ComMember comMember)throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateComMember(conn,comMember);
		
		if(result > 0)		commit(conn);
		else				rollback(conn);
		
		close(conn);
		return result;
	}

	/** 프리 정보 수정 Service
	 * @param freMember
	 * @return result
	 * @throws Exception
	 */
	public int updateFreMember(FreMember freMember)throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn,freMember);
		
		if(result > 0) {
			
			result = dao.updateFreMember(conn, freMember);
			
			if(result == 0) {
				rollback(conn);
			}else {
				commit(conn);
			}
			
		}else {
			rollback(conn);
		}
		
		
		close(conn);
		
		return result;
	}

	
}





























































