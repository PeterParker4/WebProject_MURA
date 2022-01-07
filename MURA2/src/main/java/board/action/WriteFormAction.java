package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class WriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int idx_qt = 1, wnum_qt = 0, step_qt = 0, depth_qt = 0;
		
		try {
			if(request.getParameter("wnum_qt") != null) {
				wnum_qt = Integer.parseInt(request.getParameter("wnum_qt"));
				idx_qt = Integer.parseInt(request.getParameter("idx_qt"));
				step_qt = Integer.parseInt(request.getParameter("step_qt"));
				depth_qt = Integer.parseInt(request.getParameter("depth_qt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("wnum_qt", wnum_qt);
		request.setAttribute("idx_qt", idx_qt);
		request.setAttribute("step_qt", step_qt);
		request.setAttribute("depth_qt", depth_qt);
		
		ActionForward forward = new ActionForward("writeForm.jsp",false);
		
		return forward;
	}

}
