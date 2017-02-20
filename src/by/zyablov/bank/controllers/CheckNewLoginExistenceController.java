package by.zyablov.bank.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.zyablov.bank.commands.CommandBehavior;
import by.zyablov.bank.commands.ajax.CommandUserCheckLoginAjax;
import by.zyablov.bank.exceptions.DaoException;

/**
 * {@code CheckNewLoginExistenceController} http servlet delegates user's http
 * Ajax request to the {@code CommandBehavior} to check the user's oportunity to
 * use this login at the resigtration form.
 * 
 * @see CommandBehavior
 * @see
 */
public class CheckNewLoginExistenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Processes GET method.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkUserNewLoginExistenceProcces(request, response);
	}

	/**
	 * Processes POST method.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkUserNewLoginExistenceProcces(request, response);
	}

	/**
	 * Processes user's http Ajax request to check the its oportunity to use
	 * this login at the resigtration form.
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
	private void checkUserNewLoginExistenceProcces(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Refactoring
		
		CommandUserCheckLoginAjax command = new CommandUserCheckLoginAjax();
		try {
			command.executeAjax(request, response);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
