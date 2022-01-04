package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.vo.ActionForward;

public class RecipeWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ����۰� �亯���� ����
        int num=0, ref=1, step=0, depth=0;
		  
		try{
			  if(request.getParameter("num") != null) {
				  num = Integer.parseInt(request.getParameter("num"));
				  ref = Integer.parseInt(request.getParameter("ref"));
				  step = Integer.parseInt(request.getParameter("step"));
				  depth = Integer.parseInt(request.getParameter("depth"));
			  }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// �ش�信�� ����� �Ӽ� ����
		request.setAttribute("num", num);
		request.setAttribute("ref", ref);
		request.setAttribute("step", step);
		request.setAttribute("depth", depth);
		
		ActionForward forward = new ActionForward("recipeWriteForm.mur", true);
		
		return forward; // �ش��� �Ӽ����� �Ѱ���
	}
}