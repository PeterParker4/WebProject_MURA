package recipe.action;

import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.model.MemberDAO;
import member.model.MemberVO;
import recipe.model.RecipeDAO;
import recipe.model.RecipeVO;

public class RecipeUpdateProcAction implements CommandAction{

		@Override
		public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
			
			// ���ڵ�
			request.setCharacterEncoding("utf-8");
			
			// ���� ���ε� ó��
			String realFolder = "";
			String saveFolder = "/page/recipe/upload";
			String encType = "utf-8";
			int maxSize = 10 * 1024 * 1024;
			
			ServletContext context = request.getServletContext();
			realFolder = context.getRealPath(saveFolder);
			
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			
			// ������ ó�� ��
			RecipeVO article = new RecipeVO();
			
			//set
			article.setIdx_li(Integer.parseInt(request.getParameter("idx_li")));
			article.setCategory_li(multi.getParameter("category_li"));
			article.setWsubject_li(multi.getParameter("wsubject_li"));
			article.setTag_li(multi.getParameter("tag_li"));
			article.setThumb_li(multi.getFilesystemName("thumb_li"));
			article.setWcontent_li(multi.getParameter("wcontent_li"));
			article.setDate_li(new Timestamp(System.currentTimeMillis()));
			
			// �����ͺ��̽� ó��
			RecipeDAO dbPro = RecipeDAO.getInstance();
			
			int check = dbPro.updateArticle(article);
			
			// �信�� ����� ��Ʈ����Ʈ ����
			String pageNum = request.getParameter("pageNum");
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("check", new Integer(check));
			
			// ����� ��
			return "/page/recipe/recipeUpdateProc.jsp";
		}
}
