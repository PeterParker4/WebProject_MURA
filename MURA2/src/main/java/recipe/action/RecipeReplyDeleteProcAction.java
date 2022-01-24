package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import recipe.model.RecipeDAO;
import reply.model.ReplyDAO;

public class RecipeReplyDeleteProcAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// �Ķ���� �� �ҷ�����
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int idx_reply = Integer.parseInt(request.getParameter("idx_reply"));
		
		// DB ó��
		ReplyDAO replyDAO = new ReplyDAO();
		int check = replyDAO.deleteReply(idx_reply,num);
		
		RecipeDAO dao = RecipeDAO.getInstance();
		dao.deleteReply(num);
		
		// �ش� �信�� ����� �Ӽ� ����
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		
		return "/page/recipe/recipeReplyDeleteProc.jsp";
	}
}
