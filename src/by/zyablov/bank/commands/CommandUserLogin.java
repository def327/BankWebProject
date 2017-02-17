package by.zyablov.bank.commands;

import javax.servlet.http.HttpServletRequest;

import by.zyablov.bank.beans.User;
import by.zyablov.bank.dao.DaoUser;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUser;
import by.zyablov.bank.exceptions.DaoException;
import static by.zyablov.bank.constants.UserTypesAuthority.*;

/**
 * {@code CommandUserLogin} provides methods to allow user to authorize at the
 * bank system.
 * 
 * @author Дмитрий
 *
 */
public class CommandUserLogin implements CommandBehavior {

	/**
	 * Name of the parametr to get user's login.
	 */
	private static final String PARAM_NAME_LOGIN = "login";

	/**
	 * Name of the parametr to get user's password.
	 */
	private static final String PARAM_NAME_PASSWORD = "password";

	/**
	 * A page for registered user client.
	 */
	private static final String USER_CLIENT_PAGE = "/jsp/client_folder/client.jsp";

	/**
	 * A page for registered user admin.
	 */
	private static final String USER_ADMIN_PAGE = "/jsp/admin_folder/admin.jsp";

	private static final String USER_MAIN_PAGE = "/jsp/main.jsp";

	/**
	 * Exceutes login command.
	 */
	@Override
	public String execute(HttpServletRequest request) {

		String loginUserToCheck = request.getParameter(PARAM_NAME_LOGIN);
		String passwordUserToCheck = request.getParameter(PARAM_NAME_PASSWORD);

		DaoBehaviorUser dao = new DaoUser();

		try {

			User userFromDataSource = dao.getUserByLogin(loginUserToCheck);

			if (userFromDataSource != null) {

				boolean authenticationStatus = authenticateUser(userFromDataSource, passwordUserToCheck);

				if (authenticationStatus) {

					// TODO set User object(login) in http response

					return getPageByUserAuthorityType(userFromDataSource);

				} else {

					// TODO set message to http response correct your login of
					// password user

					return USER_MAIN_PAGE;

				}

			}

		} catch (DaoException e) {

			// TODO Logging

			e.printStackTrace();
		}

		// TODO set message to http response there is no such user

		return USER_MAIN_PAGE;
	}

	/**
	 * Return's an http page path for user by its authority type.
	 * 
	 * @param userFromDataSource
	 *            An initialized {@code User} object from datasource.
	 */
	private String getPageByUserAuthorityType(User userFromDataSource) {

		int userAuthorityType = userFromDataSource.getAuthorityType().getId();

		switch (userAuthorityType) {

		case USER_CLIENT: {

			return USER_CLIENT_PAGE;
		}

		case USER_ADMIN: {

			return USER_ADMIN_PAGE;
		}

		default: {
			return USER_MAIN_PAGE;
		}
		}
	}

	/**
	 * Authenticates user's password.
	 * 
	 * @param userFromDataSource
	 *            A {@code User} object from data source.
	 * 
	 * @param passwordUserToCheck
	 *            A user's password.
	 * 
	 * @return Status of authentication
	 */
	private boolean authenticateUser(User userFromDataSource, String passwordUserToCheck) {
		return userFromDataSource.getPassword().equals(passwordUserToCheck);
	}

}
