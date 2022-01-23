package recommend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConnUtil;

public class RecommendDAO {
	
	private static RecommendDAO instance = null;

	public RecommendDAO() {
	}

	public static RecommendDAO getInstance() { // 연결
		if (instance == null) {
			synchronized (RecommendDAO.class) {
				instance = new RecommendDAO();
			}
		}
		return instance;
	}

	// 추천 정보 입력
	public void recommendInsert(int num, String id, int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try { 
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("insert into recommend_board values(?,?,?)");
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			pstmt.setInt(3, board_num);
			pstmt.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
	}
	
	// 추천 중복 체크
	public int recommendChek(int num, String id, int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = -1;
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select id_mem from recommend_board where idx_num=? and board_num=?");
			pstmt.setInt(1, num);
			pstmt.setInt(2, board_num);
			rs = pstmt.executeQuery();			
			
			while(rs.next()) {
				String dbid = rs.getString("id_mem");
				if(id.equals(dbid)) check = 1;
			}
			
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return check;
	}
	
}
