package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.QABoardDAO;
import board.vo.QABoard;

public class QaContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int idx_qt = Integer.parseInt(request.getParameter("idx_qt"));
		String pageNum = request.getParameter("pageNum");
		
		QABoardDAO dbPro = QABoardDAO.getInstance();
		QABoard qaArticle = dbPro.getQaArticle(idx_qt);
		
		request.setAttribute("idx_qt", idx_qt);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("qaArticle", qaArticle);
		
		return "/userboard/qaContent.jsp";
	}

}