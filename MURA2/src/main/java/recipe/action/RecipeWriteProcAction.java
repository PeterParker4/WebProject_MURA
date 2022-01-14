package recipe.action;

import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;
import recipe.model.*;

// 입력된 글처리
public class RecipeWriteProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");

		// 파일 업로드 처리
		String realFolder = "";
		String saveFolder = "/page/recipe/upload";
		String encType = "utf-8";
		int maxSize = 10 * 1024 * 1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		// 데이터 처리 빈
		RecipeVO article = new RecipeVO();

		//set
		/* article.setIdx_li(Integer.parseInt(request.getParameter("idx_li"))); */
		article.setUn_mem(Integer.parseInt(multi.getParameter("un_mem")));
		article.setPw_mem(multi.getParameter("pw_mem"));
		article.setNn_mem(multi.getParameter("nn_mem"));
		article.setCategory_li(multi.getParameter("category_li"));
		article.setWsubject_li(multi.getParameter("wsubject_li"));
		article.setTag_li(multi.getParameter("tag_li"));
		article.setThumb_li(multi.getFilesystemName("thumb_li"));
		article.setWcontent_li(multi.getParameter("wcontent_li"));
		article.setDate_li(new Timestamp(System.currentTimeMillis()));

		// 데이터베이스 처리
		RecipeDAO dbPro = RecipeDAO.getInstance();
		dbPro.insertArticle(article);
		
		// 사용할 뷰
		return "/page/recipe/recipeWriteProc.jsp";
	}

}
