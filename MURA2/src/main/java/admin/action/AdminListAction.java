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
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// �Ķ���� ������ ��� ���� �ҷ�����
		String id_mem = request.getParameter("id_mem");
		System.out.println(id_mem);
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO memberInfo = dao.getMember(id_mem);
		
		// �ش� ���������� ����� �Ӽ� ����
		request.setAttribute("memberInfo", memberInfo);
		
		return "/adminboard/adminList.jsp";
	}
	
}
