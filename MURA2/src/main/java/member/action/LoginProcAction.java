package member.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;

public class LoginProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MemberDAO dao = MemberDAO.getInstance();

		String id_mem = request.getParameter("id_mem");
		String pw_mem = request.getParameter("pw_mem");

		int check = dao.loginCheck(id_mem, pw_mem);

		if (check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id_mem", id_mem); // id_mem으로 통일  
			System.out.println(id_mem);
		} else if (id_mem != null && pw_mem != null) {
			request.setAttribute("check", check);
		}
		
		//관리자
		/*MemberVO memberInfo = dao.getMember(id_mem);
		request.setAttribute("memberInfo", memberInfo);
		String admin_mem = memberInfo.getAdmin_mem();
		System.out.println(admin_mem);
		*/
		return "/page/member/login.jsp";
	}

}
