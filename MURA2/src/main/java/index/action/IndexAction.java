package index.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class IndexAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// ���ǿ��� ��� ���� �ҷ�����
		HttpSession session = request.getSession();
		String id_mem = (String) session.getAttribute("id_mem");

		// �ش� �信�� ����� �Ӽ� ����
		request.setAttribute("id_mem", id_mem);

		return "/page/index.jsp"; // �ش��� �Ӽ����� �Ѱ���
		
	}

}
