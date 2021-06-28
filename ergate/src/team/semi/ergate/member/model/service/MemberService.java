package team.semi.ergate.member.model.service;

import static team.semi.ergate.common.JDBCTemplate.*;

import java.sql.Connection;

import team.semi.ergate.member.model.dao.MemberDAO;
import team.semi.ergate.member.model.vo.ComMember;
import team.semi.ergate.member.model.vo.FreMember;


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
	
	
}
