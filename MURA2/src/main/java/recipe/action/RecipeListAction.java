package recipe.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.model.RecipeDAO;
import recipe.model.RecipeVO;

public class RecipeListAction implements CommandAction {

	// �۸�� ó��
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pageNum = request.getParameter("pageNum"); // ������ ��ȣ
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 5; // �� �������� ���� ����
		int currentPage = Integer.parseInt(pageNum);
		
		// �� �������� ���� �� ��ȣ
		int startRow = (currentPage - 1) * pageSize + 1;
		
		// �� �������� ������ �� ��ȣ
		int endRow = currentPage * pageSize;
		
		int count = 0;
		int number = 0;
		
		// �˻�
		String find = null;
		String find_box = null;
		
		find = request.getParameter("find");
		find_box = request.getParameter("find_box");
		
		if(find == null) {
			find = "no";
		}
		
		if(find_box == null) {
			find_box = "no";
		}
		
		List<RecipeVO> articleList = null;
		
		// �����ͺ��̽� ����
		RecipeDAO dbPro = RecipeDAO.getInstance();
		
		count = dbPro.getArticleCount(find, find_box);
		if(count > 0) {
			articleList = dbPro.getArticles(find, find_box, startRow, endRow);
		}else {
			articleList = Collections.emptyList();
		}
		
		// �� ��Ͽ� ǥ���� �۹�ȣ�� �ǹ���
		number = count - (currentPage - 1) * pageSize;
		
		// �ش� �信�� ����� �Ӽ� ����(list.jsp)
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("articleList", articleList);
		request.setAttribute("find", find);
		request.setAttribute("find_box", find_box);
		
		// ���� �� ������ ��Ű ó��
		ArrayList<String> todayRecipeList = new ArrayList<String>();
		
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null) {
			
			for(int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")) {
					todayRecipeList.add(cookieArray[i].getValue());
				}
			}
		}
		
		request.setAttribute("todayImageList", todayRecipeList);
		
		return "/page/recipe/recipeList.jsp";
	}
	
}
