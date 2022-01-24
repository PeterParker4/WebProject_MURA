package reply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnUtil;

public class ReplyDAO {
	
	
	public void insertReply(ReplyVO reply, int board_reply) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "";
		
		try {
			
			con = ConnUtil.getConnection();
			
			sql = "insert into reply_board1(idx_reply, board_reply, mem_reply, nn_reply, date_reply, content_reply) "
					+ "values(content_seq.nextval, ?, ?, ?, sysdate, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply.getBoard_reply());
			pstmt.setInt(2, reply.getMem_reply());
			pstmt.setString(3, reply.getNn_reply());
			pstmt.setString(4, reply.getContent_reply());
			
			pstmt.executeUpdate();
			
			// reply counting
			pstmt = con.prepareStatement("update user_board set replycnt_ut=replycnt_ut+1 where idx_ut=?");
			pstmt.setInt(1, board_reply);
			pstmt.executeQuery();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
	
	}
		
	
	public List<ReplyVO> getReply(int board_reply){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReplyVO> replyList = null;
		
		try {
			
			con = ConnUtil.getConnection();
			
			pstmt = con.prepareStatement("select * from reply_board1 where board_reply=? order by idx_reply asc");
			pstmt.setInt(1, board_reply);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				replyList = new ArrayList<ReplyVO>();
				
				do {
					ReplyVO reply = new ReplyVO();
					
					reply.setIdx_reply(rs.getInt("idx_reply"));
					reply.setNn_reply(rs.getString("nn_reply"));
					reply.setMem_reply(rs.getInt("mem_reply"));
					reply.setBoard_reply(rs.getInt("board_reply"));
					reply.setContent_reply(rs.getString("content_reply"));
					reply.setDate_reply(rs.getTimestamp("date_reply"));
					
					replyList.add(reply);
					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException s1) {}
			if(con != null) try {con.close();}catch(SQLException s2) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
		}
		
		return replyList;
	}
	
	public int deleteReply(int idx_reply, int board_reply) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		int result = -1;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select * from reply_board1 where idx_reply=?");
			
			pstmt.setInt(1, idx_reply);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sql = "delete from reply_board1 where idx_reply=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx_reply);
				pstmt.executeUpdate();
				
				pstmt = con.prepareStatement("update user_board set replycnt_ut=replycnt_ut-1 where idx_ut=?");
				pstmt.setInt(1, board_reply);
				pstmt.executeQuery();
				
				result = 1;
			}else result = 0;
			
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
