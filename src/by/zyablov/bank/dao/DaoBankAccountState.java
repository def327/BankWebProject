package by.zyablov.bank.dao;

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

public class DaoBankAccountState extends DaoAbstract implements DaoBehaviorBankAccountState {

	@Override
	public BankAccountState getBankAccountState(int bankAccountStateId) throws DaoException {

		BankAccountState creditCardTypeObjectFromDataBase = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_BANK_ACCOUNT_STATE));

			preparedStatement.setInt(1, bankAccountStateId);
			result = preparedStatement.executeQuery();

			if (result.next()) {

				creditCardTypeObjectFromDataBase = new BankAccountState();

				do {

					creditCardTypeObjectFromDataBase.setId(result.getInt(1));
					creditCardTypeObjectFromDataBase.setStateTypeTittle(result.getString(2));

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
	public List<BankAccountState> getListOfBankAccountStates() throws DaoException {
		
		List<BankAccountState> listOfBankAccountStates = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_LIST_BANK_ACCOUNT_STATE));

			result = preparedStatement.executeQuery();

			if (result.next()) {

				listOfBankAccountStates = new LinkedList<>();

				do {

					BankAccountState bankAccountStateObjectFromDataBase = new BankAccountState();

					bankAccountStateObjectFromDataBase.setId(result.getInt(1));
					bankAccountStateObjectFromDataBase.setStateTypeTittle(result.getString(2));

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
