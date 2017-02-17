package by.zyablov.bank.commands;

import javax.servlet.http.HttpServletRequest;

import by.zyablov.bank.beans.User;
import by.zyablov.bank.dao.DaoUser;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUser;
import by.zyablov.bank.exceptions.DaoException;


public class CommandUserLogin implements CommandBehavior {

	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {

		String loginUserToCheck = request.getParameter(PARAM_NAME_LOGIN);
		String passwordUserToCheck = request.getParameter(PARAM_NAME_PASSWORD);

		DaoBehaviorUser dao = new DaoUser();

		try {

			User userFromBase = dao.getUserByLogin(loginUserToCheck);

			if (userFromBase != null && userFromBase.getLogin().equals(loginUserToCheck)
					&& userFromBase.getPassword().equals(passwordUserToCheck)) {

				String clientPage = "/jsp/client_folder/client.jsp";

				return clientPage;

			}

		} catch (DaoException e) {

			e.printStackTrace();
		}

		return "/jsp/main.jsp";
	}

}
