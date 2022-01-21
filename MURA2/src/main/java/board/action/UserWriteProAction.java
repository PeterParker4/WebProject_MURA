package board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;
import board.dao.UserBoardDAO;
import board.vo.UserBoard;
import member.model.MemberDAO;
import member.model.MemberVO;


public class UserWriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("loginID");
		
		UserBoard userArticle = new UserBoard();
		MemberDAO dao = new MemberDAO();
		
		userArticle.setUn_mem(dao.getMember(id_mem).getUn_mem());
		userArticle.setNn_mem(dao.getMember(id_mem).getNn_mem()); 
		userArticle.setWsubject_ut(request.getParameter("wsubject_ut"));
		userArticle.setWcontent_ut(request.getParameter("wcontent_ut"));
		userArticle.setDate_ut(new Timestamp(System.currentTimeMillis()));
		
		UserBoardDAO dbPro = UserBoardDAO.getInstance();
		dbPro.insertUserArticle(userArticle);
		
		return "/userboard/userWritePro.jsp";
	}

}
