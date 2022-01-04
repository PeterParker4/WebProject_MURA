package board.dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.vo.QABoard;

public class QABoardDAO {
	
	Connection con;
	private static QABoardDAO qaBoardDAO;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public static QABoardDAO getInstance() {
		
		if(qaBoardDAO == null) {
			qaBoardDAO = new QABoardDAO();
		}
		return qaBoardDAO;
	}
	
	public void insertUserArticle(QABoard qaArticle) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int un_mem = qaArticle.getUn_mem();
		int idx_qt = qaArticle.getIdx_qt();
		int wnum_qt = qaArticle.getWnum_qt();
		
		int number = 0;
		
		String sql = "";
		
		try {
			
			pstmt = con.prepareStatement("select max(wnum_ut) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) number = rs.getInt(1) + 1;
			else number = 1;
			
			if(wnum_qt == 0) idx_qt = number;
			
			sql = "insert into user_board(un_mem, idx_qt, wnum_qt, nn_mem, "
					+ "wsubject_qt, wcontent_qt, reply_qt, date_qt) "
					+ "values(?, user_seq.nextval, ?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qaArticle.getUn_mem());
			pstmt.setInt(2, qaArticle.getWnum_qt());
			pstmt.setString(3, qaArticle.getNn_mem());
			pstmt.setString(4, qaArticle.getWsubject_qt());
			pstmt.setString(5, qaArticle.getWcontent_qt());
			pstmt.setString(6, qaArticle.getReply_qt());
			pstmt.setTimestamp(7, qaArticle.getDate_qt());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
	}
	
	public int getUserArticleCount() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			
			pstmt = con.prepareStatement("select count(*) from qa_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return x;
	}
	
	public List<QABoard> getUserArticles(int start, int end){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QABoard> qaArticles = null;
		
		try {
			pstmt = con.prepareStatement("select * from (select rownum rnum, un_mem, idx_qt, wnum_qt, nn_mem, wsubject_qt, "
					+ "wcontent_qt, reply_qt, date_qt from (select * from user_board order by idx_qt desc)) "
					+ "where rnum >= ? and rnum <= ?");
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				qaArticles = new ArrayList<QABoard>(end - start + 1);
				
				do {
					QABoard qaArticle = new QABoard();
					
					qaArticle.setUn_mem(rs.getInt("un_mem"));
					qaArticle.setIdx_qt(rs.getInt("idx_qt"));
					qaArticle.setWnum_qt(rs.getInt("wnum_qt"));
					qaArticle.setNn_mem(rs.getString("nn_mem"));
					qaArticle.setWsubject_qt(rs.getString("wsubject_qt"));
					qaArticle.setWcontent_qt(rs.getString("wcontent_qt"));
					qaArticle.setReply_qt(rs.getString("reply_qt"));
					qaArticle.setDate_qt(rs.getTimestamp("date_qt"));
					
					qaArticles.add(qaArticle);
					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return qaArticles;
	}
	
	
	
	
	
	
	
	
	

}
