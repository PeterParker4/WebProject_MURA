package board.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.QABoardDAO;
import board.vo.QABoard;

public class QaBoardListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}

		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1;

		int endRow = currentPage * pageSize;

		int qaCount = 0;
		int number = 0;

		String find = null;
		String find_box = null;

		find = request.getParameter("find");
		find_box = request.getParameter("find_box");

		if (find == null) {
			find = "no";
		}

		if (find_box == null) {
			find_box = "no";
		}

		List<QABoard> qaBoardArticleList = null;

		QABoardDAO dbPro = QABoardDAO.getInstance();

		qaCount = dbPro.getQaArticleCount(find, find_box);
		if (qaCount > 0) {
			qaBoardArticleList = dbPro.getQaArticles(find, find_box, startRow, endRow);
		} else {
			qaBoardArticleList = Collections.emptyList();
		}

		number = qaCount - (currentPage - 1) * pageSize;

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("qaCount", qaCount);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("qaBoardArticleList", qaBoardArticleList);
		request.setAttribute("find", find);
		request.setAttribute("find_box", find_box);

		return "/userboard/qaboardList.jsp";

	}

}