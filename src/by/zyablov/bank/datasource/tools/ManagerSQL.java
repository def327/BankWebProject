package by.zyablov.bank.datasource.tools;

import java.util.ResourceBundle;

/**
 * Class {@code ManagerSQL} provides methods to get prepared SQL requests from
 * propertie file.
 * 
 * @author Дмитрий
 *
 */
public class ManagerSQL implements ManagerSQLBehavior {

	/**
	 * A name of propertie file with prepared SQL requests.
	 */
	private static final String BUNDLE_NAME = "sql_requests";

	// #LOGIN DAO
	public static final String SQL_GET_USER = "SQL_GET_USER";
	public static final String SQL_GET_USER_BY_UID = "SQL_GET_USER_BY_UID";

	// #ADMINISTRATOR DAO
	public static final String SQL_ADD_FILM = "SQL_ADD_FILM";
	public static final String SQL_SET_ORDER_STATUS = "SQL_SET_ORDER_STATUS";
	public static final String SQL_DELETE_FILM = "SQL_DELETE_FILM";
	public static final String SQL_UPDATE_ORDER_STATUS = "SQL_UPDATE_ORDER_STATUS";
	public static final String SQL_GET_ALL_USERS = "SQL_GET_ALL_USERS";
	public static final String SQL_SET_ACCESS_LEVEL = "SQL_SET_ACCESS_LEVEL";

	/**
	 * An instance of {@code ManagerSQL} object.
	 */
	private static volatile ManagerSQL managerSql;

	/**
	 * A instance of {@code ResourceBundle} object.
	 */
	private static volatile ResourceBundle bundle;

	/**
	 * Return's an instance of {@code ManagerSQL} object.
	 * 
	 * @return A {@code ManagerSQL} object.
	 */
	public static ManagerSQLBehavior getInstance() {

		ManagerSQL localInstance = managerSql;

		if (localInstance == null) {

			synchronized (ManagerSQL.class) {
				localInstance = managerSql;

				if (localInstance == null) {
					managerSql = localInstance = new ManagerSQL();
					bundle = ResourceBundle.getBundle(BUNDLE_NAME);
				}
			}
		}
		return localInstance;
	}

	/**
	 * Returns a prepared SQL request from property file.
	 */
	@Override
	public String getPreparedSqlRequest(String requestName) {
		return bundle.getString(requestName);
	}

	/**
	 * Shutdown a SQL manager.
	 */
	public void closeManagerSql() {
		ManagerSQL.managerSql = null;
		ManagerSQL.bundle = null;
	}

	/**
	 * Constructs a default {@code ManagerSQL}.
	 */
	private ManagerSQL() {
	}

}
