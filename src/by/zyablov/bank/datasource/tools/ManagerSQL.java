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

	// AuthorityType DAO
	public static final String SQL_GET_AUTHORITY_TYPE = "SQL_GET_AUTHORITY_TYPE";

	// User DAO
	public static final String SQL_GET_USER = "SQL_GET_USER";
	public static final String SQL_ADD_NEW_USER = "SQL_ADD_NEW_USER";

	// UserProfile DAO
	public static final String SQL_GET_USER_PROFILE = "SQL_GET_USER_PROFILE";
	public static final String SQL_ADD_NEW_USER_PROFILE = "SQL_ADD_NEW_USER_PROFILE";

	// CreditCardType DAO
	public static final String SQL_GET_CREDIT_CARD_TYPE = "SQL_GET_CREDIT_CARD_TYPE";
	public static final String SQL_GET_LIST_CREDIT_CARD_TYPE = "SQL_GET_LIST_CREDIT_CARD_TYPE";

	// BankAccount DAO
	public static final String SQL_GET_BANK_ACCOUNT = "SQL_GET_BANK_ACCOUNT";
	public static final String SQL_ADD_NEW_BANK_ACCOUNT = "SQL_ADD_NEW_BANK_ACCOUNT";
	public static final String SQL_UPDATE_BANK_ACCOUNT_CURRENT_BALANCE = "SQL_UPDATE_BANK_ACCOUNT_CURRENT_BALANCE";
	public static final String SQL_UPDATE_BANK_ACCOUNT_ID_BANK_ACCOUNT_STATE = "SQL_UPDATE_BANK_ACCOUNT_ID_BANK_ACCOUNT_STATE";

	// BankAccountState DAO
	public static final String SQL_GET_BANK_ACCOUNT_STATE = "SQL_GET_BANK_ACCOUNT_STATE";
	public static final String SQL_GET_LIST_BANK_ACCOUNT_STATE = "SQL_GET_LIST_BANK_ACCOUNT_STATE";

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
	public static ManagerSQL getInstance() {

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
