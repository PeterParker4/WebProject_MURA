package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;

public class FindIdProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		MemberDAO dao = new MemberDAO();
		String name_mem = request.getParameter("name_mem");
		String email_mem = request.getParameter("email_mem");
		String id_mem = dao.findId(name_mem, email_mem);
		request.setAttribute("id_mem", id_mem);

		if (id_mem == null)
			return "/page/member/findId.mur";
		return "/page/member/findIdAfter.mur";

	}

}
