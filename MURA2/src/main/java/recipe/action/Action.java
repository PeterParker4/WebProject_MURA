package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.vo.ActionForward;

// ��û �Ķ���ͷ� ��ɾ �����ϴ� ����� ���� �������̽�
public interface Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}