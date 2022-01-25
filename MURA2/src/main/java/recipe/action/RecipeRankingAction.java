package recipe.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import recipe.model.RecipeDAO;
import recipe.model.RecipeVO;

public class RecipeRankingAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// ���ǿ��� ��� ���� �ҷ�����
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");

		int count = 0;
		
		// �����ͺ��̽� ����
		List<RecipeVO> articleList = null;
		List<RecipeVO> articleList2 = null;
		List<RecipeVO> articleList3 = null;
		RecipeDAO dbPro = RecipeDAO.getInstance();
		
		count = dbPro.getArticleCount();
		if(count > 0) {
			articleList = dbPro.getArticlesCnt();
			articleList2 = dbPro.getArticlesRecommend();
			articleList3 = dbPro.getArticlesReply();
		}else {
			articleList = Collections.emptyList();
			articleList2 = Collections.emptyList();
			articleList3 = Collections.emptyList();
		}
		
		// �ش� �信�� ����� �Ӽ� ����
		request.setAttribute("id_mem", id_mem);
		request.setAttribute("count", count);
		request.setAttribute("articleList", articleList);
		request.setAttribute("articleList2", articleList2);
		request.setAttribute("articleList3", articleList3);
		
		return "/page/recipe/recipeRanking.jsp";
	}
}
