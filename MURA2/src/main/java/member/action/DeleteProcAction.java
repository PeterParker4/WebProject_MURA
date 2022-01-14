package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberDAO;

public class DeleteProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
		String pw_mem = request.getParameter("pw_mem");
		
		int result = dao.deleteMember(id_mem, pw_mem);
		
		if(result != 0) {
			session.invalidate();
		}
		request.setAttribute("result", result);
		
		return "/page/member/deleteProc.jsp";
	}

}
