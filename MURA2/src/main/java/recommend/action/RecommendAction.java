package recommend.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;

public class RecommendAction implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String pageNum = request.getParameter("pageNum");
		String num = request.getParameter("num");	
		
		// ���ǿ��� ��� ���� �ҷ�����
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
		
		// �信�� ����� �Ӽ� ����
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		request.setAttribute("id_mem", id_mem);

		return "/MURA2/page/recipe/recommend.jsp";
	}
}
