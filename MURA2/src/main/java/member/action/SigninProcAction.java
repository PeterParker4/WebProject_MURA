package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;

public class SigninProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		MemberDAO dao = MemberDAO.getInstance();

		// 일단 사용자가 입력한 것만 불러오기, 순서가 바뀌어도 상관이 없는가?

		MemberVO vo = new MemberVO(request.getParameter("id_mem"), request.getParameter("pw_mem"),
				request.getParameter("nn_mem"), request.getParameter("name_mem"), request.getParameter("tel_mem"),
				request.getParameter("email_mem"), request.getParameter("zipcode_mem"), request.getParameter("zc1_mem"),
				request.getParameter("zc2_mem"), request.getParameter("gender_mem"));

		boolean flag = dao.memberInsert(vo);
		request.setAttribute("flag", flag);

		return "/page/signinProc.jsp";
	}

}
