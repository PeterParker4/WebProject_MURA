package recommend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public boolean recommandInsert(RecommandVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean flag = false;
		
		try { 
			con = ConnUtil.getConnection();
			String strQuery = "insert into recommand values(?,?)";
			pstmt = con.prepareStatement(strQuery);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getName());
			
			int count = pstmt.executeUpdate();
			if(count > 0) flag = true;
		
		}catch(Exception ex) {
			System.out.println("Exception " + ex);
		}finally {
			if(rs != null) 
				try { 
					rs.close();
					}catch(SQLException s1) {
						
					}
			if(pstmt != null) 
				try { 
					pstmt.close();
					}catch(SQLException s2) {
						
					}
			if(con != null) 
				try { 
					con.close();
					}catch(SQLException s3) {
						
					}
		}
		return flag;
	}
	
	public int recommand(int num, String id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int check = -1;
		
		try {
			con = getConnection();
			
			String strQuery = "select id from member where num=?";
			
			pstmt = con.prepareStatement(strQuery);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbid = rs.getString("id");
				if(id.equals(dbid)) check = 1;
				else check = 0;
			}
		}catch(Exception ex) {
			System.out.println("Exception " + ex);
		}finally {
			if(rs != null) 
				try { 
					rs.close();
					}catch(SQLException s1) {
						
					}
			if(pstmt != null) 
				try { 
					pstmt.close();
					}catch(SQLException s2) {
						
					}
			if(con != null) 
				try { 
					con.close();
					}catch(SQLException s3) {
						
					}
		}
		return check;
	}
	
}
