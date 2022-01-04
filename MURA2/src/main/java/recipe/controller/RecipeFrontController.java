package recipe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.action.Action;
import recipe.action.RecipeListAction;
import recipe.action.RecipeWriteFormAction;
import recipe.vo.ActionForward;

// ��� Ŭ���̾�Ʈ�� ��û�� �޾Ƽ� �����ϴ� ��Ʈ�ѷ� Ŭ������
@WebServlet("*.mur")
public class RecipeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. ��û �ľ�
		String requestURI = request.getRequestURI();
		// ��û url : http://localhost:9000/MURA2/*.mur
		String contextPath = request.getContextPath();

		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;

		// 2. �� ��û���� ����Ͻ� ���� ȣ��
		if (command.equals("/recipeList.mur")) {
			action = new RecipeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/recipeWriteForm.mur")) {
			action = new RecipeWriteFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * }else if(command.equals("/dogRegistForm.dog")) { action = new
			 * DogRegistFormAction(); try { forward = action.execute(request, response);
			 * }catch(Exception e) { e.printStackTrace(); } }
			 * 
			 * else if(command.equals("/dogView.dog")) { action = new DogViewAction(); try {
			 * forward = action.execute(request, response); }catch(Exception e) {
			 * e.printStackTrace(); } }
			 * 
			 * else if(command.equals("/dogCartADD.dog")) { action = new DogCartAddAction();
			 * try { forward = action.execute(request, response); }catch(Exception e) {
			 * e.printStackTrace(); } }
			 * 
			 * else if(command.equals("/dogCartList.dog")) { action = new
			 * DogCartListAction(); try { forward = action.execute(request, response);
			 * }catch(Exception e) { e.printStackTrace(); } }
			 * 
			 * else if(command.equals("/dogCartQtyUp.dog")) { action = new
			 * DogCartQtyUpAction(); try { forward = action.execute(request, response);
			 * }catch(Exception e) { e.printStackTrace(); } }
			 * 
			 * else if(command.equals("/dogCartQtyDown.dog")) { action = new
			 * DogCartQtyDownAction(); try { forward = action.execute(request, response);
			 * }catch(Exception e) { e.printStackTrace(); } }
			 * 
			 * else if(command.equals("/dogCartRemove.dog")) { action = new
			 * DogCartRemoveAction(); try { forward = action.execute(request, response);
			 * }catch(Exception e) { e.printStackTrace(); } }
			 * 
			 * else if(command.equals("/dogCartSearch.dog")) { action = new
			 * DogCartSearchAction(); try { forward = action.execute(request, response);
			 * }catch(Exception e) { e.printStackTrace(); } }
			 */

			if (forward != null) {

				if (forward.isRedirect()) {
					response.sendRedirect(forward.getPath());
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			}

		}
	}
}