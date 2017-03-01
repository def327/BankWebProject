package by.zyablov.bank.dao;
/**
 * PASSED TESTS!
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import by.zyablov.bank.beans.Book;
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
 * @see Book
 *
 */
public class DaoCreditCard extends DaoAbstract implements DaoBehaviorCreditCard {

	/**
	 * Return's a list of {@code CreditCard} objects from a database by an
	 * unique bank account ID.
	 */
	@Override
	public List<Book> getListOfCreditCard(int bankAccountId) throws DaoException {

		/**
		 * A position of unique ID of a {@code BankAccount} object in prepared
		 * SQL request.
		 */
		final int QUERY_POSITION_ID_BANK_ACCOUNT = 1;

		/**
		 * Database answer field index of an unique ID for a {@code CreditCard}
		 * object from database.
		 */
		final int ID_CREDIT_CARD = 1;

		/**
		 * Database answer field index of an unique card number for a
		 * {@code CreditCard} object from database.
		 */
		final int UNIQUE_CARD_NUMBER = 2;

		/**
		 * Database answer field index of an unique ID of a card type for a
		 * {@code CreditCard} object from database.
		 */
		final int ID_CARD_TYPE = 3;

		List<Book> listOfCreditCards = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_LIST_CREDIT_CARD));

			preparedStatement.setInt(QUERY_POSITION_ID_BANK_ACCOUNT, bankAccountId);

			result = preparedStatement.executeQuery();

			if (result.next()) {

				listOfCreditCards = new LinkedList<>();

				do {

					Book creditCardObjectFromDataBase = new Book();

					creditCardObjectFromDataBase.setId(result.getInt(ID_CREDIT_CARD));

					creditCardObjectFromDataBase.setUniqueCardNumber(result.getString(UNIQUE_CARD_NUMBER));
					creditCardObjectFromDataBase.setCardtype(new CreditCardType());
					creditCardObjectFromDataBase.getCardtype().setId(result.getInt(ID_CARD_TYPE));

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
	public void addNewCreditCard(Book book, int bankAccountId) throws DaoException {

		/**
		 * A position of unique card number for a {@code CreditCard} object in
		 * prepared SQL request.
		 */
		final int QUERY_POSITION_UNIQUE_CARD_NUMBER = 1;

		/**
		 * A position of unique ID of a {@code BankAccount} object in prepared
		 * SQL request.
		 */
		final int QUERY_POSITION_ID_BANK_ACCOUNT = 2;

		/**
		 * A position of card type ID for a {@code CreditCard} object in
		 * prepared SQL request.
		 */
		final int QUERY_POSITION_ID_CARD_TYPE = 3;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_ADD_NEW_CREDIT_CARD));

			preparedStatement.setString(QUERY_POSITION_UNIQUE_CARD_NUMBER, book.getUniqueCardNumber());
			preparedStatement.setInt(QUERY_POSITION_ID_BANK_ACCOUNT, bankAccountId);
			preparedStatement.setInt(QUERY_POSITION_ID_CARD_TYPE, book.getCardtype().getId());

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
