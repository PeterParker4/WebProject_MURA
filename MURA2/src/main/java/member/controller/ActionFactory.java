package member.controller;

import member.action.Action;
import member.action.LoginFormAction;
import member.action.LoginProcAction;
import member.action.LogoutAction;

public class ActionFactory {

	private static ActionFactory factory;

	public ActionFactory() {
	}

	public static synchronized ActionFactory getInstanse() {
		if (factory == null) { // ��ü�� ������
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
			
		case "index":
			action = new indexAction();
			break;
			
		case "index":
			action = new indexAction();
			break; */
			
		}
		return action;
	}
}
