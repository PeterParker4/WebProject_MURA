package recipe.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import recipe.model.*;

// �Էµ� ��ó��
public class RecipeWriteProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// ������ ó�� ��
		RecipeVO article = new RecipeVO();
		
		article.setWnum_li(Integer.parseInt(request.getParameter("wnum_li")));
		article.setNn_mem(request.getParameter("nn_mem"));
		article.setCategory_li(request.getParameter("category_li"));
		article.setWsubject_li(request.getParameter("wsubject_li"));
		article.setTag_li(request.getParameter("tag_li"));
		article.setThumb_li(request.getParameter("thumb_li"));
		article.setWcontent_li(request.getParameter("wcontent_li"));
		article.setDate_li(new Timestamp(System.currentTimeMillis()));
		
		// �����ͺ��̽� ó��
		RecipeDAO dbPro = RecipeDAO.getInstance();
		dbPro.insertArticle(article);
		
		// ����� ��
		return "/page/recipe/recipeWriteProc.jsp";
	}

}
