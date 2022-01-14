package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberDAO;
import member.model.MemberVO;

public class MyPageAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	      
		  HttpSession session = request.getSession();
		  String id_mem = (String) session.getAttribute("id_mem");
		  System.out.println(id_mem);
		
	      MemberDAO dao = MemberDAO.getInstance();
	      
	      MemberVO memberInfo = dao.getMember(id_mem);
	      // 해당 뷰에서 사용할 속성 저장
	      request.setAttribute("memberInfo", memberInfo);
	      
	      return "/page/member/myPage.jsp";

	}

}
