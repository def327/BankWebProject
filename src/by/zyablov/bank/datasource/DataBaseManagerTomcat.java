package by.zyablov.bank.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataBaseManagerTomcat implements DataSourceBehavior {

	@Override
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}

	private DataSource dataSource;

	private static DataBaseManagerTomcat dataBaseManager;

	public static DataBaseManagerTomcat getInstance() {

		DataBaseManagerTomcat localInstance = dataBaseManager;

		if (localInstance == null) {

			synchronized (DataBaseManager.class) {
				localInstance = dataBaseManager;

				if (localInstance == null) {
					dataBaseManager = localInstance = new DataBaseManagerTomcat();
				}
			}
		}
		return localInstance;
	}

	public void closeDataBaseManager() {
	}

	private DataBaseManagerTomcat() {
		try {
			Context initContext = (Context) (new InitialContext().lookup("java:comp/env"));
			this.dataSource = (DataSource) initContext.lookup("jdbc/db_bank_web");
		} catch (NamingException e) {

			System.out.println("Problem with JNDI!");

			e.printStackTrace();
		}
	}

}
