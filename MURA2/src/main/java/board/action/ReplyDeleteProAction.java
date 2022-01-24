package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import reply.model.ReplyDAO;

public class ReplyDeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		try {
		request.setCharacterEncoding("utf-8");
		
		int idx_reply = Integer.parseInt(request.getParameter("idx_reply"));
		String pageNum = request.getParameter("pageNum");
		int board_reply = Integer.parseInt(request.getParameter("idx_ut")); 
		
		ReplyDAO replyDAO = new ReplyDAO();
		int check = replyDAO.deleteReply(idx_reply,board_reply);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		request.setAttribute("board_reply", board_reply);
		
		}catch(Exception e) {e.printStackTrace();}
		return "/userboard/replyDeletePro.jsp";
	}

}
