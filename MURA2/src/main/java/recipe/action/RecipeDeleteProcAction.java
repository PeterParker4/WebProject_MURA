package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;
import recipe.model.RecipeDAO;

public class RecipeDeleteProcAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String un_mem = request.getParameter("un_mem");
		
		RecipeDAO dbPro = RecipeDAO.getInstance();
		int check = dbPro.deleteArticle(num, un_mem);

		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", check);
		
		return "/page/recipe/recipeDeleteProc.jsp";
	}

}
