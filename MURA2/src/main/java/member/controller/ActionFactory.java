package member.controller;

import member.action.Action;
import member.action.FindIdProcAction;
import member.action.FindPwProcAction;
import member.action.IdCheckAction;
import member.action.LoginFormAction;
import member.action.LoginProcAction;
import member.action.LogoutAction;
import member.action.SigninFormAction;
import member.action.SigninProcAction;
import member.action.zipCheckAction;

public class ActionFactory {

	private static ActionFactory factory;

	public ActionFactory() {
	}

	public static synchronized ActionFactory getInstanse() {
		if (factory == null) { // 객체가 없을때
			factory = new ActionFactory();
		}
		return factory;
	}

	public Action getAction(String cmd) {

		Action action = null;
		switch (cmd) {
		
		case "login":
			action = new LoginFormAction();
			break;
			
		case "loginProc":
			action = new LoginProcAction();
			break;
				
		case "logout":
			action = new LogoutAction();
			break;
			
		case "idCheck":
			action = new IdCheckAction();
			break;
				
		case "signinProc":
			action = new SigninProcAction();
			break;
			
		case "signinForm":
			action = new SigninFormAction();
			break;
			
		case "zipCheck":
			action = new zipCheckAction(); // 클래스명 대문자로 변경하기
			break;
			
		case "findIdProc":
			action = new FindIdProcAction();
			break;
			
		case "findPwProc":
			action = new FindPwProcAction();
			break; 
			/*
		case "index":
			action = new indexAction();
			break; 
			
		case "index":
			action = new indexAction();
			break; 
			
		case "index":
			action = new indexAction();
			break; 
			
		case "index":
			action = new indexAction();
			break;
			*/
			
		}
		return action;
	}
}
