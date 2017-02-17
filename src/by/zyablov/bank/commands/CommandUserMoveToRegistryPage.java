package by.zyablov.bank.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * {@code CommandUserMoveToRegistryPage} provides methods to redirect user to
 * registration page.
 * 
 * @author Дмитрий
 *
 */
public class CommandUserMoveToRegistryPage implements CommandBehavior {

	/**
	 * A page for user to registrate a the bank system.
	 */
	private static final String REGISTRY_FORM_PAGE = "/jsp/registry_folder/registry.jsp";

	/**
	 * Exceutes moving to registry page command.
	 */
	@Override
	public String execute(HttpServletRequest request) {
		return REGISTRY_FORM_PAGE;
	}

}
