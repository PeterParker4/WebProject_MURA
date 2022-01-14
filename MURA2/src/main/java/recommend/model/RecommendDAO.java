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

	public static RecommendDAO getInstance() { // ¿¬°á
		if (instance == null) {
			synchronized (RecommendDAO.class) {
				instance = new RecommendDAO();
			}
		}
		return instance;
	}

	public boolean recommendInsert(RecommendVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try { 
			con = ConnUtil.getConnection();
			String sql = "insert into recommend_board values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getName());
			
			int count = pstmt.executeUpdate();
			if(count > 0) flag = true;
		
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return flag;
	}
	
	public int recommend(int num, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = -1;
		
		try {
			String sql = "select id_mem from member_board where num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbid = rs.getString("id_mem");
				if(id.equals(dbid)) check = 1;
				else check = 0;
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
