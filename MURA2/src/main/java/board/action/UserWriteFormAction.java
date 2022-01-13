package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;


public class UserWriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
//		int idx_ut = 0;
//		
//		
//		try {
//			if(request.getParameter("idx_ut") != null) {
//				idx_ut = Integer.parseInt(request.getParameter("idx_ut"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//
//		request.setAttribute("idx_ut", idx_ut);
		
		return "/userboard/userWriteForm.jsp";
	}

}
