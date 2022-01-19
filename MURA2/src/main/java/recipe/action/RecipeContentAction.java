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

// �� �󼼺��� ó��
public class RecipeContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// �ش� �� ��ȣ
		int num = Integer.parseInt(request.getParameter("num"));
		String thumb_li = request.getParameter("thumb_li");
		
		// �ش� ������ ��ȣ
		String pageNum = request.getParameter("pageNum");
		RecipeDAO dbPro = RecipeDAO.getInstance();
		RecipeVO article = dbPro.getArticle(num);
		
		// ���ǿ��� ��� ���� �ҷ�����
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO memberInfo = dao.getMember(id_mem);
		
		// ��Ű ���� ����
		Cookie todayImageCookie = new Cookie("today"+id_mem, thumb_li);
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		
		
		// �ش� �信�� ����� �Ӽ� ����
		request.setAttribute("num", num);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		request.setAttribute("memberInfo", memberInfo);
		
		return "/page/recipe/recipeContent.jsp";
	}

}
