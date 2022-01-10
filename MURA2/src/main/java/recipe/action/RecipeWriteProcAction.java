package recipe.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import recipe.model.*;

// �Էµ� ��ó��
public class RecipeWriteProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");

		// ���� ���ε� ó��
		/*
		String uploadPath = request.getRealPath("upload");
		int size = 10 * 1024 * 1024; // 10Mbyte
		
		String name = "";
		String subject = "";
		String fileName1 = ""; // ����� ����
		String fileName2 = "";
		String origfileName1 = ""; // ���� ����(����ڰ� �����ؼ� ���ε��� ���� ����)
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
		String savePath = request.getRealPath("/upload"); // ������ ���ε�� ���� tomcat ������ ���
		int sizeLimit = 10 * 1024 * 1024 ; // 10�ް��Դϴ�.

		try{ multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new
				DefaultFileRenamePolicy()); }catch (Exception e) { e.printStackTrace(); }

		// ������ ó�� ��
		RecipeVO article = new RecipeVO();

		/* article.setIdx_li(Integer.parseInt(request.getParameter("idx_li"))); */
		/* article.setNn_mem(request.getParameter("nn_mem")); */
		article.setCategory_li(multi.getParameter("category_li"));
		article.setWsubject_li(multi.getParameter("wsubject_li"));
		article.setTag_li(multi.getParameter("tag_li"));
		article.setThumb_li(multi.getFilesystemName("thumb_li")); 
		article.setWcontent_li(multi.getParameter("wcontent_li"));
		article.setDate_li(new Timestamp(System.currentTimeMillis()));

		// �����ͺ��̽� ó��
		RecipeDAO dbPro = RecipeDAO.getInstance();
		dbPro.insertArticle(article);
		
		// ����� ��
		return "/page/recipe/recipeWriteProc.jsp";
	}

}
