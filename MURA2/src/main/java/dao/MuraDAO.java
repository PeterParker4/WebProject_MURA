package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.MuraVO;

public class MuraDAO {
	Connection con;
	private static MuraDAO dogDAO;

	public void setConnection(Connection con) {
		this.con = con;
	}

	public static MuraDAO getInstance() {
		if (dogDAO == null) {
			dogDAO = new MuraDAO();
		}
		return dogDAO;
	}

	// 이곳부터는 메소드 추가구현.
	

}