package board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.UserBoardDAO;
import board.vo.UserBoard;

public class UserUpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		
		UserBoard userArticle = new UserBoard();
		
		userArticle.setIdx_ut(Integer.parseInt(request.getParameter("idx_ut")));
		userArticle.setWsubject_ut(request.getParameter("wsubject_ut"));
		userArticle.setWcontent_ut(request.getParameter("wcontent_ut"));
		userArticle.setDate_ut(new Timestamp(System.currentTimeMillis()));
		
		UserBoardDAO dbPro = UserBoardDAO.getInstance();
		int check = dbPro.updateUserArticle(userArticle);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", check);
		
		return "/userboard/userUpdatePro.jsp";
	}

}
