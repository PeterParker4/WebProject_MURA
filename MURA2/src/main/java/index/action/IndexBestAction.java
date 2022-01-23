package index.action;

	import java.util.Collections;
	import java.util.List;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import action.CommandAction;
	import recipe.model.RecipeDAO;
	import recipe.model.RecipeVO;

	public class IndexBestAction implements CommandAction {

		// 글목록 처리
		@Override
		public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
			
			int count = 0;
			
			// 데이터베이스 연동
			List<RecipeVO> articleList = null;
			List<RecipeVO> articleList2 = null;
			RecipeDAO dbPro = RecipeDAO.getInstance();
			
			count = dbPro.getArticleCount();
			if(count > 0) {
				articleList = dbPro.getArticlesCnt();
				articleList2 = dbPro.getArticlesRecommend();
			}else {
				articleList = Collections.emptyList();
				articleList2 = Collections.emptyList();
			}
			
			request.setAttribute("count", count);
			request.setAttribute("articleList", articleList);
			request.setAttribute("articleList2", articleList2);
			
			return "/page/index.jsp";
		}
		
	}
	
