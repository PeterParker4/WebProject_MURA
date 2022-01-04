package board.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import board.dao.UserBoardDAO;
import board.vo.UserBoard;

public class UserBoardListService {
	
	public ArrayList<UserBoard> getUserBoardList(int start, int end){
		
		UserBoardDAO userDAO = UserBoardDAO.getInstance();
		Connection con = getConnection();
		
		userDAO.setConnection(con);
		
		ArrayList<UserBoard> userBoardList = (ArrayList<UserBoard>) userDAO.getUserArticles(start, end);
		close(con);
		return userBoardList;
		
	}

}
