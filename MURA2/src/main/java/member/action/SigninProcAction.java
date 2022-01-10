package member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.ActionForward;
import member.model.MemberDAO;
import member.model.MemberVO;

public class SigninProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse reponse) throws IOException {
	
		request.setCharacterEncoding("utf-8");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		// 일단 사용자가 입력한 것만 불러오기
		MemberVO vo = new MemberVO(
				request.getParameter("id_mem"),
				request.getParameter("pw_mem"),
				request.getParameter("nn_mem"),
				request.getParameter("name_mem"),
				request.getParameter("tel_mem"),
				request.getParameter("email_mem"),
				request.getParameter("zipcode_mem"),
				request.getParameter("zc1_mem"),
				request.getParameter("zc2_mem"),
				request.getParameter("gender_mem"));
		
		boolean flag = dao.memberInsert(vo);
		request.setAttribute("flag", flag);
		
		return new ActionForward("/page/signinProc.jsp", false);
	}

}
