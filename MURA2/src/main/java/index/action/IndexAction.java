package index.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class IndexAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 세션에서 멤버 정보 불러오기
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");

		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("id_mem", id_mem);

		return "/page/index.jsp"; // 해당뷰로 속성값을 넘겨줌
		
	}

}
