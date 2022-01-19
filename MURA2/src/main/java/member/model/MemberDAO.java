package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import db.ConnUtil;

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

	/*
	 * public Connection getConnection() {
	 * 
	 * Connection con = null;
	 * 
	 * try { InitialContext ctx = new InitialContext(); DataSource ds = (DataSource)
	 * ctx.lookup("java:comp/env/jdbc/mydb"); con = ds.getConnection(); } catch
	 * (Exception e) { System.out.println("디비 연결 실패"); } return con; }
	 */

	// id, pass 맞으면 1, pass만 틀리면 0, id 없으면 -1 (지금 안먹음)
	public int loginCheck(String id_mem, String pw_mem) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1; // (결과값이 나오지 않으니까) 아이디 없음

		try {

			con = ConnUtil.getConnection();
			String sql = "select pw_mem from member_board where id_mem=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id_mem);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				if (rs.getString(1).equals(pw_mem)) {
					result = 1; // 로그인 성공
					System.out.println("db연결성공, 로그인성공");
				} else {
					result = 0; // 비밀번호 불일치
				}
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (Exception ee) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception ee) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (Exception ee) {
				}
		}

		return result;
	}

	// 회원가입시 회원가입 정보 입력
	public boolean memberInsert(MemberVO vo) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = ConnUtil.getConnection();
			String sql = "insert into member_board values(content_seq.nextval,default,?,?,?,?,?,?,?,?,?,?,'Y',sysdate)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getId_mem());
			pstmt.setString(2, vo.getNn_mem());
			pstmt.setString(3, vo.getPw_mem());
			pstmt.setString(4, vo.getName_mem());
			pstmt.setString(5, vo.getEmail_mem());
			pstmt.setString(6, vo.getGender_mem());
			pstmt.setString(7, vo.getTel_mem());
			pstmt.setString(8, vo.getZipcode_mem());
			pstmt.setString(9, vo.getZc1_mem());
			pstmt.setString(10, vo.getZc2_mem());

			int count = pstmt.executeUpdate();

			if (count > 0)
				result = true; // 쿼리문 실행이 돼서 true=성공으로 반환

		} catch (Exception e) {
			System.out.println("Exception" + e);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException se) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException se) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
				}
		}
		return result;

	}

	// 회원가입시 id 중복확인 메소드
	public boolean idCheck(String id_mem) {

		boolean result = true; // 아이디 중복

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnUtil.getConnection();
			String sql = "select * from member_board where id_mem=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id_mem);

			rs = pstmt.executeQuery();

			if (!rs.next())
				result = false; // 아이디 중복 아님

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException se) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException se) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
				}
		}

		return result;
	}

	// 우편번호를 데이터 베이스에서 검색해서 Vector에 담아서 리턴해주는 기능을 DAO에 추가

	public Vector<ZipcodeVO> zipcodeRead(String dong) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Vector<ZipcodeVO> vecList = new Vector<ZipcodeVO>();

		try {

			String sql = "select * from zipcode where dong like '" + dong + "%'";
			con = ConnUtil.getConnection();

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ZipcodeVO tempZipcode = new ZipcodeVO();

				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setRi(rs.getString("ri"));
				tempZipcode.setBunji(rs.getString("bunji"));

				// 벡터에 추가
				vecList.addElement(tempZipcode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException se) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException se) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
				}
		}
		return vecList;
	}

	// 아이디 찾기 메소드
	public String findId(String name_mem, String email_mem) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id_mem = null;

		try {

			con = ConnUtil.getConnection();
			String sql = "select id_mem from member_board where name_mem=? and email_mem=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name_mem);
			pstmt.setString(2, email_mem);

			rs = pstmt.executeQuery();

			if (rs.next())
				id_mem = rs.getString("id_mem");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException se) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException se) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
				}
		}
		return id_mem;
	}

	// 비밀번호 찾기 메소드
	public String findPw(String name_mem, String id_mem, String email_mem) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pw_mem = null;

		try {

			con = ConnUtil.getConnection();
			String sql = "select pw_mem from member_board where name_mem=? and id_mem=? and email_mem=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name_mem);
			pstmt.setString(2, id_mem);
			pstmt.setString(3, email_mem);

			rs = pstmt.executeQuery();

			if (rs.next())
				pw_mem = rs.getString("pw_mem");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException se) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException se) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
				}
		}
		return pw_mem;
	}

	// 회원 정보를 불러오는 메소드
	public MemberVO getMember(String id_mem) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO memberInfo = null;

		try {
			con = ConnUtil.getConnection();
			String sql = "select * from member_board where id_mem=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id_mem);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberInfo = new MemberVO();
				memberInfo.setUn_mem(rs.getInt("un_mem"));
				memberInfo.setAdmin_mem(rs.getString("admin_mem"));
				memberInfo.setId_mem(rs.getString("id_mem"));
				memberInfo.setNn_mem(rs.getString("nn_mem"));
				memberInfo.setPw_mem(rs.getString("pw_mem"));
				memberInfo.setName_mem(rs.getString("name_mem"));
				memberInfo.setEmail_mem(rs.getString("email_mem"));
				memberInfo.setGender_mem(rs.getString("gender_mem"));
				memberInfo.setTel_mem(rs.getString("tel_mem"));
				memberInfo.setZipcode_mem(rs.getString("zipcode_mem"));
				memberInfo.setZc1_mem(rs.getString("zc1_mem"));
				memberInfo.setZc2_mem(rs.getString("zc2_mem"));
				memberInfo.setJoin_mem(rs.getString("join_mem"));
				memberInfo.setDate_mem(rs.getTimestamp("Date_mem"));
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
		return memberInfo;
	}

	// 정보 수정 버튼 클릭시 데이터 베이스에 update를 수행해야함
	// 정보수정을 처리해줄 메소드
	public boolean updateMember(MemberVO vo) {

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {

			con = ConnUtil.getConnection();
			String sql = "update member_board set nn_mem=?, pw_mem=?, name_mem=?, email_mem=?, gender_mem=?, tel_mem=?, zipcode_mem=?, zc1_mem=?, zc2_mem=? where id_mem=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getNn_mem());
			pstmt.setString(2, vo.getPw_mem());
			pstmt.setString(3, vo.getName_mem());
			pstmt.setString(4, vo.getEmail_mem());
			pstmt.setString(5, vo.getGender_mem());
			pstmt.setString(6, vo.getTel_mem());
			pstmt.setString(7, vo.getZipcode_mem());
			pstmt.setString(8, vo.getZc1_mem());
			pstmt.setString(9, vo.getZc2_mem());
			pstmt.setString(10, vo.getId_mem());

			if (pstmt.executeUpdate() > 0)
				result = true;

		} catch (Exception e) {
			System.out.println("Exception " + e);
		} finally {

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
		return result; // update 성공 여부 추가
	}

	// 회원 탈퇴 처리 메소드
	public int deleteMember(String id_mem, String pw_mem) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPw_mem = ""; // 데이터베이스에 저장되어있는 비밀번호
		int result = -1;

		try {
			con = ConnUtil.getConnection();

			String sql = "select pw_mem from member_board where id_mem=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id_mem);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbPw_mem = rs.getString("pw_mem");
				System.out.println(dbPw_mem); // 확인용
				if (dbPw_mem.equals(pw_mem)) {
					String delSql = "delete from member_board where id_mem=?";
					pstmt = con.prepareStatement(delSql);
					pstmt.setString(1, id_mem);
					pstmt.executeUpdate();
					result = 1; // 회원탈퇴 성공
				} else {
					result = 0; // 비밀번호 오류
				}
			}
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Exception " + e);
		} finally {

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

		return result;
	}

	// 관리자 로그인 메소드
	/*public int adminloginCheck(String id_mem, String pw_mem) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1; // (결과값이 나오지 않으니까) 아이디 없음

		try {

			con = ConnUtil.getConnection();
			String sql = "select admin_mem from member_board where id_mem=? and pw_mem=?";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				if (rs.getString(1).equals("Y")) { // Y이면 관리자니까
					result = 1; // 로그인 성공
					System.out.println("관리자로그인성공");
				} else {
					result = 0; // 비밀번호 불일치
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (Exception ee) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception ee) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (Exception ee) {
				}
		}

		return result;
	} */
	
}
