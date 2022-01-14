package member.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberDAO;

public class LoginProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MemberDAO dao = MemberDAO.getInstance();

		String id_mem = request.getParameter("id_mem");
		String pw_mem = request.getParameter("pw_mem");

		int check = dao.loginCheck(id_mem, pw_mem);

		if (check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id_mem", id_mem); // id_mem으로 통일           
		} else if (id_mem != null && pw_mem != null) {
			request.setAttribute("check", check);
		}
		
		 

		return "/page/member/login.jsp";
	}

}
