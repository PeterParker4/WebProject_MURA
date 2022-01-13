package member.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;
import member.model.ZipcodeVO;

public class ZipCheckAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String check = request.getParameter("check");
		String dong = request.getParameter("dong");

		Vector<ZipcodeVO> zipcodeList = dao.zipcodeRead(dong);

		int totalList = zipcodeList.size();

		request.setAttribute("check", check);
		request.setAttribute("dong", dong);
		request.setAttribute("zipcodeList", zipcodeList);
		request.setAttribute("totalList", totalList);

		return "/page/member/zipCheck.jsp";
	}

}