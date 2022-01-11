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
	
	public int getUserArticleCount(String find, String find_box) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			
			if(find.equals("nn_mem")) {
				pstmt = con.prepareStatement("select count(*) from user_board where nn_mem like '%" + find_box +"%'");
			}else if(find.equals("wsubject_ut")) {
				pstmt = con.prepareStatement("select count(*) from user_board where wsubject_ut like '%"+find_box+"%'");
			}else if(find.equals("wcontent_ut")) {
				pstmt = con.prepareStatement("select count(*) from user_board where wcontent_ut like '%"+find_box+"%'");
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
			
			pstmt = con.prepareStatement("select * from (select rownum rnum, un_mem, idx_ut, nn_mem, wsubject_ut, "
					+ "wcontent_ut, date_ut, readcount_ut from "
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
					userArticle.setNn_mem(rs.getString("nn_mem"));
					userArticle.setWsubject_ut(rs.getString("wsubject_ut"));
					userArticle.setWcontent_ut(rs.getString("wcontent_ut"));
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
	
	
	public List<UserBoard> getUserArticles(String find, String find_box, int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserBoard> userArticleList = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from ");
			sql.append("(select rownum rnum, un_mem, idx_ut, nn_mem, wsubject_ut, wcontent_ut, date_ut, readcount_ut from ");
			
			if(find.equals("nn_mem")) {
				sql.append("(select * from user_board where nn_mem like '%" + find_box + "%' order by idx_ut desc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);				
			}else if(find.equals("wsubject_ut")) {
				sql.append("(select * from user_board where wsubject_ut like '%" + find_box + "%' order by idx_ut desc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else if(find.equals("wcontent_ut")) {
				sql.append("(select * from user_board where wcontent_ut like '%" + find_box + "%' order by idx_ut desc)) where rnum >=? and rnum <=?");
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
					userArticle.setNn_mem(rs.getString("nn_mem"));
					userArticle.setWsubject_ut(rs.getString("wsubject_ut"));
					userArticle.setWcontent_ut(rs.getString("wcontent_ut"));
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
	
	public void insertUserArticle(UserBoard userArticle) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		int number = 0;
		
		String sql = "";
		
		try {
			
			con = ConnUtil.getConnection();
			
			sql = "insert into user_board(un_mem, idx_ut, nn_mem, wsubject_ut, wcontent_ut, date_ut) "
					+ "values(?, content_seq.nextval, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userArticle.getUn_mem());
			pstmt.setString(2, userArticle.getNn_mem());
			pstmt.setString(3, userArticle.getWsubject_ut());
			pstmt.setString(4, userArticle.getWcontent_ut());
			pstmt.setTimestamp(5, userArticle.getDate_ut());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
	}
	
	public UserBoard getUserArticle(int idx_ut) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBoard userArticle = null;
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("update user_board set readcount_ut=readcount_ut+1 where idx_ut=?");
			
			pstmt.setInt(1, idx_ut);
			pstmt.executeQuery();
			
			if(rs.next()) {
				userArticle = new UserBoard();
				userArticle.setUn_mem(rs.getInt("un_mem"));
				userArticle.setIdx_ut(rs.getInt("idx_ut"));
				userArticle.setNn_mem(rs.getString("nn_mem"));
				userArticle.setWsubject_ut(rs.getString("wsubject_ut"));
				userArticle.setWcontent_ut(rs.getString("wcontent_ut"));
				userArticle.setDate_ut(rs.getTimestamp("date_ut"));
				userArticle.setReadcount_ut(rs.getInt("readcount_ut"));	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		return userArticle;
	}
	
	public UserBoard updateGetUserArticle(int idx_ut) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBoard userArticle = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			pstmt = con.prepareStatement("select * from user_board where idx_ut=?");
			pstmt.setInt(1, idx_ut);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userArticle = new UserBoard();
				userArticle.setUn_mem(rs.getInt("un_mem"));
				userArticle.setIdx_ut(rs.getInt("idx_ut"));
				userArticle.setNn_mem(rs.getString("nn_mem"));
				userArticle.setWsubject_ut(rs.getString("wsubject_ut"));
				userArticle.setWcontent_ut(rs.getString("wcontent_ut"));
				userArticle.setDate_ut(rs.getTimestamp("date_ut"));
				userArticle.setReadcount_ut(rs.getInt("readcount_ut"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		return userArticle;
	}
	
	public int updateUserArticle(UserBoard userArticle) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		int result = -1;
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select un_mem from user_board where idx_ut=?");
			
			pstmt.setInt(1, userArticle.getIdx_ut());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				if(userArticle.getUn_mem() != 0) {
					sql = "update user_board set wsubject_ut=?, wcontent_ut=? where idx_ut=?";
			
					pstmt = con.prepareStatement(sql);
			
					pstmt.setString(1, userArticle.getWsubject_ut());
					pstmt.setString(2, userArticle.getWcontent_ut());
					pstmt.setInt(3, userArticle.getIdx_ut());
			
					pstmt.executeUpdate();
					result = 1;
				}else {
					result = 0;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		return result;
	}
	
	public int deleteUserArticle(int idx_ut) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		int result = -1;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select un_mem from user_board where idx_ut=?");
			
			pstmt.setInt(1, idx_ut);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sql = "delete from user_board where idx_ut=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx_ut);
				pstmt.executeUpdate();
				result = 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		return result;
	}
	
	

}
