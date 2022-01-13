package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.vo.QABoard;
import db.ConnUtil;

public class QABoardDAO {
	
private static QABoardDAO instance = null;
	
	public QABoardDAO() {}
	
	public static QABoardDAO getInstance() { // ¿¬°á
		
		if(instance == null) {
			synchronized (QABoardDAO.class) {
				instance = new QABoardDAO();
			}
		}
		return instance;
	}
	
	
	
	public int getQaArticleCount() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from qa_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return x;
	}
	
	public int getQaArticleCount(String find, String find_box) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			
			if(find.equals("nn_mem")) {
				pstmt = con.prepareStatement("select count(*) from qa_board where nn_mem like '%" + find_box + "%'");
			}else if(find.equals("wsubject_qt")) {
				pstmt = con.prepareStatement("select count(*) from qa_board where wsubject_qt like '%" + find_box + "%'");
			}else if(find.equals("wcontent_qt")) {
				pstmt = con.prepareStatement("select count(*) from qa_board where wcontent_qt like '%" + find_box + "%'");
			}else {
				pstmt = con.prepareStatement("select count(*) from qa_board");
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return x;
	}
	
	public List<QABoard> getQaArticles(int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QABoard> qaArticleList = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			pstmt = con.prepareStatement("select * from (select rownum rnum, un_mem, idx_qt, nn_mem, wsubject_qt, "
					+ "wcontent_qt, step_qt, depth_qt, date_qt, readcount_qt, ref_qt from "
					+ "(select * from qa_board order by idx_qt desc, step_qt asc)) "
					+ "where rnum >=? and rnum <=?");
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				qaArticleList = new ArrayList<QABoard>(end - start + 1);
				
				do {
					QABoard qaArticle = new QABoard();
					
					qaArticle.setUn_mem(rs.getInt("un_mem"));
					qaArticle.setIdx_qt(rs.getInt("idx_qt"));
					qaArticle.setNn_mem(rs.getString("nn_mem"));
					qaArticle.setWsubject_qt(rs.getString("wsubject_qt"));
					qaArticle.setWcontent_qt(rs.getString("wcontent_qt"));
					qaArticle.setStep_qt(rs.getInt("step_qt"));
					qaArticle.setDepth_qt(rs.getInt("depth_qt"));
					qaArticle.setDate_qt(rs.getTimestamp("date_qt"));
					qaArticle.setReadcount_qt(rs.getInt("readcount_qt"));
					qaArticle.setRef_qt(rs.getInt("ref_qt"));
					
					qaArticleList.add(qaArticle);
					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return qaArticleList;
	}
	
	
	public List<QABoard> getQaArticles(String find, String find_box, int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QABoard> qaArticleList = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from ");
			sql.append("(select rownum rnum, un_mem, idx_qt, nn_mem, wsubject_qt, wcontent_qt, step_qt, depth_qt, date_qt, readcount_qt, ref_qt from ");
			
			if(find.equals("nn_mem")) {
				sql.append("(select * from qa_board where nn_mem like '%" + find_box + "%' order by idx_qt desc, step_qt asc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else if(find.equals("wsubject_qt")) {
				sql.append("(select * from qa_board where wsubject_qt like '%" + find_box + "%' order by idx_qt desc, step_qt asc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else if(find.equals("wcontent_qt")) {
				sql.append("(select * from qa_board where wcontent_qt like '%" + find_box + "%' order by idx_qt desc, step_qt asc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else {
				sql.append("(select * from qa_board order by idx_qt desc, step_qt asc)) where rnum >=? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);

			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				qaArticleList = new ArrayList<QABoard>(end - start + 1);
				
				do {
					QABoard qaArticle = new QABoard();
					
					qaArticle.setUn_mem(rs.getInt("un_mem"));
					qaArticle.setIdx_qt(rs.getInt("idx_qt"));
					qaArticle.setNn_mem(rs.getString("nn_mem"));
					qaArticle.setWsubject_qt(rs.getString("wsubject_qt"));
					qaArticle.setWcontent_qt(rs.getString("wcontent_qt"));
					qaArticle.setStep_qt(rs.getInt("step_qt"));
					qaArticle.setDepth_qt(rs.getInt("depth_qt"));
					qaArticle.setDate_qt(rs.getTimestamp("date_qt"));
					qaArticle.setReadcount_qt(rs.getInt("readcount_qt"));
					qaArticle.setRef_qt(rs.getInt("ref_qt"));
					
					qaArticleList.add(qaArticle);
					
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return qaArticleList;
	}
	
	public void insertQaArticle(QABoard qaArticle) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int idx_qt = qaArticle.getIdx_qt();
		int ref_qt = qaArticle.getRef_qt();
		int step_qt = qaArticle.getStep_qt();
		int depth_qt = qaArticle.getDepth_qt();
		
		int number = 0;
		
		String sql = "";
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select max(idx_qt) from qa_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) number = rs.getInt(1) + 1;
			else number = 1;
			
			if(idx_qt != 0) {
				sql = "update qa_board set step_qt=step_qt+1 where ref_qt=? and step_qt > ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, ref_qt);
				pstmt.setInt(2, step_qt);
				
				pstmt.executeUpdate();
				
				step_qt += 1;
				depth_qt += 1;
			}else {
				ref_qt = number;
				step_qt = 0;
				depth_qt = 0;
			}
			
			sql = "insert into qa_board(un_mem, idx_qt, nn_mem, wsubject_qt, wcontent_qt, "
					+ "step_qt, depth_qt, date_qt, readcount_qt, ref_qt) "
					+ "values(?, content_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qaArticle.getUn_mem());
			pstmt.setString(2, qaArticle.getNn_mem());
			pstmt.setString(3, qaArticle.getWsubject_qt());
			pstmt.setString(4, qaArticle.getWcontent_qt());
			pstmt.setInt(5, step_qt);
			pstmt.setInt(6, depth_qt);
			pstmt.setTimestamp(7, qaArticle.getDate_qt());
			pstmt.setInt(8, qaArticle.getReadcount_qt());
			pstmt.setInt(9, ref_qt);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
	}
	
	public QABoard getQaArticle(int idx_qt) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QABoard qaArticle = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			pstmt = con.prepareStatement("update qa_board set readcount_qt=readcount_qt+1 where idx_qt=?");
			
			pstmt.setInt(1, idx_qt);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qaArticle = new QABoard();
				qaArticle.setUn_mem(rs.getInt("un_mem"));
				qaArticle.setIdx_qt(rs.getInt("idx_qt"));
				qaArticle.setNn_mem(rs.getString("nn_mem"));
				qaArticle.setWsubject_qt(rs.getString("wsubject_qt"));
				qaArticle.setWcontent_qt(rs.getString("wcontent_qt"));
				qaArticle.setStep_qt(rs.getInt("step_qt"));
				qaArticle.setDepth_qt(rs.getInt("depth_qt"));
				qaArticle.setDate_qt(rs.getTimestamp("date_qt"));
				qaArticle.setReadcount_qt(rs.getInt("readcount_qt"));
				qaArticle.setRef_qt(rs.getInt("ref_qt"));		
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return qaArticle;
	}
	
	
	public QABoard updateGetQaArticle(int idx_qt) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QABoard qaArticle = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			pstmt = con.prepareStatement("select * from qa_board where idx_qt=?");
			
			pstmt.setInt(1, idx_qt);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qaArticle = new QABoard();
				qaArticle.setUn_mem(rs.getInt("un_mem"));
				qaArticle.setIdx_qt(rs.getInt("idx_qt"));
				qaArticle.setNn_mem(rs.getString("nn_mem"));
				qaArticle.setWsubject_qt(rs.getString("wsubject_qt"));
				qaArticle.setWcontent_qt(rs.getString("wcontent_qt"));
				qaArticle.setStep_qt(rs.getInt("step_qt"));
				qaArticle.setDepth_qt(rs.getInt("depth_qt"));
				qaArticle.setDate_qt(rs.getTimestamp("date_qt"));
				qaArticle.setReadcount_qt(rs.getInt("readcount_qt"));
				qaArticle.setRef_qt(rs.getInt("ref_qt"));		
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return qaArticle;
	}
	
	public int updateQaArticle(QABoard qaArticle) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		int result = -1;
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select un_mem from qa_board where idx_qt=?");
			
			pstmt.setInt(1, qaArticle.getIdx_qt());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				if(qaArticle.getUn_mem() != 0) {
					sql = "update qa_board set wsubject_qt=?, wcontent_qt=? where idx_qt=?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, qaArticle.getWsubject_qt());
					pstmt.setString(2, qaArticle.getWcontent_qt());
					pstmt.setInt(3, qaArticle.getIdx_qt());
					
					pstmt.executeUpdate();
					result = 1;
				}else {
					result = 0;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return result;
	}
	
	public int deleteQaArticle(int idx_qt) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		int result = -1;
		
		try {
			
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select un_mem from qa_board where idx_qt=?");
			
			pstmt.setInt(1, idx_qt);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sql = "delete from qa_board where idx_qt=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx_qt);
				pstmt.executeUpdate();
				result = 1;			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		return result;
	}
	
	
	

}