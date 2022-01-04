package member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse reponse) throws IOException {

		MemberDAO dao = MemberDAO.getInstance();
		
		String id_mem = request.getParameter("id_mem");
		String pass_mem = request.getParameter("pass_mem");
		
		int check = dao.loginCheck(id_mem, pass_mem);
		
		if(check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginID", id_mem); 
		}else if (id_mem != null && pass_mem != null) {
			request.setAttribute("check", check);
		}
		return null;
	}

}
