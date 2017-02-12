package by.zyablov.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.zyablov.bank.beans.AuthorityType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorAuthorityType;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.DataSourceBehavior;
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
	 * Field index of an unique ID for {@code AuthorityType} object from
	 * database.
	 */
	private static final int ID_AUTHORITY_TYPE = 1;

	/**
	 * Field index of a title name for {@code AuthorityType} object from
	 * database.
	 */
	private static final int TYPE_TITLE = 2;

	/**
	 * Return's an {@code AuthorityType} object from database.
	 */
	@Override
	public AuthorityType getAuthorityType(AuthorityType authorityType) throws DaoException {

		AuthorityType authorityTypeObjectFromDataBase = null;
		DataSourceBehavior datasource = null;
		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			datasource = DataBaseManager.getInstance();
			connectionToDataBase = datasource.getConnection();

			preparedStatement = connectionToDataBase.prepareStatement(ManagerSQL.SQL_GET_AUTHORITY_TYPE);

			preparedStatement.setInt(ID_AUTHORITY_TYPE, authorityType.getId());
			result = preparedStatement.executeQuery();

			authorityTypeObjectFromDataBase = new AuthorityType();

			while (result.next()) {
				authorityTypeObjectFromDataBase.setAuthorityTypeTitle(result.getString(TYPE_TITLE));
			}

		} catch (SQLException e) {

			// Logging

			DataBaseManager.getInstance().closeDataSource();
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
