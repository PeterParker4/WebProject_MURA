package admin.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

import member.model.MemberDAO;
import member.model.MemberVO;

public class AdminListAction implements CommandAction
{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 값에서 멤버 정보 불러오기
		String id_mem = request.getParameter("id_mem");
		System.out.println(id_mem);
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO memberInfo = dao.getMember(id_mem);
		
		// 해당 페이지에서 사용할 속성 저장
		request.setAttribute("memberInfo", memberInfo);
		
		return "/adminboard/adminList.jsp";
	}
	
}
