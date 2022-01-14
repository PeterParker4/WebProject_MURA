package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import recipe.model.RecipeDAO;
import recipe.model.RecipeVO;

public class RecipeUpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		RecipeDAO dbPro = RecipeDAO.getInstance();
		RecipeVO article = dbPro.updateGetArticle(num);
		
		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/page/recipe/recipeUpdateForm.jsp";
	}
	
}
