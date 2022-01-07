package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.vo.UserBoard;
import db.ConnUtil;



public class UserBoardDAO {
	
	private static UserBoardDAO instance = null;
	
	public UserBoardDAO() {}
	
	public static UserBoardDAO getInstance() { // ¿¬°á
		
		if(instance == null) {
			synchronized (UserBoardDAO.class) {
				instance = new UserBoardDAO();
			}
		}
		return instance;
	}
	
	
	
		
	public int getUserArticleCount() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from user_board");
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
	
	public int getUserArticleCount(String find1, String find_box1) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			
			if(find1.equals("nn_mem")) {
				pstmt = con.prepareStatement("select count(*) from user_board where nn_mem=?");
				pstmt.setString(1, find_box1);
			}else if(find1.equals("wsubject_ut")) {
				pstmt = con.prepareStatement("select count(*) from user_board where wsubject_ut like '%"+find_box1+"%'");
			}else if(find1.equals("wcontent_ut")) {
				pstmt = con.prepareStatement("select count(*) from user_board where wcontent_ut like '%"+find_box1+"%'");
			}else {
				pstmt = con.prepareStatement("select count(*) from user_board");
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
	
	
	public List<UserBoard> getUserArticles(int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserBoard> userArticleList = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			pstmt = con.prepareStatement("select * from (select rownum rnum, un_mem, idx_ut, wnum_ut, nn_mem, wsubject_ut, "
					+ "wcontent_ut, reply_ut, date_ut, readcount_ut from "
					+ "(select * from user_board order by idx_ut desc)) "
					+ "where rnum >=? and rnum <=?");
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				userArticleList = new ArrayList<UserBoard>(end - start + 1);
				
				do {
					UserBoard userArticle = new UserBoard();
					
					userArticle.setUn_mem(rs.getInt("un_mem"));
					userArticle.setIdx_ut(rs.getInt("idx_ut"));
					userArticle.setWnum_ut(rs.getInt("wnum_ut"));
					userArticle.setNn_mem(rs.getString("nn_mem"));
					userArticle.setWsubject_ut(rs.getString("wsubject_ut"));
					userArticle.setWcontent_ut(rs.getString("wcontent_ut"));
					userArticle.setReply_ut(rs.getString("reply_ut"));
					userArticle.setDate_ut(rs.getTimestamp("date_ut"));
					userArticle.setReadcount_ut(rs.getInt("readcount_ut"));
					
					userArticleList.add(userArticle);
					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return userArticleList;
	}
	
	
	public List<UserBoard> getUserArticles(String find1, String find_box1, int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserBoard> userArticleList = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from ");
			sql.append("(select rownum rnum, un_mem, idx_ut, wnum_ut, nn_mem, wsubject_ut, wcontent_ut, reply_ut, date_ut, readcount_ut from ");
			
			if(find1.equals("nn_mem")) {
				sql.append("(select * from user_board where nn_mem=? order by idx_ut desc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, find_box1);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);				
			}else if(find1.equals("wsubject_ut")) {
				sql.append("(select * from user_board where wsubject_ut like '%" + find_box1 + "%' order by idx_ut desc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else if(find1.equals("wcontent_ut")) {
				sql.append("(select * from user_board where wcontent_ut like '%" + find_box1 + "%' order by idx_ut desc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else {
				sql.append("(select * from user_board order by idx_ut desc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				userArticleList = new ArrayList<UserBoard>(end - start + 1);
				
				do {
					UserBoard userArticle = new UserBoard();
					
					userArticle.setUn_mem(rs.getInt("un_mem"));
					userArticle.setIdx_ut(rs.getInt("idx_ut"));
					userArticle.setWnum_ut(rs.getInt("wnum_ut"));
					userArticle.setNn_mem(rs.getString("nn_mem"));
					userArticle.setWsubject_ut(rs.getString("wsubject_ut"));
					userArticle.setWcontent_ut(rs.getString("wcontent_ut"));
					userArticle.setReply_ut(rs.getString("reply_ut"));
					userArticle.setDate_ut(rs.getTimestamp("date_ut"));
					userArticle.setReadcount_ut(rs.getInt("readcount_ut"));
					
					userArticleList.add(userArticle);
					
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return userArticleList;
	}
	
	
	
	
	
	
		
		
	

}
