package recipe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

	private static RecipeDAO instance = null;

	public RecipeDAO() {
	}

	public static RecipeDAO getInstance() { // ����
		if (instance == null) {
			synchronized (RecipeDAO.class) {
				instance = new RecipeDAO();
			}
		}
		return instance;
	}

	// �̰��� �Խ��� �۾��� ��ɵ��� �ϳ��ϳ� �߰��ϴ� �޼ҵ带 �ۼ�

	// ��ü ���� ������ ������ �޼ҵ� ����
	public int getArticleCount() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from food_board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Exception " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException s3) {
				}
		}
		return x;
	}

	// �˻��Ǿ� ��µ� ���� ������ ������ �޼ҵ� ����
	public int getArticleCount(String find, String find_box) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			con = ConnUtil.getConnection();

			if (find.equals("un_mem")) {
				pstmt = con.prepareStatement("select count(*) from food_board where un_mem=?");
				pstmt.setString(1, find_box);
			} else if (find.equals("wsubject_li")) {
				pstmt = con.prepareStatement(
						"select count(*) from food_board where wsubject_li like '%" + find_box + "%'");
			} else if (find.equals("wcontent_li")) {
				pstmt = con.prepareStatement(
						"select count(*) from food_board where wcontent_li like '%" + find_box + "%'");
			} else {
				pstmt = con.prepareStatement("select count(*) from food_board");
			}

			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Exception " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException s3) {
				}
		}
		return x;
	}

	// food_board table���� ������ �޼ҵ� ���� (List�� ����)
	// �˻��� ������ ����Ʈ�� �޾ƿ�(what:�˻� ����, content:�˻� ����, start:���۹�ȣ,end:����ȣ)
	public List<RecipeVO> getArticles(int start, int end) {// ����1

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> articleList = null;

		try {
			con = ConnUtil.getConnection();

			// ����2
			// pstmt = con.prepareStatement("select * from food_board order by num desc");
			pstmt = con.prepareStatement(
					"select * from (select rownum rnum, idx_li, un_mem, wnum_li, nn_mem, category_li, "
							+ "wsubject_li, tag_li, thumb_li, wcontent_li, reply_li, date_li, readcount_li from "
							+ "(select * from food_board order by idx_li desc)) " + "where rnum >= ? and rnum <= ?");

			// ����3
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<RecipeVO>(end - start + 1); // ����4
				do {
					RecipeVO article = new RecipeVO();
					article.setIdx_li(rs.getInt("idx_li"));
					article.setUn_mem(rs.getInt("un_mem"));
					article.setWnum_li(rs.getInt("wnum_li"));
					article.setNn_mem(rs.getString("nn_mem"));
					article.setCategory_li(rs.getString("category_li"));
					article.setWsubject_li(rs.getString("wsubject_li"));
					article.setTag_li(rs.getString("tag_li"));
					article.setThumb_li(rs.getString("thumb_li"));
					article.setWcontent_li(rs.getString("wcontent_li"));
					article.setReply_li(rs.getString("reply_li"));
					article.setDate_li(rs.getTimestamp("date_li"));
					article.setReadcount_li(rs.getInt("readcount_li"));
					articleList.add(article);
				} while (rs.next());
			}

		} catch (Exception e) {
			System.out.println("Exception " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException s3) {
				}
		}
		return articleList;
	}

	public List<RecipeVO> getArticles(String find, String find_box, int start, int end) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> articleList = null;

		try {
			con = ConnUtil.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select * from ");
			sql.append("(select rownum rnum, idx_li, un_mem, wnum_li, nn_mem, category_li, "
					+ "wsubject_li, tag_li, thumb_li, wcontent_li, reply_li, date_li, readcount_li from ");

			if (find.equals("un_mem")) {
				sql.append("(select * from food_board where un_mem=? order by idx_li desc))"
						+ "where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, find_box);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} else if (find.equals("wsubject_li")) {
				sql.append("(select * from food_board where wsubject_li like '%" + find_box
						+ "%')) where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else if (find.equals("wcontent_li")) {
				sql.append("(select * from food_board where wcontent_li like '%" + find_box
						+ "%')) where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else {
				sql.append("select * from food_board where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<RecipeVO>(end - start + 1); // ����4
				do {
					RecipeVO article = new RecipeVO();
					article.setIdx_li(rs.getInt("idx_li"));
					article.setUn_mem(rs.getInt("un_mem"));
					article.setWnum_li(rs.getInt("wnum_li"));
					article.setNn_mem(rs.getString("nn_mem"));
					article.setCategory_li(rs.getString("category_li"));
					article.setWsubject_li(rs.getString("wsubject_li"));
					article.setTag_li(rs.getString("tag_li"));
					article.setThumb_li(rs.getString("thumb_li"));
					article.setWcontent_li(rs.getString("wcontent_li"));
					article.setReply_li(rs.getString("reply_li"));
					article.setDate_li(rs.getTimestamp("date_li"));
					article.setReadcount_li(rs.getInt("readcount_li"));
					articleList.add(article);
				} while (rs.next());
			}

		} catch (Exception e) {
			System.out.println("Exception " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException s3) {
				}
		}
		return articleList;
	}

	/*
	 * // �̰��� �Խ��� �۾��� ��ɵ��� �ϳ��ϳ� �޼ҵ�� �߰��ϸ� �� public void insertArticle(RecipeVO
	 * article) {
	 * 
	 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * int number = 0;
	 * 
	 * String sql = "";
	 * 
	 * try { con = ConnUtil.getConnection(); pstmt =
	 * con.prepareStatement("select max(num) from food_board"); rs =
	 * pstmt.executeQuery();
	 * 
	 * if(rs.next()) number = rs.getInt(1) + 1; // ���� else number = 1; // ������ �ƴ� ���
	 * 
	 * // ������ �߰��ϴ� ���� �ۼ�
	 * sql="insert into food_board(num, writer, email, subject, pass, regdate, " +
	 * "ref, step, depth, content, ip) " +
	 * "values(board_seq.nextval, ?,?,?,?,?,?,?,?,?,? )";
	 * 
	 * pstmt = con.prepareStatement(sql); pstmt.setString(1, article.getWriter());
	 * pstmt.setString(2, article.getEmail()); pstmt.setString(3,
	 * article.getSubject()); pstmt.setString(4, article.getPass());
	 * pstmt.setTimestamp(5, article.getRegdate()); pstmt.setInt(6, ref);
	 * pstmt.setInt(7, step); pstmt.setInt(8, depth); pstmt.setString(9,
	 * article.getContent()); pstmt.setString(10, article.getIp());
	 * pstmt.executeUpdate();
	 * 
	 * }catch(Exception e) { System.out.println("Exception "+e); }finally { if(rs !=
	 * null) try {rs.close();}catch(SQLException s1) {} if(pstmt != null) try
	 * {pstmt.close();}catch(SQLException s2) {} if(con != null) try
	 * {con.close();}catch(SQLException s3) {} } }
	 * 
	 * �� ������ ������ �� ������ �� �� �ֵ��� �ؾ���
	 * 
	 * �츮�� �� num�� �Ű������� �ؼ� �ϳ��� �ۿ� ���� ���������� �����ͺ��̽��� �����;��� �����ͺ��̽����� �� �ϳ��� ������ ������ �޼ҵ带
	 * ����
	 * 
	 * public RecipeVO getArticle(int num) {
	 * 
	 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * RecipeVO article = null;
	 * 
	 * try { con = ConnUtil.getConnection(); pstmt =
	 * con.prepareStatement("update board set readcount = readcount+1 where num=?");
	 * pstmt.setInt(1, num); pstmt.executeUpdate();
	 * 
	 * pstmt = con.prepareStatement("select * from board where num=?");
	 * pstmt.setInt(1, num); rs = pstmt.executeQuery();
	 * 
	 * if(rs.next()) { article = new RecipeVO(); article.setNum(rs.getInt("num"));
	 * article.setWriter(rs.getString("writer"));
	 * article.setEmail(rs.getString("email"));
	 * article.setSubject(rs.getString("subject"));
	 * article.setPass(rs.getString("pass"));
	 * article.setRegdate(rs.getTimestamp("regdate"));
	 * article.setReadcount(rs.getInt("readcount"));
	 * article.setRef(rs.getInt("ref")); article.setStep(rs.getInt("step"));
	 * article.setDepth(rs.getInt("depth"));
	 * article.setContent(rs.getString("content"));
	 * article.setIp(rs.getString("ip")); } }catch(Exception e) {
	 * System.out.println("Exception "+e); }finally { if(rs != null) try
	 * {rs.close();}catch(SQLException s1) {} if(pstmt != null) try
	 * {pstmt.close();}catch(SQLException s2) {} if(con != null) try
	 * {con.close();}catch(SQLException s3) {} } return article; }
	 * 
	 * �� �󼼺��� ȭ�鿡�� [�ۼ���] ��ư�� ���� ��� updateForm.jsp�� �̵��ϵ��� ��ũ�� �ɾ����Ƿ� �� ���� ȭ���� �����ؾ� ��
	 * 
	 * �� �����ÿ��� �۸�� ����� �ٸ��� ��ȸ���� ������ų �ʿ䰡 ����
	 * 
	 * ��ȸ���� ������Ű�� �κ��� �����ϰ� num�� �ش��ϴ� ���� �������� �޼ҵ� ����
	 * 
	 * public RecipeVO updateGetArticle(int num) { Connection con = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; RecipeVO article = null;
	 * 
	 * try { con = ConnUtil.getConnection(); pstmt =
	 * con.prepareStatement("select * from board where num=?"); pstmt.setInt(1,
	 * num); rs = pstmt.executeQuery();
	 * 
	 * if(rs.next()) { article = new RecipeVO(); article.setNum(rs.getInt("num"));
	 * article.setWriter(rs.getString("writer"));
	 * article.setEmail(rs.getString("email"));
	 * article.setSubject(rs.getString("subject"));
	 * article.setPass(rs.getString("pass"));
	 * article.setRegdate(rs.getTimestamp("regdate"));
	 * article.setReadcount(rs.getInt("readcount"));
	 * article.setRef(rs.getInt("ref")); article.setStep(rs.getInt("step"));
	 * article.setDepth(rs.getInt("depth"));
	 * article.setContent(rs.getString("content"));
	 * article.setIp(rs.getString("ip")); } }catch(Exception e) {
	 * System.out.println("Exception "+e); }finally { if(rs != null) try
	 * {rs.close();}catch(SQLException s1) {} if(pstmt != null) try
	 * {pstmt.close();}catch(SQLException s2) {} if(con != null) try
	 * {con.close();}catch(SQLException s3) {} } return article; }
	 * 
	 * �����ͺ��̽����� ���� ���� ó���� �Ǿ���� ���� ����ó�� �� �޼ҵ� ���� ���� ���� �� -1, �� ���� ���� 1, �� ���� ���� : 0
	 * 
	 * public int updateArticle(RecipeVO article) {
	 * 
	 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * String dbpasswd = ""; String sql = ""; int result = -1;
	 * 
	 * try { con = ConnUtil.getConnection(); pstmt =
	 * con.prepareStatement("select pass from board where num=?"); pstmt.setInt(1,
	 * article.getNum()); rs = pstmt.executeQuery();
	 * 
	 * if(rs.next()) { dbpasswd = rs.getString("pass");
	 * if(dbpasswd.equals(article.getPass())) { // ��й�ȣ�� ��ġ�ϸ� �������� ���� sql =
	 * "update board set writer=?, email=?, subject=?, content=? where num=?"; pstmt
	 * = con.prepareStatement(sql); pstmt.setString(1, article.getWriter());
	 * pstmt.setString(2, article.getEmail()); pstmt.setString(3,
	 * article.getSubject()); pstmt.setString(4, article.getContent());
	 * pstmt.setInt(5, article.getNum()); pstmt.executeUpdate(); result = 1; // ����
	 * ���� }else { result = 0; } } }catch(Exception e) {
	 * System.out.println("Exception "+e); }finally { if(rs != null) try
	 * {rs.close();}catch(SQLException s1) {} if(pstmt != null) try
	 * {pstmt.close();}catch(SQLException s2) {} if(con != null) try
	 * {con.close();}catch(SQLException s3) {} } return result; }
	 * 
	 * �� ���� ó��
	 * 
	 * �����ͺ��̽����� ��й�ȣ�� ���Ͽ� ������ ������ ������ �� �޼ҵ带 ������
	 * 
	 * 
	 * public int deleteArticle(int num, String pass) { Connection con = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * String dbpasswd = ""; String sql = ""; int result = -1;
	 * 
	 * try { con = ConnUtil.getConnection(); pstmt =
	 * con.prepareStatement("select pass from board where num=?"); pstmt.setInt(1,
	 * num); rs = pstmt.executeQuery();
	 * 
	 * if(rs.next()) { dbpasswd = rs.getString("pass"); if(dbpasswd.equals(pass)) {
	 * // ��й�ȣ�� ��ġ�ϸ� �������� ���� sql = "delete from board where num=?"; pstmt =
	 * con.prepareStatement(sql); pstmt.setInt(1, num); pstmt.executeUpdate();
	 * result = 1; // ���� ���� }else { result = 0; // ��й�ȣ Ʋ�� } } }catch(Exception e) {
	 * System.out.println("Exception "+e); }finally { if(rs != null) try
	 * {rs.close();}catch(SQLException s1) {} if(pstmt != null) try
	 * {pstmt.close();}catch(SQLException s2) {} if(con != null) try
	 * {con.close();}catch(SQLException s3) {} } return result; }
	 */

}
