package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;


public class UserWriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
		
		try {
		MemberDAO dao = new MemberDAO();
		String nn_mem = dao.getMember(id_mem).getNn_mem();
		
		request.setAttribute("nn_mem", nn_mem);
		}catch(Exception e) {}
		
		return "/userboard/userWriteForm.jsp";
	}

}
