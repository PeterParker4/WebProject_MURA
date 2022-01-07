package recipe.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import recipe.model.*;

// 입력된 글처리
public class RecipeWriteProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 데이터 처리 빈
		RecipeVO article = new RecipeVO();
		
		article.setWnum_li(Integer.parseInt(request.getParameter("wnum_li")));
		article.setNn_mem(request.getParameter("nn_mem"));
		article.setCategory_li(request.getParameter("category_li"));
		article.setWsubject_li(request.getParameter("wsubject_li"));
		article.setTag_li(request.getParameter("tag_li"));
		article.setThumb_li(request.getParameter("thumb_li"));
		article.setWcontent_li(request.getParameter("wcontent_li"));
		article.setDate_li(new Timestamp(System.currentTimeMillis()));
		
		// 데이터베이스 처리
		RecipeDAO dbPro = RecipeDAO.getInstance();
		dbPro.insertArticle(article);
		
		// 파일 업로드 처리
		/*
		 * MultipartRequest multi = null;
		 * 
		 * int sizeLimit = 10 * 1024 * 1024 ; // 10메가입니다.
		 * 
		 * String savePath = request.getRealPath("/upload"); // 파일이 업로드될 실제 tomcat 폴더의
		 * WebContent 기준
		 * 
		 * try{ multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new
		 * DefaultFileRenamePolicy()); }catch (Exception e) { e.printStackTrace(); }
		 * 
		 * String filename = multi.getFilesystemName("filename"); String title =
		 * multi.getParameter("title"); String writer = multi.getParameter("writer");
		 * 
		 * int count = 0;
		 * 
		 * String content = multi.getParameter("content");
		 * 
		 * String regip = request.getRemoteAddr();
		 */


		
		
		// 사용할 뷰
		return "/page/recipe/recipeWriteProc.jsp";
	}

}
