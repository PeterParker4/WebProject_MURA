package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.QABoardDAO;

public class QaDeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int idx_qt = Integer.parseInt(request.getParameter("idx_qt"));
		String pageNum = request.getParameter("pageNum");

		QABoardDAO dbPro = QABoardDAO.getInstance();
		int check = dbPro.deleteQaArticle(idx_qt);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		
		return "/userboard/qaDeletePro.jsp";
	}

}
