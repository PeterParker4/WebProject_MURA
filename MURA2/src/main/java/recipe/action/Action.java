package recipe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.vo.ActionForward;

// 요청 파라미터로 명령어를 전달하는 방식의 슈퍼 인터페이스
public interface Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}