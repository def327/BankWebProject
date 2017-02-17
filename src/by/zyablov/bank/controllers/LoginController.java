package by.zyablov.bank.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.zyablov.bank.commands.CommandBehavior;
import by.zyablov.bank.commands.CommandUserLogin;
import by.zyablov.bank.commands.factory.CommandEnum;

/**
 * {@code LoginController} http servlet delegates user's http request to the
 * {@code CommandBehavior} object to login at the system.
 * 
 * @see CommandBehavior
 * @see CommandUserLogin
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Processes GET method.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		loginProcess(request, response);
	}

	/**
	 * Processes POST method.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loginProcess(request, response);
	}

	/**
	 * Processes user's http request to login at the system.
	 * 
	 * @param request
	 *            An {@code HttpServletRequest} object
	 * 
	 * @param response
	 *            An {@code HttpServletResponse} object
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loginProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CommandBehavior command = CommandEnum.USER_LOGIN.getCommand();
		String nextPage = command.execute(request);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}

}
