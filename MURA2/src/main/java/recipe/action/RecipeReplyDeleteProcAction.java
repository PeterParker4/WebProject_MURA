package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import recipe.model.RecipeDAO;
import reply.model.ReplyDAO;

public class RecipeReplyDeleteProcAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 값 불러오기
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int idx_reply = Integer.parseInt(request.getParameter("idx_reply"));
		
		// DB 처리
		ReplyDAO replyDAO = new ReplyDAO();
		int check = replyDAO.deleteReply(idx_reply,num);
		
		RecipeDAO dao = RecipeDAO.getInstance();
		dao.deleteReply(num);
		
		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		
		return "/page/recipe/recipeReplyDeleteProc.jsp";
	}
}
