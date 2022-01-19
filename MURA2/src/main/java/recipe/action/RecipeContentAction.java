package recipe.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;
import recipe.model.RecipeDAO;
import recipe.model.RecipeVO;

// 글 상세보기 처리
public class RecipeContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 해당 글 번호
		int num = Integer.parseInt(request.getParameter("num"));
		String thumb_li = request.getParameter("thumb_li");
		
		// 해당 페이지 번호
		String pageNum = request.getParameter("pageNum");
		RecipeDAO dbPro = RecipeDAO.getInstance();
		RecipeVO article = dbPro.getArticle(num);
		
		// 세션에서 멤버 정보 불러오기
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO memberInfo = dao.getMember(id_mem);
		
		// 쿠키 정보 저장
		Cookie todayImageCookie = new Cookie("today"+id_mem, thumb_li);
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		
		
		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("num", num);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		request.setAttribute("memberInfo", memberInfo);
		
		return "/page/recipe/recipeContent.jsp";
	}

}
