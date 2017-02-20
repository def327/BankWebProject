package by.zyablov.bank.commands.ajax;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.zyablov.bank.beans.User;
import by.zyablov.bank.dao.DaoUser;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUser;
import by.zyablov.bank.exceptions.DaoException;

/**
 * {@code CommandUserCheckLoginAjax} provides methods to check user's oportunity
 * to use login in registration form.
 * 
 * 
 * @author Дмитрий
 *
 */
public class CommandUserCheckLoginAjax {

	/**
	 * Execute Ajax command to check login existence at the system. .
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws DaoException
	 */
	public void executeAjax(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {

		String loginUserToCheck = request.getParameter("login").trim();
		String warningMessage;

		DaoBehaviorUser dao = new DaoUser();
		User userFromDataSource = dao.getUserByLogin(loginUserToCheck);

		if (userFromDataSource != null) {
			warningMessage = "User with login '" + loginUserToCheck + "' exists!";
			response.setContentType("text/plain");
			response.getWriter().write(warningMessage);
		} else {
			warningMessage = "empty";
			response.setContentType("text/plain");
			response.getWriter().write(warningMessage);
		}
	}

}
