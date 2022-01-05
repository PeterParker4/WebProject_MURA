package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private static MemberDAO instance = null;

	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	

	// DB ����
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
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("��� ���� ����");
		}
		return con;
	}
	
	// id, pass ������ 1, pass�� Ʋ���� 0, id ������ -1
	public int loginCheck(String id_mem, String pass_mem) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1; //  (������� ������ �����ϱ�) ���̵� ����
		
		con = getConnection();
		String sql = "select pw_mem from member_board where id_mem=?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id_mem);
			
			rs = pstmt.executeQuery();
			MemberVO vo = new MemberVO();
			System.out.println(vo.getId_mem());
			
			if(rs.next()) {
				
				if(rs.getString(1).equals(pass_mem)) {
					result = 1; // �α��� ����
					System.out.println("db���Ἲ��, �α��μ���");
				}else {
					result = 0; // ��й�ȣ ����ġ
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { if(con != null) { con.close();}} catch(Exception ee) { }
			try { if(pstmt != null) { pstmt.close();}} catch(Exception ee) { }
			try { if(rs != null) { rs.close();}} catch(Exception ee) { }
		}
		
		return result;
		
		
		
	}
	
}
