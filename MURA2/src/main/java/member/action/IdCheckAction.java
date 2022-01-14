package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import member.model.MemberDAO;

public class IdCheckAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MemberDAO dao = MemberDAO.getInstance();

		String id_mem = request.getParameter("id_mem");
		boolean check = dao.idCheck(id_mem);

		request.setAttribute("id_mem", id_mem);
		request.setAttribute("check", check);

		return "/page/member/idCheck.jsp";
	}

}
