package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;

public class ModifyFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		MemberDAO dao = MemberDAO.getInstance();
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");
		
		MemberVO vo = dao.getMember(id_mem);
		
		request.setAttribute("id_mem", vo.getId_mem());
		request.setAttribute("nn_mem", vo.getNn_mem());
		request.setAttribute("pw_mem", vo.getPw_mem());
		request.setAttribute("name_mem", vo.getName_mem());
		request.setAttribute("email_mem", vo.getEmail_mem());
		request.setAttribute("gender_mem", vo.getGender_mem());
		request.setAttribute("tel_mem", vo.getTel_mem());
		request.setAttribute("zipcode_mem", vo.getZipcode_mem());
		request.setAttribute("zc1_mem", vo.getZc1_mem());
		request.setAttribute("zc2_mem", vo.getZc2_mem());
		
		return "/page/member/modifyForm.jsp";
	}

}
