package recipe.dao;

import static recipe.db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import recipe.vo.RecipeVO;

public class RecipeDAO {
	Connection con;
	private static RecipeDAO dogDAO;

	public void setConnection(Connection con) {
		this.con = con;
	}

	public static RecipeDAO getInstance() {
		if (dogDAO == null) {
			dogDAO = new RecipeDAO();
		}
		return dogDAO;
	}

	// �̰����ʹ� �޼ҵ� �߰�����.
	public int getArticleCount() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			pstmt = con.prepareStatement("select count(*) from food_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return x;
	}
	
	public int getArticleCount(String find, String find_box) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			if(find.equals("writer")) {
				pstmt = con.prepareStatement("select count(*) from board where writer=?");
				pstmt.setString(1, find_box);
			}else if(find.equals("subject")) {
				pstmt = con.prepareStatement("select count(*) from board where subject like '%" + find_box + "%'");
			}else if(find.equals("content")) {
				pstmt = con.prepareStatement("select count(*) from board where content like '%" + find_box + "%'");
			}else {
				pstmt = con.prepareStatement("select count(*) from board");
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return x;
	}
	
	// board table���� ������ �޼ҵ� ���� (List�� ����)
	// �˻��� ������ ����Ʈ�� �޾ƿ�(what:�˻� ����, content:�˻� ����, start:���۹�ȣ,end:����ȣ)
	public List<RecipeVO> getArticles(int start, int end) {// ����1
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> articleList = null;
		
		try {
			// ����2
			//pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement(
					"select * from (select rownum rnum, num, writer, email, subject, pass, "
							+ "regdate, readcount, ref, step, depth, content, ip from "
							+ "(select * from board order by ref desc, step asc)) "
							+ "where rnum >= ? and rnum <= ?");
			
			// ����3
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
            rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<RecipeVO>(end - start+1); // ����4
				do {
					RecipeVO article = new RecipeVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					articleList.add(article);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return articleList;
	}
	
	public List<RecipeVO> getArticles(String find, String find_box, int start, int end) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> articleList = null;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from ");
			sql.append("(select rownum rnum, num, writer, email, subject, pass, "
					+ "regdate, readcount, ref, step, depth, content, ip from ");
			
			if(find.equals("writer")) {
				sql.append("(select * from board where writer=? order by ref desc, step asc)) "
						+ "where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, find_box);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}else if(find.equals("subject")) {
				sql.append("(select * from board where subject like '%" + find_box + "%' "
						+ "order by ref desc, step asc)) where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else if(find.equals("content")) {
				sql.append("(select * from board where content like '%" + find_box + "%' "
						+ "order by ref desc, step asc)) where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else {
				sql.append("(select * from board order by ref desc, step asc)) "
						+ "where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<RecipeVO>(end - start+1); // ����4
				do {
					RecipeVO article = new RecipeVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					articleList.add(article);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return articleList;
	}
	
	// �̰��� �Խ��� �۾��� ��ɵ��� �ϳ��ϳ� �޼ҵ�� �߰��ϸ� ��
	public void insertArticle(RecipeVO article) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int number = 0;
		
		String sql = "";
		
		try {
			pstmt = con.prepareStatement("select max(num) from food_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) number = rs.getInt(1) + 1; // ����
			else number = 1; // ������ �ƴ� ���
			
			// ������ �߰��ϴ� ���� �ۼ�
			sql="insert into food_board(wnum_li, category_li, wsubject_li, igd_li, sumbnail_li, wcontent_li, tag_li) "
					+ "values(board_seq.nextval, ?,?,?,?,?,?,? )";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getCategory_li());
			pstmt.setString(2, article.getWsubject_li());
			pstmt.setString(3, article.getIgd_li());
			pstmt.setString(4, article.getSumbnail_li());
			pstmt.setString(5, article.getWcontent_li());
			pstmt.setString(6, article.getTag_li());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
	}
	
	/* �� ������ ������ �� ������ �� �� �ֵ��� �ؾ���
	 * 
	 * �츮�� �� num�� �Ű������� �ؼ� �ϳ��� �ۿ� ���� ���������� �����ͺ��̽��� �����;���
	 * �����ͺ��̽����� �� �ϳ��� ������ ������ �޼ҵ带 ����
	 */
	public RecipeVO getArticle(int num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RecipeVO article = null;
		
		try {
			pstmt = con.prepareStatement("update board set readcount = readcount+1 where num=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new RecipeVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return article;
	}
	
	/* �� �󼼺��� ȭ�鿡�� [�ۼ���] ��ư�� ���� ��� updateForm.jsp�� �̵��ϵ��� ��ũ�� �ɾ����Ƿ� 
	 * �� ���� ȭ���� �����ؾ� ��
	 * 
	 * �� �����ÿ��� �۸�� ����� �ٸ��� ��ȸ���� ������ų �ʿ䰡 ����
	 * 
	 * ��ȸ���� ������Ű�� �κ��� �����ϰ� num�� �ش��ϴ� ���� �������� �޼ҵ� ����
	 */
	public RecipeVO updateGetArticle(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RecipeVO article = null;
		
		try {
			pstmt = con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new RecipeVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return article;
	}
	
	/* �����ͺ��̽����� ���� ���� ó���� �Ǿ����
	 * ���� ����ó�� �� �޼ҵ� ����
	 * ���� ���� �� -1, �� ���� ���� 1, �� ���� ���� : 0
	 */
	public int updateArticle(RecipeVO article) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbpasswd = "";
		String sql = "";
		int result = -1;
		
		try {
			pstmt = con.prepareStatement("select pass from board where num=?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("pass");
				if(dbpasswd.equals(article.getPass())) {
					// ��й�ȣ�� ��ġ�ϸ� �������� ����
					sql = "update board set writer=?, email=?, subject=?, content=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());
					pstmt.executeUpdate();
					result = 1; // ���� ����
				}else {
					result = 0;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return result;
	}
	
	/* �� ���� ó��
	 * 
	 * �����ͺ��̽����� ��й�ȣ�� ���Ͽ� ������ ������ ������ �� �޼ҵ带 ������
	 */
	
	public int deleteArticle(int num, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbpasswd = "";
		String sql = "";
		int result = -1;
		
		try {
			pstmt = con.prepareStatement("select pass from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("pass");
				if(dbpasswd.equals(pass)) {
					// ��й�ȣ�� ��ġ�ϸ� �������� ����
					sql = "delete from board where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					result = 1; // ���� ����
				}else {
					result = 0; // ��й�ȣ Ʋ��
				}
			}
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return result;
	}

}