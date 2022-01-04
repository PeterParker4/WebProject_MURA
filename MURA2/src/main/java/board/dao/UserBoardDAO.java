package board.dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.vo.UserBoard;


public class UserBoardDAO {
	
	Connection con;
	private static UserBoardDAO userBoardDAO;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public static UserBoardDAO getInstance() {
		
		if(userBoardDAO == null) {
			userBoardDAO = new UserBoardDAO();
		}
		return userBoardDAO;
	}
	
	public void insertUserArticle(UserBoard userArticle) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int un_mem = userArticle.getUn_mem();
		int idx_ut = userArticle.getIdx_ut();
		int wnum_ut = userArticle.getWnum_ut();
		
		int number = 0;
		
		String sql = "";
		
		try {
			
			pstmt = con.prepareStatement("select max(wnum_ut) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) number = rs.getInt(1) + 1;
			else number = 1;
			
			if(wnum_ut == 0) idx_ut = number;
			
			sql = "insert into user_board(un_mem, idx_ut, wnum_ut, nn_mem, tag_ut, "
					+ "wsubject_ut, wcontent_ut, reply_ut, date_ut) "
					+ "values(?, user_seq.nextval, ?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userArticle.getUn_mem());
			pstmt.setInt(2, userArticle.getWnum_ut());
			pstmt.setString(3, userArticle.getNn_mem());
			pstmt.setString(4, userArticle.getTag_ut());
			pstmt.setString(5, userArticle.getWsubject_ut());
			pstmt.setString(6, userArticle.getWcontent_ut());
			pstmt.setString(7, userArticle.getReply_ut());
			pstmt.setTimestamp(8, userArticle.getDate_ut());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
	}
	
	
		
	public int getUserArticleCount() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			
			pstmt = con.prepareStatement("select count(*) from user_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return x;
	}
	
	public List<UserBoard> getUserArticles(int start, int end){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserBoard> userArticles = null;
		
		try {
			pstmt = con.prepareStatement("select * from (select rownum rnum, un_mem, idx_ut, wnum_ut, nn_mem, tag_ut, wsubject_ut, "
					+ "wcontent_ut, reply_ut, date_ut from (select * from user_board order by idx_ut desc)) "
					+ "where rnum >= ? and rnum <= ?");
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				userArticles = new ArrayList<UserBoard>(end - start + 1);
				
				do {
					UserBoard userArticle = new UserBoard();
					
					userArticle.setUn_mem(rs.getInt("un_mem"));
					userArticle.setIdx_ut(rs.getInt("idx_ut"));
					userArticle.setWnum_ut(rs.getInt("wnum_ut"));
					userArticle.setNn_mem(rs.getString("nn_mem"));
					userArticle.setTag_ut(rs.getString("tag_ut"));
					userArticle.setWsubject_ut(rs.getString("wsubject_ut"));
					userArticle.setWcontent_ut(rs.getString("wcontent_ut"));
					userArticle.setReply_ut(rs.getString("reply_ut"));
					userArticle.setDate_ut(rs.getTimestamp("date_ut"));
					
					userArticles.add(userArticle);
					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return userArticles;
	}
	
	
	
	
	
	
		
		
	

}
