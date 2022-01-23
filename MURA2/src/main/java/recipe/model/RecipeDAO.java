package recipe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnUtil;

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
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
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

			if (find.equals("nn_mem")) {
				pstmt = con.prepareStatement("select count(*) from food_board where nn_mem=?");
				pstmt.setString(1, find_box);
			} else if (find.equals("wsubject_li")) {
				pstmt = con.prepareStatement(
						"select count(*) from food_board where wsubject_li like '%" + find_box + "%'");
			} else if (find.equals("category_li")) {
				pstmt = con.prepareStatement(
						"select count(*) from food_board where category_li like '%" + find_box + "%'");
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
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s2) {}
			if(con != null) try {con.close();}catch(SQLException s3) {}
		}
		return x;
	}
	
	// index���� ������ �޼ҵ� ���� (List�� ����)
	// �ε��� ��ȸ�������� �� ��������
	public List<RecipeVO> getArticlesCnt() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> articleList = null;

		try {
			con = ConnUtil.getConnection();

			pstmt = con.prepareStatement("select * from food_board order by readcount_li desc");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<RecipeVO>();
				do {
					RecipeVO article = new RecipeVO();
					article.setIdx_li(rs.getInt("idx_li"));
					article.setUn_mem(rs.getInt("un_mem"));
					article.setNn_mem(rs.getString("nn_mem"));
					article.setCategory_li(rs.getString("category_li"));
					article.setWsubject_li(rs.getString("wsubject_li"));
					article.setTag_li(rs.getString("tag_li"));
					article.setThumb_li(rs.getString("thumb_li"));
					article.setWcontent_li(rs.getString("wcontent_li"));
					article.setDate_li(rs.getTimestamp("date_li"));
					article.setReadcount_li(rs.getInt("readcount_li"));
					article.setRecommend_cnt(rs.getInt("recommend_cnt"));
					article.setBoard_num(rs.getInt("board_num"));
					articleList.add(article);
				} while (rs.next());
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

	// �ε��� ��õ������ �� ��������
	public List<RecipeVO> getArticlesRecommend() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> articleList = null;
		
		try {
			con = ConnUtil.getConnection();
			
			pstmt = con.prepareStatement("select * from food_board order by recommend_cnt desc");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				articleList = new ArrayList<RecipeVO>();
				do {
					RecipeVO article = new RecipeVO();
					article.setIdx_li(rs.getInt("idx_li"));
					article.setUn_mem(rs.getInt("un_mem"));
					article.setNn_mem(rs.getString("nn_mem"));
					article.setCategory_li(rs.getString("category_li"));
					article.setWsubject_li(rs.getString("wsubject_li"));
					article.setTag_li(rs.getString("tag_li"));
					article.setThumb_li(rs.getString("thumb_li"));
					article.setWcontent_li(rs.getString("wcontent_li"));
					article.setDate_li(rs.getTimestamp("date_li"));
					article.setReadcount_li(rs.getInt("readcount_li"));
					article.setRecommend_cnt(rs.getInt("recommend_cnt"));
					article.setBoard_num(rs.getInt("board_num"));
					articleList.add(article);
				} while (rs.next());
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

	// food_board table���� ������ �޼ҵ� ���� (List�� ����)
	// �˻��� ������ ����Ʈ�� �޾ƿ�(what:�˻� ����, content:�˻� ����, start:���۹�ȣ,end:����ȣ)
	public List<RecipeVO> getArticles(int start, int end) {// ����1

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> articleList = null;

		try {
			con = ConnUtil.getConnection();

			pstmt = con.prepareStatement(
					"select * from (select rownum rnum, idx_li, un_mem, nn_mem, category_li, "
							+ "wsubject_li, tag_li, thumb_li, wcontent_li, date_li, readcount_li, recommend_cnt, board_num from "
							+ "(select * from food_board order by idx_li desc)) where rnum >= ? and rnum <= ?");

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
					article.setNn_mem(rs.getString("nn_mem"));
					article.setCategory_li(rs.getString("category_li"));
					article.setWsubject_li(rs.getString("wsubject_li"));
					article.setTag_li(rs.getString("tag_li"));
					article.setThumb_li(rs.getString("thumb_li"));
					article.setWcontent_li(rs.getString("wcontent_li"));
					article.setReply_li(rs.getString("reply_li"));
					article.setDate_li(rs.getTimestamp("date_li"));
					article.setReadcount_li(rs.getInt("readcount_li"));
					article.setRecommend_cnt(rs.getInt("recommend_cnt"));
					article.setBoard_num(rs.getInt("board_num"));
					articleList.add(article);
				} while (rs.next());
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
			con = ConnUtil.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select * from ");
			sql.append("(select rownum rnum, idx_li, un_mem, nn_mem, category_li, "
					+ "wsubject_li, tag_li, thumb_li, wcontent_li, date_li, readcount_li, recommend_cnt, board_num from ");

			if (find.equals("nn_mem")) {
				sql.append("(select * from food_board where nn_mem=? order by idx_li desc)) "
						+ "where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, find_box);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} else if (find.equals("wsubject_li")) {
				sql.append("(select * from food_board where wsubject_li like '%" + find_box + "%' "
						+ "order by idx_li desc)) where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else if (find.equals("category_li")) {
				sql.append("(select * from food_board where category_li like '%" + find_box + "%' "
						+ "order by idx_li desc)) where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else if (find.equals("wcontent_li")) {
				sql.append("(select * from food_board where wcontent_li like '%" + find_box + "%' "
						+ "order by idx_li desc)) where rnum >= ? and rnum <= ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else {
				sql.append("(select * from food_board order by idx_li desc)) "
						+ "where rnum >= ? and rnum <= ?");
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
					article.setNn_mem(rs.getString("nn_mem"));
					article.setCategory_li(rs.getString("category_li"));
					article.setWsubject_li(rs.getString("wsubject_li"));
					article.setTag_li(rs.getString("tag_li"));
					article.setThumb_li(rs.getString("thumb_li"));
					article.setWcontent_li(rs.getString("wcontent_li"));
					article.setDate_li(rs.getTimestamp("date_li"));
					article.setReadcount_li(rs.getInt("readcount_li"));
					article.setRecommend_cnt(rs.getInt("recommend_cnt"));
					article.setBoard_num(rs.getInt("board_num"));
					articleList.add(article);
				} while (rs.next());
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
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int number = 0;
		
		String sql = "";
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select max(idx_li) from food_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) number = rs.getInt(1) + 1; // ����
			else number = 1; // ������ �ƴ� ���
			
			// ������ �߰��ϴ� ���� �ۼ�
			sql="insert into food_board(idx_li, un_mem, nn_mem, category_li, wsubject_li, tag_li, thumb_li, wcontent_li, date_li) "
					+ "values(content_seq.nextval, ?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getUn_mem());
			pstmt.setString(2, article.getNn_mem());
			pstmt.setString(3, article.getCategory_li());
			pstmt.setString(4, article.getWsubject_li());
			pstmt.setString(5, article.getTag_li());
			pstmt.setString(6, article.getThumb_li());
			pstmt.setString(7, article.getWcontent_li());
			pstmt.setTimestamp(8, article.getDate_li());
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
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("update food_board set readcount_li = readcount_li + 1 where idx_li=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement("select * from food_board where idx_li=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new RecipeVO();
				article.setIdx_li(rs.getInt("idx_li"));
				article.setUn_mem(rs.getInt("un_mem"));
				article.setNn_mem(rs.getString("nn_mem"));
				article.setCategory_li(rs.getString("category_li"));
				article.setWsubject_li(rs.getString("wsubject_li"));
				article.setTag_li(rs.getString("tag_li"));
				article.setThumb_li(rs.getString("thumb_li"));
				article.setWcontent_li(rs.getString("wcontent_li"));
				article.setDate_li(rs.getTimestamp("date_li"));
				article.setReadcount_li(rs.getInt("readcount_li"));
				article.setRecommend_cnt(rs.getInt("recommend_cnt"));
				article.setBoard_num(rs.getInt("board_num"));
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
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select * from food_board where idx_li=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new RecipeVO();
				article.setIdx_li(rs.getInt("idx_li"));
				article.setUn_mem(rs.getInt("un_mem"));
				article.setNn_mem(rs.getString("nn_mem"));
				article.setCategory_li(rs.getString("category_li"));
				article.setWsubject_li(rs.getString("wsubject_li"));
				article.setTag_li(rs.getString("tag_li"));
				article.setThumb_li(rs.getString("thumb_li"));
				article.setWcontent_li(rs.getString("wcontent_li"));
				article.setDate_li(rs.getTimestamp("date_li"));
				article.setReadcount_li(rs.getInt("readcount_li"));
				article.setRecommend_cnt(rs.getInt("recommend_cnt"));
				article.setBoard_num(rs.getInt("board_num"));
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
		
		int dbun_mem = 0;
		String sql = "";
		int result = -1;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select un_mem from food_board where idx_li=?");
			pstmt.setInt(1, article.getIdx_li());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbun_mem = rs.getInt("un_mem");
				if(dbun_mem == article.getUn_mem()) {
					// ������ȣ�� ��ġ�ϸ� �������� ����
					sql = "update food_board set category_li=?, wsubject_li=?, tag_li=?, wcontent_li=?, thumb_li=? where idx_li=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getCategory_li());
					pstmt.setString(2, article.getWsubject_li());
					pstmt.setString(3, article.getTag_li());
					pstmt.setString(4, article.getWcontent_li());
					pstmt.setString(5, article.getThumb_li());
					pstmt.setInt(6, article.getIdx_li());
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
	
	public int deleteArticle(int idx_li, int un_mem) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int dbun_mem = 0;
		String sql = "";
		int result = -1;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select un_mem from food_board where idx_li=?");
			pstmt.setInt(1, idx_li);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbun_mem = rs.getInt("un_mem");
				if(dbun_mem == un_mem) {
					// ������ȣ�� ��ġ�ϸ� �������� ����
					sql = "delete from food_board where idx_li=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, idx_li);
					pstmt.executeUpdate();
					result = 1; // ���� ����
				}else {
					result = 0; // ������ȣ Ʋ��
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
	
	// �Խñ� ��õ�� �ø���
	public int updateRecommend(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;

		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("update food_board set recommend_cnt = recommend_cnt + 1 where idx_li=?");
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
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
