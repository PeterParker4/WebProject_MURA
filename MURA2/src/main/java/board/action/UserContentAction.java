package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import board.dao.UserBoardDAO;
import board.vo.UserBoard;
import member.model.MemberDAO;
import reply.model.ReplyDAO;
import reply.model.ReplyVO;

public class UserContentAction implements CommandAction {

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
		
		int idx_ut = Integer.parseInt(request.getParameter("idx_ut"));
		String pageNum = request.getParameter("pageNum");
		
		UserBoardDAO dbPro = UserBoardDAO.getInstance();
		UserBoard userArticle = dbPro.getUserArticle(idx_ut);
		
		ReplyDAO replyDAO = new ReplyDAO();
		List<ReplyVO> replyList = null;
		replyList = replyDAO.getReply(idx_ut);
		
		request.setAttribute("idx_ut", idx_ut);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("userArticle", userArticle);
		request.setAttribute("replyList", replyList);
		
		}catch(Exception e) {}
		return "/userboard/userContent.jsp";
	}

}
