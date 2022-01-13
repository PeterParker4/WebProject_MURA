package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberDAO;

public class ModifyFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		MemberDAO dao = MemberDAO.getInstance();
		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute(null)
		
		
		return null;
	}

}
