package board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.UserBoardDAO;
import board.vo.UserBoard;

public class UserWriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		UserBoard userArticle = new UserBoard();
		
		userArticle.setUn_mem(Integer.parseInt(request.getParameter("un_mem")));
		userArticle.setIdx_ut(Integer.parseInt(request.getParameter("idx_ut")));
		userArticle.setNn_mem(request.getParameter("nn_mem"));
		userArticle.setWsubject_ut(request.getParameter("wsubject_ut"));
		userArticle.setWcontent_ut(request.getParameter("wcontent_ut"));
		userArticle.setDate_ut(new Timestamp(System.currentTimeMillis()));
		
		UserBoardDAO dbPro = UserBoardDAO.getInstance();
		dbPro.insertUserArticle(userArticle);
		
		return "/userboard/userWritePro.jsp";
	}

}
