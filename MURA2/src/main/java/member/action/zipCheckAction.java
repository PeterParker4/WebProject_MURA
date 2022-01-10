package member.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.ActionForward;
import member.model.MemberDAO;
import member.model.ZipcodeVO;

public class zipCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String check = request.getParameter("check");
		String dong = request.getParameter("dong");
		String gender = request.getParameter("checkbox");
		String vlaue="";
		
		
		Vector<ZipcodeVO> zipcodeList = dao.zipcodeRead(dong);
		
		int totalList = zipcodeList.size();
		
		request.setAttribute("check", check);
		request.setAttribute("dong", dong);
		request.setAttribute("zipcodeList", zipcodeList);
		request.setAttribute("totalList", totalList);
		
		
		
		return new ActionForward("/page/zipCheck.jsp", false);
	}

}
