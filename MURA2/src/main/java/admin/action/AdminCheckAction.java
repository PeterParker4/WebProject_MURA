//package admin.action;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import action.CommandAction;
//import member.model.MemberDAO;
//
//public class AdminCheckAction implements CommandAction {
//
//	@Override
//	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		MemberDAO dao =MemberDAO.getInstance();
//
//		// 세션 불러오기
//		HttpSession session = request.getSession();
//		String id_mem = (String) session.getAttribute("id_mem");
//		String pw_mem = (String) session.getAttribute("pw_mem");
//		
//		int result = dao.adminloginCheck(id_mem, pw_mem);
//
//		request.setAttribute("result", result);
//
//		return "/page/member/adminCheck.jsp";
//	}
//
//}
