package board.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.UserBoardDAO;
import board.vo.UserBoard;

public class UserBoardListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
			request.setCharacterEncoding("utf-8");
			
			String pageNum = request.getParameter("pageNum");
			
			if(pageNum == null) {
				pageNum = "1";
			}
			
			int pageSize = 5;
			int currentPage = Integer.parseInt(pageNum);
			
			int startRow = (currentPage - 1) * pageSize + 1;
			
			int endRow = currentPage * pageSize;
			
			int userCount = 0;
			int number = 0;
			
			
			String find = null;
			String find_box = null;
			
			find = request.getParameter("find");
			find_box = request.getParameter("find_box");
			
			if(find == null) {
				find = "no";
			}
			
			if(find_box == null) {
				find_box = "no";
			}
			
			List<UserBoard> userBoardArticleList = null;
			
			UserBoardDAO dbPro = UserBoardDAO.getInstance();
			
			userCount = dbPro.getUserArticleCount(find, find_box);
			if(userCount > 0) {
				userBoardArticleList = dbPro.getUserArticles(find, find_box, startRow, endRow);
			}else {
				userBoardArticleList = Collections.emptyList();
			}
			
			number = userCount - (currentPage - 1) * pageSize;
			
			request.setAttribute("userBoardArticleList", userBoardArticleList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startRow", startRow);
			request.setAttribute("endRow", endRow);
			request.setAttribute("userCount", userCount);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("number", number);
			request.setAttribute("find", new String(find));
			request.setAttribute("find_box", new String(find_box));
			
			return "/userboard/boardList.jsp";
			
	}

}