package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.UserBoardDAO;

public class UserDeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int idx_ut = Integer.parseInt(request.getParameter("idx_ut"));
		String pageNum = request.getParameter("pageNum");

		UserBoardDAO dbPro = UserBoardDAO.getInstance();
		
		int check = dbPro.deleteUserArticle(idx_ut);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		
		return "/userboard/userDeletePro.jsp";
	}

}
