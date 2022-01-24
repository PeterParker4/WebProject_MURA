package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;

public class QaWriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
		
		MemberDAO dao = MemberDAO.getInstance();
		String nn_mem = dao.getMember(id_mem).getNn_mem();
		int idx_qt = 0, ref_qt = 1, step_qt = 0, depth_qt = 0;
		
		try {
			if(request.getParameter("idx_qt") != null) {
				idx_qt = Integer.parseInt(request.getParameter("idx_qt"));
				ref_qt = Integer.parseInt(request.getParameter("ref_qt"));
				step_qt = Integer.parseInt(request.getParameter("step_qt"));
				depth_qt = Integer.parseInt(request.getParameter("depth_qt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("idx_qt", idx_qt);
		request.setAttribute("ref_qt", ref_qt);
		request.setAttribute("step_qt", step_qt);
		request.setAttribute("depth_qt", depth_qt);
		request.setAttribute("nn_mem", nn_mem);
		
		return "/userboard/qaWriteForm.jsp";
	}

}
