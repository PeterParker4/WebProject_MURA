package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private static MemberDAO instance = null;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	// DB 연결
	public static MemberDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		
		return instance;
	}
	
	public Connection getConnection() {

		Connection con = null;

		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("디비 연결 실패");
		}
		return con;
	}
	
	// id 체크 함수
	/*public boolean idCheck(String id_mem) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean result = true;
		
		try {
			con = getConnection();
			
			String sql = "select * from member_board where id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id_mem);
			
			if(!rs.next()) result = false; // 아이디 존재하지 않음
			
		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException ss) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
			if(con != null) try {con.close();}catch(SQLException ss) {}
		}
		return result; // 로그인 성공
	}*/
	
	// 1 로그인 성공, 0 비밀번호 불일치, -1 로그인 실패
	public int loginCheck(String id_mem, String pass_mem) {
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = -1; // 로그인 실패
		
		try {
			con = getConnection();
			String sql = "select pass_mem from member_board where id=?";
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, id_mem);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbPass = rs.getString("pass_mem");
				
				if(pass_mem.equals(dbPass)) result = 1; // 로그인 성공
				else result = 0; // 비밀번호 불일치
			}
			
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ss) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
			if(con != null) try {con.close();}catch(SQLException ss) {}
		}
		
		return result;
	}
	
}
