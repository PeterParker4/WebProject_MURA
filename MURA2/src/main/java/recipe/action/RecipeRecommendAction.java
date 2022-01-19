package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import recommend.model.RecommendDAO;

public class RecipeRecommendAction implements CommandAction {

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

		// �޼ҵ� ����
		int check = recommendDAO.recommendChek(num, id_mem, board_num);

		// �ش� �信�� ����� �Ӽ� ����
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("board_num", board_num);
		request.setAttribute("check", check);

		return "/page/recipe/recipeRecommend.jsp";

	}

}
