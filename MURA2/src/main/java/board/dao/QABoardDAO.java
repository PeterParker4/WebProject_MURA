package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.vo.QABoard;
import db.ConnUtil;

public class QABoardDAO {
	
private static QABoardDAO instance = null;
	
	public QABoardDAO() {}
	
	public static QABoardDAO getInstance() { // ����
		
		if(instance == null) {
			synchronized (QABoardDAO.class) {
				instance = new QABoardDAO();
			}
		}
		return instance;
	}
	
	
	
	public int getQaArticleCount() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from qa_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return x;
	}
	
	public int getQaArticleCount(String find, String find_box) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			
			if(find.equals("nn_mem")) {
				pstmt = con.prepareStatement("select count(*) from qa_board where nn_mem like '%" + find_box + "%'");
			}else if(find.equals("wsubject_qt")) {
				pstmt = con.prepareStatement("select count(*) from qa_board where wsubject_qt like '%" + find_box + "%'");
			}else if(find.equals("wcontent_qt")) {
				pstmt = con.prepareStatement("select count(*) from qa_board where wcontent_qt like '%" + find_box + "%'");
			}else {
				pstmt = con.prepareStatement("select count(*) from qa_board");
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return x;
	}
	
	public List<QABoard> getQaArticles(int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QABoard> qaArticleList = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			pstmt = con.prepareStatement("select * from (select rownum rnum, un_mem, idx_qt, nn_mem, wsubject_qt, "
					+ "wcontent_qt, step_qt, depth_qt, date_qt, readcount_qt from "
					+ "(select * from qa_board order by idx_qt desc, step_qt asc)) "
					+ "where rnum >=? and rnum <=?");
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				qaArticleList = new ArrayList<QABoard>(end - start + 1);
				
				do {
					QABoard qaArticle = new QABoard();
					
					qaArticle.setUn_mem(rs.getInt("un_mem"));
					qaArticle.setIdx_qt(rs.getInt("idx_qt"));
					qaArticle.setNn_mem(rs.getString("nn_mem"));
					qaArticle.setWsubject_qt(rs.getString("wsubject_qt"));
					qaArticle.setWcontent_qt(rs.getString("wcontent_qt"));
					qaArticle.setStep_qt(rs.getInt("step_qt"));
					qaArticle.setDepth_qt(rs.getInt("depth_qt"));
					qaArticle.setDate_qt(rs.getTimestamp("date_qt"));
					qaArticle.setReadcount_qt(rs.getInt("readcount_qt"));
					
					qaArticleList.add(qaArticle);
					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return qaArticleList;
	}
	
	
	public List<QABoard> getQaArticles(String find, String find_box, int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QABoard> qaArticleList = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from ");
			sql.append("(select rownum rnum, un_mem, idx_qt, nn_mem, wsubject_qt, wcontent_qt, step_qt, depth_qt, date_qt, readcount_qt from ");
			
			if(find.equals("nn_mem")) {
				sql.append("(select * from qa_board where nn_mem like '%" + find_box + "%' order by idx_qt desc, step_qt asc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else if(find.equals("wsubject_qt")) {
				sql.append("(select * from qa_board where wsubject_qt like '%" + find_box + "%' order by idx_qt desc, step_qt asc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else if(find.equals("wcontent_qt")) {
				sql.append("(select * from qa_board where wcontent_qt like '%" + find_box + "%' order by idx_qt desc, step_qt asc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else {
				sql.append("(select * from qa_board order by idx_qt desc, step_qt asc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);

			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				qaArticleList = new ArrayList<QABoard>(end - start + 1);
				
				do {
					QABoard qaArticle = new QABoard();
					
					qaArticle.setUn_mem(rs.getInt("un_mem"));
					qaArticle.setIdx_qt(rs.getInt("idx_qt"));
					qaArticle.setNn_mem(rs.getString("nn_mem"));
					qaArticle.setWsubject_qt(rs.getString("wsubject_qt"));
					qaArticle.setWcontent_qt(rs.getString("wcontent_qt"));
					qaArticle.setStep_qt(rs.getInt("step_qt"));
					qaArticle.setDepth_qt(rs.getInt("depth_qt"));
					qaArticle.setDate_qt(rs.getTimestamp("date_qt"));
					qaArticle.setReadcount_qt(rs.getInt("readcount_qt"));
					
					qaArticleList.add(qaArticle);
					
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return qaArticleList;
	}
	
	
	
	
	
	
	
	
	

}
