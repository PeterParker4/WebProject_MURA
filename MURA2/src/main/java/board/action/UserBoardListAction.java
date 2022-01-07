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
		
			String pageNum1 = request.getParameter("pageNum1");
			
			if(pageNum1 == null) {
				pageNum1 = "1";
			}
			
			int pageSize1 = 5;
			int currentPage1 = Integer.parseInt(pageNum1);
			
			int startRow1 = (currentPage1 - 1) * pageSize1 + 1;
			
			int endRow1 = currentPage1 * pageSize1;
			
			int userCount = 0;
			int number1 = 0;
			
			
			String find1 = null;
			String find_box1 = null;
			
			find1 = request.getParameter("find1");
			find_box1 = request.getParameter("find_box1");
			
			if(find1 == null) {
				find1 = "no";
			}
			
			if(find_box1 == null) {
				find_box1 = "no";
			}
			
			
			number1 = userCount - (currentPage1 - 1) * pageSize1;
			
			List<UserBoard> userBoardArticleList = null;
			
			UserBoardDAO dbPro = UserBoardDAO.getInstance();
			/*
			 * userCount = dbPro.getUserArticleCount();
			 * 
			 * if(userCount > 0) { // 현재 페이지에 해당하는 글 목록 userBoardArticleList =
			 * dbPro.getUserArticles(startRow1, endRow1); }else { userBoardArticleList =
			 * Collections.emptyList(); }
			 */
			
			userCount = dbPro.getUserArticleCount(find1, find_box1);
			if(userCount > 0) {
				userBoardArticleList = dbPro.getUserArticles(find1, find_box1, startRow1, endRow1);
			}else {
				userBoardArticleList = Collections.emptyList();
			}
			
			
			request.setAttribute("userBoardArticleList", userBoardArticleList);
			request.setAttribute("currentPage1", currentPage1);
			request.setAttribute("startRow1", startRow1);
			request.setAttribute("endRow1", endRow1);
			request.setAttribute("userCount", userCount);
			request.setAttribute("pageSize1", pageSize1);
			request.setAttribute("number1", number1);
			request.setAttribute("find1", new String(find1));
			request.setAttribute("find_box1", new String(find_box1));
			
			return "/userboard/boardList.jsp";
			
	}

}
