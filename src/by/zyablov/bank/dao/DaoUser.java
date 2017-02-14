package by.zyablov.bank.dao;

/**
 * PASSED TESTS!
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.zyablov.bank.beans.AuthorityType;
import by.zyablov.bank.beans.User;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUser;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.tools.ManagerSQL;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoUser} provides methods to work with {@code User} objects.
 * 
 * @author Дмитрий
 * 
 * @see User
 */
public class DaoUser extends DaoAbstract implements DaoBehaviorUser {

	/**
	 * Return's an {@code User} object by unique login.
	 */
	@Override
	public User getUserByLogin(String userLogin) throws DaoException {

		/**
		 * A position of login in prepared SQL request.
		 */
		final int QUERY_POSITION_LOGIN = 1;

		/**
		 * Database answer field index of an unique ID for an {@code User}
		 * object from a database.
		 */
		final int ID_USER = 1;

		/**
		 * Database answer field index of a login for an {@code User} object
		 * from database.
		 */
		final int LOGIN = 2;

		/**
		 * Database answer field index of a password for an {@code User} object
		 * from database.
		 */
		final int PASSWORD = 3;

		/**
		 * Database answer field index of an unique ID for an
		 * {@code AuthorityType} object of the{@code User} object from database.
		 */
		final int ID_AUTHORITY_TYPE = 4;

		User userObjectFromDataBase = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_USER));

			preparedStatement.setString(QUERY_POSITION_LOGIN, userLogin);
			result = preparedStatement.executeQuery();

			if (result.next()) {

				userObjectFromDataBase = new User();

				do {

					userObjectFromDataBase.setId(result.getInt(ID_USER));
					userObjectFromDataBase.setLogin(result.getString(LOGIN));
					userObjectFromDataBase.setPassword(result.getString(PASSWORD));
					userObjectFromDataBase.setAuthorityType(new AuthorityType());
					userObjectFromDataBase.getAuthorityType().setId(result.getInt(ID_AUTHORITY_TYPE));

				} while (result.next());
			}

		} catch (SQLException e) {

			// Logging

			DataBaseManager.getInstance().closeDataBaseManager();
			ManagerSQL.getInstance().closeManagerSql();

			throw new DaoException();

		} finally {

			if (result != null)

				try {
					result.close();

				} catch (SQLException ignore) {

					// Logging
				}

			if (preparedStatement != null)

				try {
					preparedStatement.close();

				} catch (SQLException ignore) {

					// Logging
				}

			if (connectionToDataBase != null)

				try {
					connectionToDataBase.close();

				} catch (SQLException ignore) {

					// Logging
				}

		}

		return userObjectFromDataBase;
	}

	/**
	 * Adds a new client {@code User} object to a database.
	 */
	@Override
	public void addNewUserClient(User user) throws DaoException {

		/**
		 * A position of unique login for an {@code User} object in prepared SQL
		 * request.
		 */
		final int QUERY_POSITION_LOGIN = 1;

		/**
		 * A position of password for an {@code User} object in prepared SQL
		 * request.
		 */
		final int QUERY_POSITION_PASSWORD = 2;

		/**
		 * A position of authority type for an {@code User} object in prepared
		 * SQL request.
		 */
		final int QUERY_POSITION_ID_AUTHORITY_TYPE = 3;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_ADD_NEW_USER));

			preparedStatement.setString(QUERY_POSITION_LOGIN, user.getLogin());
			preparedStatement.setString(QUERY_POSITION_PASSWORD, user.getPassword());
			preparedStatement.setInt(QUERY_POSITION_ID_AUTHORITY_TYPE, user.getAuthorityType().getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			// Logging

			DataBaseManager.getInstance().closeDataBaseManager();
			ManagerSQL.getInstance().closeManagerSql();

			throw new DaoException();

		} finally {

			if (result != null)

				try {
					result.close();

				} catch (SQLException ignore) {

					// Logging
				}

			if (preparedStatement != null)

				try {
					preparedStatement.close();

				} catch (SQLException ignore) {

					// Logging
				}

			if (connectionToDataBase != null)

				try {
					connectionToDataBase.close();

				} catch (SQLException ignore) {

					// Logging
				}

		}

	}

}
