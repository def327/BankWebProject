package by.zyablov.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import by.zyablov.bank.beans.CreditCardType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorCreditCardType;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.tools.ManagerSQL;
import by.zyablov.bank.exceptions.DaoException;

/**
 * 
 * Class {@code DaoCreditCardType} provides methods to work with
 * {@code CreditCardType} object at the database.
 * 
 * @author Дмитрий
 *
 */
public class DaoCreditCardType extends DaoAbstract implements DaoBehaviorCreditCardType {

	/**
	 * Return's a {@code CreditCard} object from a database by its unique ID.
	 */
	@Override
	public CreditCardType getCreditCardType(int creditCardTypeId) throws DaoException {

		CreditCardType creditCardTypeObjectFromDataBase = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_CREDIT_CARD_TYPE));

			preparedStatement.setInt(1, creditCardTypeId);
			result = preparedStatement.executeQuery();

			if (result.next()) {

				creditCardTypeObjectFromDataBase = new CreditCardType();

				do {

					creditCardTypeObjectFromDataBase.setId(result.getInt(1));
					creditCardTypeObjectFromDataBase.setCardTypeTitle(result.getString(2));

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

		return creditCardTypeObjectFromDataBase;

	}

	@Override
	public List<CreditCardType> getListOfCreditCardTypes() throws DaoException {

		List<CreditCardType> listOfCreditCardtypes = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_LIST_CREDIT_CARD_TYPE));

			result = preparedStatement.executeQuery();

			if (result.next()) {

				listOfCreditCardtypes = new LinkedList<>();

				do {

					CreditCardType creditCardTypeObjectFromDataBase = new CreditCardType();

					creditCardTypeObjectFromDataBase.setId(result.getInt(1));
					creditCardTypeObjectFromDataBase.setCardTypeTitle(result.getString(2));

					listOfCreditCardtypes.add(creditCardTypeObjectFromDataBase);

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

		return listOfCreditCardtypes;
	}

}
