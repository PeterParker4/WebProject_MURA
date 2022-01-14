package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;

public class FindPwProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = new MemberDAO();
		String name_mem = request.getParameter("name_mem");
		String id_mem = request.getParameter("id_mem");
		String email_mem = request.getParameter("email_mem");
		String pw_mem = dao.findPw(name_mem, id_mem, email_mem);
		request.setAttribute("pw_mem", pw_mem);

		if (pw_mem == null)
			return "/page/member/findPw.jsp";
		return "/page/member/findPwAfter.jsp";

	}

}
