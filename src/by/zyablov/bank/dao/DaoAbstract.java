package by.zyablov.bank.dao;

import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.DataSourceBehavior;
import by.zyablov.bank.datasource.tools.ManagerSQL;
import by.zyablov.bank.datasource.tools.ManagerSQLBehavior;

/**
 * Class {@code DaoAbstract} provides methods to work with datasource.
 * 
 * @author Дмитрий
 * 
 * @see DataSourceBehavior
 *
 */
public abstract class DaoAbstract {

	/**
	 * A datasource for objects.
	 */
	protected DataSourceBehavior dataSource;

	/**
	 * A manager for SQL requests.
	 */
	protected ManagerSQLBehavior managerSQL;

	/**
	 * Constructs a default <code>DaoAbstract</code> with an initialized
	 * datasource and SQL-request manager.
	 */
	public DaoAbstract() {
		this.dataSource = DataBaseManager.getInstance();
		this.managerSQL = ManagerSQL.getInstance();
	}

}
