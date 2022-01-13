package board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.dao.QABoardDAO;
import board.vo.QABoard;

public class QaWriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		QABoard qaArticle = new QABoard();
		
		/* qaArticle.setUn_mem(Integer.parseInt(request.getParameter("un_mem"))); */
		qaArticle.setIdx_qt(Integer.parseInt(request.getParameter("idx_qt")));
		qaArticle.setNn_mem(request.getParameter("nn_mem"));
		qaArticle.setWsubject_qt(request.getParameter("wsubject_qt"));
		qaArticle.setWcontent_qt(request.getParameter("wcontent_qt"));
		qaArticle.setStep_qt(Integer.parseInt(request.getParameter("step_qt")));
		qaArticle.setDepth_qt(Integer.parseInt(request.getParameter("depth_qt")));
		qaArticle.setDate_qt(new Timestamp(System.currentTimeMillis()));
		qaArticle.setRef_qt(Integer.parseInt(request.getParameter("ref_qt")));

		QABoardDAO dbPro = QABoardDAO.getInstance();
		dbPro.insertQaArticle(qaArticle);
		
		return "/userboard/qaWritePro.jsp";
	}

}
