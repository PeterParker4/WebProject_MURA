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

	public static RecipeDAO getInstance() { // 연결
		if (instance == null) {
			synchronized (RecipeDAO.class) {
				instance = new RecipeDAO();
			}
		}
		return instance;
	}

	// 이곳에 게시판 작업의 기능들을 하나하나 추가하는 메소드를 작성

	// 전체 글의 개수를 가져올 메소드 구현
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

	// 검색되어 출력된 글의 개수를 가져올 메소드 구현
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
	
	// index에서 가져올 메소드 구현 (List로 구현)
	// 인덱스 조회수순으로 글 가져오기
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

	// 인덱스 추천순으로 글 가져오기
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

	// food_board table에서 가져올 메소드 구현 (List로 구현)
	// 검색할 내용을 리스트로 받아옴(what:검색 조건, content:검색 내용, start:시작번호,end:끝번호)
	public List<RecipeVO> getArticles(int start, int end) {// 수정1

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

			// 수정3
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<RecipeVO>(end - start + 1); // 수정4
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
				articleList = new ArrayList<RecipeVO>(end - start + 1); // 수정4
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

	// 이곳에 게시판 작업의 기능들을 하나하나 메소드로 추가하면 됨
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
			
			if(rs.next()) number = rs.getInt(1) + 1; // 새글
			else number = 1; // 새글이 아닌 경우
			
			// 새글을 추가하는 쿼리 작성
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
	
	/* 글 제목을 누르면 글 내용을 볼 수 있도록 해야함
	 * 
	 * 우리는 글 num을 매개변수로 해서 하나의 글에 대한 세부정보를 데이터베이스에 가져와야함
	 * 데이터베이스에서 글 하나의 정보를 가져올 메소드를 구현
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
	
	/* 글 상세보기 화면에서 [글수정] 버튼을 누를 경우 updateForm.jsp로 이동하도록 링크를 걸었으므로 
	 * 글 수정 화면을 설계해야 함
	 * 
	 * 글 수정시에는 글목록 보기와 다르게 조회수를 증가시킬 필요가 없음
	 * 
	 * 조회수를 증가시키는 부분을 제외하고 num에 해당하는 글을 가져오는 메소드 구현
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
	
	/* 데이터베이스에서 실제 수정 처리가 되어야함
	 * 글을 수정처리 할 메소드 구현
	 * 글이 없을 때 -1, 글 수정 성공 1, 글 수정 실패 : 0
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
					// 유저번호가 일치하면 수정쿼리 실행
					sql = "update food_board set category_li=?, wsubject_li=?, tag_li=?, wcontent_li=?, thumb_li=? where idx_li=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getCategory_li());
					pstmt.setString(2, article.getWsubject_li());
					pstmt.setString(3, article.getTag_li());
					pstmt.setString(4, article.getWcontent_li());
					pstmt.setString(5, article.getThumb_li());
					pstmt.setInt(6, article.getIdx_li());
					pstmt.executeUpdate();
					result = 1; // 수정 성공
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
	 
	/* 글 삭제 처리
	 * 
	 * 데이터베이스에서 비밀번호를 비교하여 실제로 삭제를 수행해 줄 메소드를 구현함
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
					// 유저번호가 일치하면 수정쿼리 실행
					sql = "delete from food_board where idx_li=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, idx_li);
					pstmt.executeUpdate();
					result = 1; // 삭제 성공
				}else {
					result = 0; // 유저번호 틀림
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
	
	// 게시글 추천수 올리기
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
