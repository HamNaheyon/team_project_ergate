package edu.kh.ergate.admin.model.service;
import static edu.kh.ergate.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.ergate.admin.model.dao.DMLDAO;
public class DMLService {
	private DMLDAO dao = new DMLDAO();

	/** 게시글 블라인드
	 * @param boardNo
	 * @param boardTypeNo
	 * @return
	 * @throws Exception
	 */
	public int boardDel(int boardNo, int boardTypeNo) throws Exception{
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		int result= dao.boardDel(conn,boardNo,boardTypeNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/** 게시글 블라인드 복구
	 * @param boardNo
	 * @param boardTypeNo
	 * @return
	 * @throws Exception
	 */
	public int boardRe(int boardNo, int boardTypeNo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		int result= dao.boardSel(conn,boardNo,boardTypeNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**멤버 탈퇴 처리
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int memberDel(int memberNo) throws Exception{
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		int result= dao.memberDel(conn,memberNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**멤버 탈퇴 복구 처리
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int memberRe(int memberNo) throws Exception{
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		int result= dao.memberRe(conn,memberNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
