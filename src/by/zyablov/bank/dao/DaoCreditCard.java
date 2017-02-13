package by.zyablov.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import by.zyablov.bank.beans.CreditCard;
import by.zyablov.bank.beans.CreditCardType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorCreditCard;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.tools.ManagerSQL;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoCreditCard} provides methods to work with {@code CreditCard}
 * object at the database.
 * 
 * @author Дмитрий
 * 
 * @see CreditCard
 *
 */
public class DaoCreditCard extends DaoAbstract implements DaoBehaviorCreditCard {

	@Override
	public List<CreditCard> getListOfCreditCard(int bankAccountId) throws DaoException {

		List<CreditCard> listOfCreditCards = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_LIST_CREDIT_CARD));

			result = preparedStatement.executeQuery();

			if (result.next()) {

				listOfCreditCards = new LinkedList<>();

				do {

					CreditCard creditCardObjectFromDataBase = new CreditCard();

					creditCardObjectFromDataBase.setId(result.getInt(1));
					creditCardObjectFromDataBase.setUniqueCardNumber(result.getString(2));
					creditCardObjectFromDataBase.setCardtype(new CreditCardType());
					creditCardObjectFromDataBase.getCardtype().setId(result.getInt(3));

					listOfCreditCards.add(creditCardObjectFromDataBase);

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

		return listOfCreditCards;
	}

	/**
	 * Adds a new {@code CreditCard} object to a database.
	 */
	@Override
	public void addNewCreditCard(CreditCard creditCard, int bankAccountId) throws DaoException {

		
		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_ADD_NEW_CREDIT_CARD));

			 preparedStatement.setString(1, creditCard.getUniqueCardNumber());
			 preparedStatement.setInt(2,bankAccountId);
			 preparedStatement.setInt(3,creditCard.getCardtype().getId());

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
