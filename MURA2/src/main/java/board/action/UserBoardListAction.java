package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.svc.UserBoardListService;
import vo.ActionForward;
import board.vo.UserBoard;
import board.dao.UserBoardDAO;
import java.util.ArrayList;

public class UserBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserBoardListService userBoardListService = new UserBoardListService();
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 7;
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage - 1) * pageSize + 1;
		
		int endRow = currentPage * pageSize;
		
		int count = 0;
		int number = 0;
		
		number = count - (currentPage - 1) * pageSize;
		
		
		ArrayList<UserBoard> userBoardList = userBoardListService.getUserBoardList(startRow, endRow);
		
		request.setAttribute("userBoardList", userBoardList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("userCount", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		
		ActionForward forward = new ActionForward("list.jsp",false);
		
		return forward;
	}

}
