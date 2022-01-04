package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.QABoardDAO;
import board.vo.QABoard;

public class QABoardListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage - 1) * pageSize + 1;
		
		int endRow = currentPage * pageSize;
		
		int count = 0;
		int number = 0;
		
		/*
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
		*/
		
		List<QABoard> qaArticleList = null;
		
		QABoardDAO dbPro = QABoardDAO.getInstance();
		
		/*
		count = dbPro.getArticleCount(find, find_box);
		if(count > 0) {
			articleList = dbPro.getArticles(find, find_box, startRow, endRow);
		}else {
			articleList = Collections.emptyList();
		}
		*/
		
		number = count - (currentPage - 1) * pageSize;
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("qaCount", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("qaArticleList", qaArticleList);
//		request.setAttribute("find", find);
//		request.setAttribute("find_box", find_box);
		
		
		return "/userboard/list.jsp";
		
		
	}

}
