package by.zyablov.bank.dao;

/**
 * PASSED TESTS!
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.zyablov.bank.beans.BankAccount;
import by.zyablov.bank.beans.BankAccountState;
import by.zyablov.bank.dao.interfaces.DaoBehaviorBankAccount;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.tools.ManagerSQL;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoBankAccount} provides methods to work with
 * {@code BankAccount} object at the database.
 * 
 * @author Дмитрий
 *
 * @see BankAccount
 */
public class DaoBankAccount extends DaoAbstract implements DaoBehaviorBankAccount {

	/**
	 * Returns a {@code BankAccount} object by from a database by its unique ID.
	 */
	@Override
	public BankAccount getBankAccountById(int bankAccountId) throws DaoException {

		/**
		 * A position of unique ID for a {@code BankAccount} object in prepared
		 * SQL request.
		 */
		final int QUERY_POSITION_ID_BANK_ACCOUNT = 1;

		/**
		 * Database answer field index of an unique ID for a {@code BankAccount}
		 * object from database.
		 */
		final int ID_BANK_ACCOUNT = 1;

		/**
		 * Database answer field index of an current money balance for a
		 * {@code BankAccount} object from database.
		 */
		final int CURRENT_BALANCE = 2;

		/**
		 * Database answer field index of an bank account working state ID for a
		 * {@code BankAccount} object from database.
		 */
		final int ID_BANK_ACCOUNT_STATE = 3;

		BankAccount bankAccountObjectFromDataBase = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_BANK_ACCOUNT));

			preparedStatement.setInt(QUERY_POSITION_ID_BANK_ACCOUNT, bankAccountId);

			result = preparedStatement.executeQuery();

			if (result.next()) {

				bankAccountObjectFromDataBase = new BankAccount();

				do {

					bankAccountObjectFromDataBase.setId(result.getInt(ID_BANK_ACCOUNT));
					bankAccountObjectFromDataBase.setCurrentBalance(result.getInt(CURRENT_BALANCE));

					bankAccountObjectFromDataBase.setBankAccountState(new BankAccountState());
					bankAccountObjectFromDataBase.getBankAccountState().setId(result.getInt(ID_BANK_ACCOUNT_STATE));

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

		return bankAccountObjectFromDataBase;
	}

	/**
	 * Adds a new {@code BankAccount} object to a database.
	 */
	@Override
	public void addNewBankAccount(int bankAccountMoneyBalance, int bankAccountStateId) throws DaoException {

		/**
		 * A position of an current money balance of a {@code BankAccount}
		 * object in prepared SQL request.
		 */
		final int QUERY_POSITION_CURRENT_BALANCE = 1;

		/**
		 * A position of an bank account working state ID of a
		 * {@code BankAccount} object in prepared SQL request.
		 */
		final int QUERY_POSITION_ID_BANK_ACCOUNT_STATE = 2;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_ADD_NEW_BANK_ACCOUNT));

			preparedStatement.setInt(QUERY_POSITION_CURRENT_BALANCE, bankAccountMoneyBalance);
			preparedStatement.setInt(QUERY_POSITION_ID_BANK_ACCOUNT_STATE, bankAccountStateId);

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

	/**
	 * Updates a current balance of a {@code BankAccount} object at the
	 * database.
	 */
	@Override
	public void updateBankAccountCurrentBalance(int bankAccountId, int newBalance) throws DaoException {

		/**
		 * A position of an current money balance of a {@code BankAccount}
		 * object in prepared SQL request.
		 */
		final int QUERY_POSITION_CURRENT_BALANCE = 1;

		/**
		 * A position of unique ID of a {@code BankAccount} object in prepared
		 * SQL request.
		 */
		final int QUERY_POSITION_ID_BANK_ACCOUNT = 2;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase.prepareStatement(
					super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_UPDATE_BANK_ACCOUNT_CURRENT_BALANCE));

			preparedStatement.setInt(QUERY_POSITION_CURRENT_BALANCE, newBalance);
			preparedStatement.setInt(QUERY_POSITION_ID_BANK_ACCOUNT, bankAccountId);

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

	/**
	 * Updates a current working state of a {@code BankAccount} object at the
	 * database.
	 */
	@Override
	public void updateBankAccountStateId(int bankAccountId, int bankAccountStateId) throws DaoException {

		/**
		 * A position of an bank account working state ID of a
		 * {@code BankAccount} object in prepared SQL request.
		 */
		final int QUERY_POSITION_ID_BANK_ACCOUNT_STATE = 1;

		/**
		 * A position of unique ID of a {@code BankAccount} object in prepared
		 * SQL request.
		 */
		final int QUERY_POSITION_ID_BANK_ACCOUNT = 2;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase.prepareStatement(
					super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_UPDATE_BANK_ACCOUNT_ID_BANK_ACCOUNT_STATE));

			preparedStatement.setInt(QUERY_POSITION_ID_BANK_ACCOUNT_STATE, bankAccountStateId);

			preparedStatement.setInt(QUERY_POSITION_ID_BANK_ACCOUNT, bankAccountId);

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
