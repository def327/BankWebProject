package by.zyablov.bank.datasource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface {@code DataSourceBehavior} describes a behavior of data source with
 * information for beans.
 * 
 * @author Дмитрий
 *
 */
public interface DataSourceBehavior {

	/**
	 * Returns a connection with data base.
	 * 
	 * @return A connection with data base.
	 * 
	 * @throws SQLException
	 */
	Connection getConnection() throws SQLException;

	/**
	 * Closes a connetion with data base.
	 * 
	 * @param connection
	 *            A closable connection with data base
	 * 
	 * @throws SQLException
	 */
	void closeConnection(Connection connection) throws SQLException;

}
