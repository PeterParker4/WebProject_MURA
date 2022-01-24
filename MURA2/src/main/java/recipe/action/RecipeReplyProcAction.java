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
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// �Ķ���� �� �ҷ�����
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String content_reply = (String) request.getParameter("content_reply");
		
		// ���� �ҷ�����
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");

		// DB ó��
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
		
		// �ش� �信�� ����� �Ӽ� ����
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		return "/page/recipe/recipeReplyProc.jsp";
	}
}
