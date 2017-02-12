package by.zyablov.bank.dao;

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

		BankAccount bankAccountObjectFromDataBase = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_BANK_ACCOUNT));

			preparedStatement.setInt(1, bankAccountId);

			result = preparedStatement.executeQuery();

			if (result.next()) {

				bankAccountObjectFromDataBase = new BankAccount();

				do {

					bankAccountObjectFromDataBase.setId(result.getInt(1));
					bankAccountObjectFromDataBase.setCurrentBalance(result.getInt(2));

					bankAccountObjectFromDataBase.setBankAccountState(new BankAccountState());
					bankAccountObjectFromDataBase.getBankAccountState().setId(result.getInt(3));

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
	public void addNewBankAccount(BankAccount bankAccount) throws DaoException {

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_ADD_NEW_BANK_ACCOUNT));

			preparedStatement.setInt(1, bankAccount.getId());
			preparedStatement.setInt(2, bankAccount.getCurrentBalance());
			preparedStatement.setInt(3, bankAccount.getBankAccountState().getId());

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

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase.prepareStatement(
					super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_UPDATE_BANK_ACCOUNT_CURRENT_BALANCE));

			preparedStatement.setInt(1, newBalance);
			preparedStatement.setInt(2, bankAccountId);

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

	@Override
	public void updateBankAccountStateId(int bankAccountId, int bankAccountStateId) throws DaoException {

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase.prepareStatement(
					super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_UPDATE_BANK_ACCOUNT_ID_BANK_ACCOUNT_STATE));

			preparedStatement.setInt(1, bankAccountStateId);
			preparedStatement.setInt(2, bankAccountId);

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
