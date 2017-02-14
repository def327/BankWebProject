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

import by.zyablov.bank.beans.BankAccountState;
import by.zyablov.bank.dao.interfaces.DaoBehaviorBankAccountState;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.tools.ManagerSQL;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoBankAccountState} provides methods to work with
 * {@code BankAccountState } object at the database.
 * 
 * @author Дмитрий
 * 
 * @see BankAccountState
 *
 */
public class DaoBankAccountState extends DaoAbstract implements DaoBehaviorBankAccountState {

	/**
	 * Return's an {@code BankAccountState} object from a database by its unique
	 * ID.
	 */
	@Override
	public BankAccountState getBankAccountState(int bankAccountStateId) throws DaoException {

		/**
		 * A position of unique ID of an {@code BankAccountState} object in
		 * prepared SQL request.
		 */
		final int QUERY_POSITION_ID_BANK_ACCOUNT_STATE = 1;

		/**
		 * Database answer field index of an bank account working state ID for
		 * an {@code BankAccountState} object from database.
		 */
		final int ID_BANK_ACCOUNT_STATE = 1;

		/**
		 * Database answer field index of an bank account working state type
		 * tittle for an {@code BankAccountState} object from database.
		 */
		final int ID_BANK_ACCOUNT_TYPE_TITTLE = 2;

		BankAccountState creditCardTypeObjectFromDataBase = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_BANK_ACCOUNT_STATE));

			preparedStatement.setInt(QUERY_POSITION_ID_BANK_ACCOUNT_STATE, bankAccountStateId);
			result = preparedStatement.executeQuery();

			if (result.next()) {

				creditCardTypeObjectFromDataBase = new BankAccountState();

				do {

					creditCardTypeObjectFromDataBase.setId(result.getInt(ID_BANK_ACCOUNT_STATE));
					creditCardTypeObjectFromDataBase.setStateTypeTittle(result.getString(ID_BANK_ACCOUNT_TYPE_TITTLE));

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

	/**
	 * Return's a list of {@code BankAccountState} objects from a database.
	 */
	@Override
	public List<BankAccountState> getListOfBankAccountStates() throws DaoException {

		/**
		 * Database answer field index of an bank account working state ID for
		 * an {@code BankAccountState} object from database.
		 */
		final int ID_BANK_ACCOUNT_STATE = 1;

		/**
		 * Database answer field index of an bank account working state type
		 * tittle for an {@code BankAccountState} object from database.
		 */
		final int ID_BANK_ACCOUNT_TYPE_TITTLE = 2;

		List<BankAccountState> listOfBankAccountStates = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase.prepareStatement(
					super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_LIST_BANK_ACCOUNT_STATE));

			result = preparedStatement.executeQuery();

			if (result.next()) {

				listOfBankAccountStates = new LinkedList<>();

				do {

					BankAccountState bankAccountStateObjectFromDataBase = new BankAccountState();

					bankAccountStateObjectFromDataBase.setId(result.getInt(ID_BANK_ACCOUNT_STATE));
					bankAccountStateObjectFromDataBase
							.setStateTypeTittle(result.getString(ID_BANK_ACCOUNT_TYPE_TITTLE));

					listOfBankAccountStates.add(bankAccountStateObjectFromDataBase);

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

		return listOfBankAccountStates;
	}

}
