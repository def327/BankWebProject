package by.zyablov.bank.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface {@code CommandBehavior} defines a behavior of a command, which
 * executes an users action.
 * 
 * 
 * @author Дмитрий
 *
 */
public interface CommandBehavior {

	/**
	 * Performs a user's action and returns a web page path to redirect with a
	 * result of a command.
	 * 
	 * @param request
	 *            A http request object from a client
	 * 
	 * @return A page's path to redirect
	 */
	String execute(HttpServletRequest request);

}
