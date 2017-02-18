package by.zyablov.bank.commands;

import javax.servlet.http.HttpServletRequest;
import static by.zyablov.bank.constants.PathPage.REGISTRY_FORM_PAGE;

/**
 * {@code CommandUserMoveToRegistryPage} provides methods to redirect user to
 * registration page.
 * 
 * @author Дмитрий
 *
 */
public class CommandUserMoveToRegistryPage implements CommandBehavior {

	/**
	 * Exceutes moving to registry page command.
	 */
	@Override
	public String execute(HttpServletRequest request) {
		return REGISTRY_FORM_PAGE;
	}

}
