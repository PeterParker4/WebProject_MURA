package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import board.dao.QABoardDAO;
import board.vo.QABoard;
import member.model.MemberDAO;

public class QaContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		try {
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
			
		if(id_mem != null) {
			MemberDAO dao = new MemberDAO();
			String nn_mem = dao.getMember(id_mem).getNn_mem(); 
			int un_mem = dao.getMember(id_mem).getUn_mem();
			request.setAttribute("nn_mem", nn_mem);
			request.setAttribute("un_mem", un_mem);
		}
		int idx_qt = Integer.parseInt(request.getParameter("idx_qt"));
		String pageNum = request.getParameter("pageNum");
		
		QABoardDAO dbPro = QABoardDAO.getInstance();
		QABoard qaArticle = dbPro.getQaArticle(idx_qt);
		
		request.setAttribute("idx_qt", idx_qt);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("qaArticle", qaArticle);
		}catch(Exception e) {}
		return "/userboard/qaContent.jsp";
	}

}