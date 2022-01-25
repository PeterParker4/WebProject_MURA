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
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 세션에서 멤버 정보 불러오기
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");

		int count = 0;
		
		// 데이터베이스 연동
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
		
		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("id_mem", id_mem);
		request.setAttribute("count", count);
		request.setAttribute("articleList", articleList);
		request.setAttribute("articleList2", articleList2);
		request.setAttribute("articleList3", articleList3);
		
		return "/page/recipe/recipeRanking.jsp";
	}
}
