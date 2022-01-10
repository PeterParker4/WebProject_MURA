package member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.ActionForward;
import member.model.MemberDAO;

public class FindPwProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		MemberDAO dao = new MemberDAO();
		String name_mem = request.getParameter("name_mem");
		String id_mem = request.getParameter("id_mem");
		String email_mem = request.getParameter("email_mem");
		String pw_mem = dao.findPw(name_mem, id_mem, email_mem);
		request.setAttribute("pw_mem", pw_mem);
		
		
		if(pw_mem == null)
			return new ActionForward("/page/findPw.jsp", false);
		return new ActionForward("/page/findPwAfter.jsp", false);
	}

}
