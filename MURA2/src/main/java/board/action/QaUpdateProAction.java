package board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.QABoardDAO;
import board.vo.QABoard;

public class QaUpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		
		QABoard qaArticle = new QABoard();
		
		qaArticle.setIdx_qt(Integer.parseInt(request.getParameter("idx_qt")));
		qaArticle.setWsubject_qt(request.getParameter("wsubject_qt"));
		qaArticle.setWcontent_qt(request.getParameter("wcontent_qt"));
		qaArticle.setDate_qt(new Timestamp(System.currentTimeMillis()));
		
		QABoardDAO dbPro = QABoardDAO.getInstance();
		int check = dbPro.updateQaArticle(qaArticle);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", check);
		
		return "/userboard/qaUpdatePro.jsp";
	}

}
