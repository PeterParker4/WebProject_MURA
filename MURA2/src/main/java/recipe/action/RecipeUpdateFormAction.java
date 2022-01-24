package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;
import recipe.model.RecipeDAO;
import recipe.model.RecipeVO;

public class RecipeUpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		int idx_li = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		RecipeDAO dbPro = RecipeDAO.getInstance();
		RecipeVO article = dbPro.updateGetArticle(idx_li);
		
		// 세션에서 멤버 정보 불러오기
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO memberInfo = dao.getMember(id_mem);
		
		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("idx_li", new Integer(idx_li));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		request.setAttribute("memberInfo", memberInfo);
		
		return "/page/recipe/recipeUpdateForm.jsp";
	}
	
}
