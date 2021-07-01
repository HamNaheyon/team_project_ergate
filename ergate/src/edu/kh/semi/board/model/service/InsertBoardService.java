//package edu.kh.semi.board.model.service;
//
//import static edu.kh.ergate.common.JDBCTemplate.*;
//
//import java.sql.Connection;
//import java.util.List;
//
//import edu.kh.semi.board.model.dao.InsertBoardDAO;
//import edu.kh.semi.board.model.vo.Category;
//
//public class InsertBoardService {
//
//	private InsertBoardDAO dao = new InsertBoardDAO();
//	/**
//	 * @return
//	 * @throws Exception
//	 */
//	public List<Category> selectCategoryList()throws Exception {
//
//		Connection conn = getConnection();
//		
//		List<Category> category = dao.selectCategoryList(conn);
//		
//		close(conn);
//		return category;
//	}
//
//}
