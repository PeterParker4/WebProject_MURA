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
		
		// 인코딩
		request.setCharacterEncoding("utf-8");

		// 파라미터값 불러오기
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));

		// 세션 불러오기
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");

		// DB 처리
		RecommendDAO recommendDAO = RecommendDAO.getInstance();
		RecipeDAO dao = RecipeDAO.getInstance();
		
		recommendDAO.recommendInsert(num, id_mem, board_num);
		dao.updateRecommend(num);
		
		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));

		return "/page/recipe/recipeRecommendProc.jsp";
		
	}

}
