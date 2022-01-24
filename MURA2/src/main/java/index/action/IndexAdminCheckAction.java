package index.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import member.model.MemberDAO;
import member.model.MemberVO;

public class IndexAdminCheckAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id_mem") != null ) {
		
		String id_mem =  (String) session.getAttribute("id_mem");
		System.out.println(id_mem);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO memberInfo = dao.getMember(id_mem); 
		
		request.setAttribute("memberInfo", memberInfo);
		
		String admin_mem = memberInfo.getAdmin_mem(); 
		request.setAttribute("admin_mem", admin_mem);
		System.out.println(admin_mem);
		
		}
		
		return "/page/index.jsp"; 
	}
}

