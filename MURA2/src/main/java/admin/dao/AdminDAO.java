package admin.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.tribes.group.interceptors.StaticMembershipInterceptorMBean;

import admin.vo.AdminVO;
import db.ConnUtil;


public class AdminDAO 
{
	private static AdminDAO instance = null;
	
	public AdminDAO(){}
	
	public static AdminDAO getInstance()
	{
		if(instance==null)
		{
			synchronized (AdminDAO.class) 
			{
				instance = new AdminDAO();
			}
		}
		
		return instance;
	}
		
//	public List<AdminVO> getAdminArticles(int start, int end){
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<AdminVO> adminArticleList = null;
//		
//		try {
//			
//			con = ConnUtil.getConnection();
//			
//			pstmt = con.prepareStatement("select * from (select rownum rnum, un_mem, id_mem, nn_mem, pw_mem, "
//					+ "name_mem, email_mem, gender_mem, tel_mem, zipcode_mem, zc1_mem, zc2_mem, join_mem, date_mem from "
//					+ "(select * from member_board order by un_mem desc)) "
//					+ "where rnum >=? and rnum <=?");
//			
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				
//				adminArticleList = new ArrayList<AdminVO>(end - start + 1);
//				
//				do {
//					AdminVO adminArticle = new AdminVO();
//					
//					adminArticle.setUn_mem(rs.getInt("un_mem"));
//					adminArticle.setId_mem(rs.getString("id_mem"));
//					adminArticle.setNn_mem(rs.getString("nn_mem"));
//					adminArticle.setPw_mem(rs.getString("pw_mem"));
//					adminArticle.setName_mem(rs.getString("name_mem"));
//					adminArticle.setEmail_mem(rs.getString("email_mem"));
//					adminArticle.setGender_mem(rs.getString("gender_mem"));
//					adminArticle.setTel_mem(rs.getString("tel_mem"));
//					adminArticle.setZipcode_mem(rs.getString("zipcode_mem"));
//					adminArticle.setZc1_mem(rs.getString("zc1_mem"));
//					adminArticle.setZc2_mem(rs.getString("zc2_mem"));
//					adminArticle.setJoin_mem(rs.getString("join_mem"));
//					adminArticle.setDate_mem(rs.getString("date_mem"));
//					
//					
//					adminArticleList.add(adminArticle);
//					
//				}while(rs.next());
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(rs != null) try {rs.close();}catch(SQLException s1) {}
//			if(con != null) try {con.close();}catch(SQLException s2) {}
//			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
//		}
//		
//		return adminArticleList;
//	}
//	
//		
//	
//	public int getAdminArticleCount() {
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		int ao = 0;
//		
//		try {
//			
//			con = ConnUtil.getConnection();
//			pstmt = con.prepareStatement("select count(*) from member_board");
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				ao = rs.getInt(1);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(rs != null) try {rs.close();}catch(SQLException s1) {}
//			if(con != null) try {con.close();}catch(SQLException s2) {}
//			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
//		}
//		
//		return ao;
//	}
//	
//	
//	public int getAdminArticleCount(String find, String find_box) {
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		int ao = 0;
//		
//		try {
//			con = ConnUtil.getConnection();
//			
//			if(find.equals("un_mem")) {
//				pstmt = con.prepareStatement("select count(*) from member_board where un_mem like '%" + find_box +"%'");
//			}else if(find.equals("id_mem")) {
//				pstmt = con.prepareStatement("select count(*) from member_board where id_mem like '%"+find_box+"%'");
//			}else if(find.equals("nn_mem")) {
//				pstmt = con.prepareStatement("select count(*) from member_board where nn_mem like '%"+find_box+"%'");
//			}else if(find.equals("name_mem")) {
//				pstmt = con.prepareStatement("select count(*) from member_board where name_mem like '%"+find_box+"%'");
//			}
//			else {
//				pstmt = con.prepareStatement("select count(*) from member_board");
//			}
//			
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				ao = rs.getInt(1);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(rs != null) try {rs.close();}catch(SQLException s1) {}
//			if(con != null) try {con.close();}catch(SQLException s2) {}
//			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
//		}
//		
//		return ao;
//	}
//	
//	
//public List<AdminVO> getAdminArticles(String find, String find_box, int start, int end){
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<AdminVO> adminArticleList = null;
//		
//		try {
//			
//			con = ConnUtil.getConnection();
//			
//			StringBuffer sql = new StringBuffer();
//			sql.append("select * from ");
//			sql.append("(select rownum rnum, un_mem, id_mem, nn_mem, name_mem from ");
//			
//			if(find.equals("un_mem")) {
//				sql.append("(select * from member_board where un_mem like '%" + find_box + "%' order by un_mem desc)) where rnum >=? and rnum <=?");
//				pstmt = con.prepareStatement(sql.toString());
//				pstmt.setInt(1, start);
//				pstmt.setInt(2, end);				
//			}else if(find.equals("id_mem")) {
//				sql.append("(select * from member_board where id_mem like '%" + find_box + "%' order by un_mem desc)) where rnum >=? and rnum <=?");
//				pstmt = con.prepareStatement(sql.toString());
//				pstmt.setInt(1, start);
//				pstmt.setInt(2, end);
//			}else if(find.equals("nn_mem")) {
//				sql.append("(select * from member_board where nn_mem like '%" + find_box + "%' order by un_mem desc)) where rnum >=? and rnum <=?");
//				pstmt = con.prepareStatement(sql.toString());
//				pstmt.setInt(1, start);
//				pstmt.setInt(2, end);
//			}else if(find.equals("name_mem")) {
//				sql.append("(select * from member_board where name_mem like '%" + find_box + "%' order by un_mem desc)) where rnum >=? and rnum <=?");
//				pstmt = con.prepareStatement(sql.toString());
//				pstmt.setInt(1, start);
//				pstmt.setInt(2, end);
//			}else {
//				sql.append("(select * from member_board order by un_mem desc)) where rnum >=? and rnum <=?");
//				pstmt = con.prepareStatement(sql.toString());
//				pstmt.setInt(1, start);
//				pstmt.setInt(2, end);
//			}
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				
//				adminArticleList = new ArrayList<AdminVO>(end - start + 1);
//				
//				do {
//					AdminVO adminArticle = new AdminVO();
//					
//					adminArticle.setUn_mem(rs.getInt("un_mem"));
//					adminArticle.setId_mem(rs.getString("id_mem"));
//					adminArticle.setNn_mem(rs.getString("nn_mem"));
//					adminArticle.setPw_mem(rs.getString("pw_mem"));
//					adminArticle.setName_mem(rs.getString("name_mem"));
//					adminArticle.setEmail_mem(rs.getString("email_mem"));
//					adminArticle.setGender_mem(rs.getString("gender_mem"));
//					adminArticle.setTel_mem(rs.getString("tel_mem"));
//					adminArticle.setZipcode_mem(rs.getString("zipcode_mem"));
//					adminArticle.setZc1_mem(rs.getString("zc1_mem"));
//					adminArticle.setZc2_mem(rs.getString("zc2_mem"));
//					adminArticle.setJoin_mem(rs.getString("join_mem"));
//					adminArticle.setDate_mem(rs.getString("date_mem"));
//					
//					
//					adminArticleList.add(adminArticle);
//					
//				}while(rs.next());
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(rs != null) try {rs.close();}catch(SQLException s1) {}
//			if(con != null) try {con.close();}catch(SQLException s2) {}
//			if(pstmt != null) try {pstmt.close();}catch(SQLException s3) {}
//		}
//		
//		return adminArticleList;
//	}
//	
//	
	
	
	
	
	
	
	
}
