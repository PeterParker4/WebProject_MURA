<<<<<<< HEAD
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
//import action.RecipeWriteFormAction;
//import action.RecipeListAction;
import vo.ActionForward;

// ¸ðµç Å¬¶óÀÌ¾ðÆ®ÀÇ ¿äÃ»À» ¹Þ¾Æ¼­ Á¦¾îÇÏ´Â 
@WebServlet("*.mur")
public class MuraFrontController extends HttpServlet {
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

		// 1. ¿äÃ» ÆÄ¾Ç
		String requestURI = request.getRequestURI();
		// ¿äÃ» url : http://localhost:9000/DogShopping/*.dog
		String contextPath = request.getContextPath();

		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;

		// 2. °¢ ¿äÃ»º°·Î ºñÁî´Ï½º ·ÎÁ÷ È£Ãâ
		/*
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
			*/
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
=======
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.RecipeWriteFormAction;
import action.RecipeListAction;
import vo.ActionForward;

// ëª¨ë“  í´ë¼ì´ì–¸íŠ¸ì˜ ìš”ì²­ì„ ë°›ì•„ì„œ ì œì–´í•˜ëŠ” 
@WebServlet("*.mur")
public class MuraFrontController extends HttpServlet {
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

		// 1. ìš”ì²­ íŒŒì•…
		String requestURI = request.getRequestURI();
		// ìš”ì²­ url : http://localhost:9000/DogShopping/*.dog
		String contextPath = request.getContextPath();

		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;

		// 2. ê° ìš”ì²­ë³„ë¡œ ë¹„ì¦ˆë‹ˆìŠ¤ ë¡œì§ í˜¸ì¶œ
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
>>>>>>> refs/remotes/origin/soom
