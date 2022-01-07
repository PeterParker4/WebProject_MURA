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
		String pageNum2 = request.getParameter("pageNum2");
		
		if(pageNum2 == null) {
			pageNum2 = "1";
		}
		
		int pageSize2 = 5;
		int currentPage2 = Integer.parseInt(pageNum2);
		
		int startRow2 = (currentPage2 - 1) * pageSize2 + 1;
		
		int endRow2 = currentPage2 * pageSize2;
		
		int qaCount = 0;
		int number2 = 0;
		
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
		
		number2 = qaCount - (currentPage2 - 1) * pageSize2;
		
		List<QABoard> qaBoardArticleList = null;
		
		QABoardDAO dbPro = QABoardDAO.getInstance();
		qaCount = dbPro.getQaArticleCount();
		
		
	
		if(qaCount > 0) {
			qaBoardArticleList = dbPro.getQaArticles(startRow2, endRow2);
		}else {
			qaBoardArticleList = Collections.emptyList();
		}
		
		
		number2 = qaCount - (currentPage2 - 1) * pageSize2;
		
		request.setAttribute("currentPage2", currentPage2);
		request.setAttribute("startRow2", startRow2);
		request.setAttribute("endRow2", endRow2);
		request.setAttribute("qaCount", qaCount);
		request.setAttribute("pageSize2", pageSize2);
		request.setAttribute("number2", number2);
		request.setAttribute("qaBoardArticleList", qaBoardArticleList);
//		request.setAttribute("find", find);
//		request.setAttribute("find_box", find_box);
		
		
		return "/userboard/qaboardList.jsp";
		
	}

}
