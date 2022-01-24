package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import recipe.model.RecipeDAO;
import reply.model.ReplyDAO;
import reply.model.ReplyVO;

public class RecipeReplyProcAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 값 불러오기
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String content_reply = (String) request.getParameter("content_reply");
		
		// 세션 불러오기
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");

		// DB 처리
		MemberDAO memberDAO = new MemberDAO();
		String nn_reply = memberDAO.getMember(id_mem).getNn_mem();
		int mem_reply = memberDAO.getMember(id_mem).getUn_mem();

		ReplyDAO replyDAO = new ReplyDAO();
		ReplyVO replyVO = new ReplyVO();

		replyVO.setNn_reply(nn_reply); 
		replyVO.setMem_reply(mem_reply);
		replyVO.setContent_reply(content_reply); 
		replyVO.setBoard_reply(num);
		replyDAO.insertReply(replyVO, num);
		
		RecipeDAO dao = RecipeDAO.getInstance();
		dao.updateReply(num);
		
		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		return "/page/recipe/recipeReplyProc.jsp";
	}
}
