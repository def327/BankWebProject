package by.zyablov.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.zyablov.bank.beans.AuthorityType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorAuthorityType;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.tools.ManagerSQL;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoAuthorityType} provides methods to work with
 * {@code AuthorityType } object at the database.
 * 
 * @author Дмитрий
 *
 * @see AuthorityType
 */
public class DaoAuthorityType extends DaoAbstract implements DaoBehaviorAuthorityType {

	/**
	 * A position of unique ID of an {@code AuthorityType} object in prepared
	 * SQL request.
	 */
	private static final int QUERY_POSITION_ID_AUTHORITY_TYPE = 1;

	/**
	 * Database field index of an unique ID for an {@code AuthorityType} object
	 * from database.
	 */
	private static final int ID_AUTHORITY_TYPE = 1;

	/**
	 * Database field indexof a title name for an {@code AuthorityType} object
	 * from database.
	 */
	private static final int TYPE_TITLE = 2;

	/**
	 * Return's an {@code AuthorityType} object from a database by its unique
	 * ID.
	 */
	@Override
	public AuthorityType getAuthorityTypeById(int authorityTypeUniqueId) throws DaoException {

		AuthorityType authorityTypeObjectFromDataBase = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_AUTHORITY_TYPE));

			preparedStatement.setInt(QUERY_POSITION_ID_AUTHORITY_TYPE, authorityTypeUniqueId);
			result = preparedStatement.executeQuery();

			authorityTypeObjectFromDataBase = new AuthorityType();

			while (result.next()) {
				authorityTypeObjectFromDataBase.setAuthorityTypeTitle(result.getString(TYPE_TITLE));
			}

			if (result.next()) {

				authorityTypeObjectFromDataBase = new AuthorityType();

				do {

					authorityTypeObjectFromDataBase.setId(result.getInt(ID_AUTHORITY_TYPE));
					authorityTypeObjectFromDataBase.setAuthorityTypeTitle(result.getString(TYPE_TITLE));

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

		return authorityTypeObjectFromDataBase;
	}

}
