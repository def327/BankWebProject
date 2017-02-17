package by.zyablov.bank.events;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.tools.ManagerSQL;

/**
 * {@code AppContextEvent} provides methods to use and to free program resources
 * as a database pool connection manager, SQL - request manager.
 * 
 * @author Дмитрий
 *
 */
public class AppContextEvent implements ServletContextListener {

	/**
	 * Initializes the captured resources.
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// Logging initializing of resources

		System.out.println("Init context!");
		
		DataBaseManager.getInstance();
		ManagerSQL.getInstance();

	}

	/**
	 * Frees the captured resources
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		// Logging -- free the resources

		System.out.println("Desotroy context!");
		
		DataBaseManager.getInstance().closeDataBaseManager();
		ManagerSQL.getInstance().closeManagerSql();

	}

}
