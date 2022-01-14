package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;

public class ModifyProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String id_mem = (String) session.getAttribute("id_mem");
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO vo = new MemberVO(id_mem,
				request.getParameter("nn_mem"),
				request.getParameter("pw_mem"),
				request.getParameter("name_mem"),
				request.getParameter("email_mem"),
				request.getParameter("gender_mem"),
				request.getParameter("tel_mem"),
				request.getParameter("zipcode_mem"),
				request.getParameter("zc1_mem"),
				request.getParameter("zc2_mem"));
		
		dao.updateMember(vo); 
		
		return "/page/member/modifyProc.jsp";
	}

}
