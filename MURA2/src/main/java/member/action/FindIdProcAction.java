package member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.ActionForward;
import member.model.MemberDAO;

public class FindIdProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		MemberDAO dao = new MemberDAO();
		String name_mem = request.getParameter("name_mem");
		String email_mem = request.getParameter("email_mem");
		String id_mem = dao.findId(name_mem, email_mem);
		request.setAttribute("id_mem", id_mem);
		
		if(id_mem == null)
			return new ActionForward("/page/findId.jsp", false);
		return new ActionForward("/page/findIdAfter.jsp", false);
	}

}
