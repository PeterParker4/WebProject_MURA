package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import recipe.model.RecipeDAO;
import recommend.model.RecommendDAO;

public class RecipeRecommendProcAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");

		// �Ķ���Ͱ� �ҷ�����
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));

		// ���� �ҷ�����
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");

		// DB ó��
		RecommendDAO recommendDAO = RecommendDAO.getInstance();
		RecipeDAO dao = RecipeDAO.getInstance();
		
		recommendDAO.recommendInsert(num, id_mem, board_num);
		dao.updateRecommend(num);
		
		// �ش� �信�� ����� �Ӽ� ����
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));

		return "/page/recipe/recipeRecommendProc.jsp";
		
	}

}
