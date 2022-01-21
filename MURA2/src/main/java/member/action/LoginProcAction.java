package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;


public class LoginProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MemberDAO dao = MemberDAO.getInstance();

		String id_mem = request.getParameter("id_mem");
		String pw_mem = request.getParameter("pw_mem");
		String un_mem = request.getParameter("un_mem");
		
		
		int check = dao.loginCheck(id_mem, pw_mem);

		if (check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginID", id_mem);
			session.setAttribute("un_mem", un_mem);
		} else if (id_mem != null && pw_mem != null) {
			request.setAttribute("check", check);
		}
		
		return "/page/login.jsp";
	}

}