package member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.ActionForward;
import member.model.MemberDAO;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberDAO dao = MemberDAO.getInstance();
		
		String id_mem = request.getParameter("id_mem");
		boolean check = dao.idCheck(id_mem);
		
		request.setAttribute("id_mem", id_mem);
		request.setAttribute("check", check);
		
		return new ActionForward("/page/idCheck.jsp", false);
	}

}
