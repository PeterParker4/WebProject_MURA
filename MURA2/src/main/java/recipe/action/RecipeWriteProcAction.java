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

		// 파일 업로드 처리
		/*
		String uploadPath = request.getRealPath("upload");
		int size = 10 * 1024 * 1024; // 10Mbyte
		
		String name = "";
		String subject = "";
		String fileName1 = ""; // 저장된 파일
		String fileName2 = "";
		String origfileName1 = ""; // 실제 파일(사용자가 지정해서 업로드한 원본 파일)
		String origfileName2 = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
			name = multi.getParameter("name");
			subject = multi.getParameter("subject");
			
			Enumeration files = multi.getFileNames();
			
			String file1 = (String)(files.nextElement());
			fileName1 = multi.getFilesystemName(file1);
			origfileName1 = multi.getOriginalFileName(file1);

			String file2 = (String)(files.nextElement());
			fileName2 = multi.getFilesystemName(file2);
			origfileName2 = multi.getOriginalFileName(file2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		MultipartRequest multi = null;
		String savePath = request.getRealPath("/upload"); // 파일이 업로드될 실제 tomcat 폴더의 경로
		int sizeLimit = 10 * 1024 * 1024 ; // 10메가입니다.

		try{ multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new
				DefaultFileRenamePolicy()); }catch (Exception e) { e.printStackTrace(); }

		// 데이터 처리 빈
		RecipeVO article = new RecipeVO();

		/* article.setIdx_li(Integer.parseInt(request.getParameter("idx_li"))); */
		/* article.setNn_mem(request.getParameter("nn_mem")); */
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
