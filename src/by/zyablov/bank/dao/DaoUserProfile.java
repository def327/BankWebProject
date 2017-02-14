package by.zyablov.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.zyablov.bank.beans.BankAccount;
import by.zyablov.bank.beans.User;
import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.beans.UserProfileAdmin;
import by.zyablov.bank.beans.UserProfileClient;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUserProfile;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.datasource.tools.ManagerSQL;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoUserProfile} provides methods to work with
 * {@code UserProfile} objects.
 * 
 * @author Дмитрий
 * 
 * @see UserProfile
 *
 */
public class DaoUserProfile extends DaoAbstract implements DaoBehaviorUserProfile {

	/**
	 * Return's a {@code UserProfile} objects from database by its unuqie ID of
	 * the {@code User} object.
	 */
	@Override
	public UserProfile getUserProfile(int userId) throws DaoException {

		/**
		 * A position of an unique user's ID in prepared SQL request.
		 */
		final int QUERY_POSITION_ID_USER = 1;

		/**
		 * Database answer field index of an unique profile ID for an
		 * {@code UserProfile} object from a database.
		 */
		final int ID_USER_PROFILE = 1;

		/**
		 * Database answer field index of a first name for an
		 * {@code UserProfile} object from a database.
		 */
		final int FIRST_NAME = 2;

		/**
		 * Database answer field index of a last name for an {@code UserProfile}
		 * object from a database.
		 */
		final int LAST_NAME = 3;

		/**
		 * Database answer field index of an email for an {@code UserProfile}
		 * object from a database.
		 */
		final int EMAIL = 4;

		/**
		 * Database answer field index of a passport seria for an
		 * {@code UserProfile} object from a database.
		 */
		final int PASSPORT_SERIA = 5;

		/**
		 * Database answer field index of an unique bank account ID for a
		 * {@code BankAccount} object from database.
		 */
		final int ID_BANK_ACCOUNT = 7;

		/**
		 * This value indicates that a field 'id_bank_account' is NULL at the
		 * database, means it's a profile of the admin.
		 */
		final int ADMIN_PROFILE_INDICATOR = 0;

		UserProfile userProfileObjectFromDataBase = null;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_GET_USER_PROFILE));

			preparedStatement.setInt(QUERY_POSITION_ID_USER, userId);
			result = preparedStatement.executeQuery();

			if (result.next()) {

				// Admin profile
				if (result.getInt(ID_BANK_ACCOUNT) == ADMIN_PROFILE_INDICATOR) {

					UserProfileAdmin resultUserProfileObjectFromDataBase = new UserProfileAdmin();

					do {

						resultUserProfileObjectFromDataBase.setId(result.getInt(ID_USER_PROFILE));
						resultUserProfileObjectFromDataBase.setFirstName(result.getString(FIRST_NAME));
						resultUserProfileObjectFromDataBase.setLastName(result.getString(LAST_NAME));
						resultUserProfileObjectFromDataBase.setEmail(result.getString(EMAIL));
						resultUserProfileObjectFromDataBase.setPassportSeria(result.getString(PASSPORT_SERIA));

						userProfileObjectFromDataBase = resultUserProfileObjectFromDataBase;

					} while (result.next());

				} else {

					// Client profile

					UserProfileClient resultUserProfileObjectFromDataBase = new UserProfileClient();

					do {

						resultUserProfileObjectFromDataBase.setId(result.getInt(ID_USER_PROFILE));
						resultUserProfileObjectFromDataBase.setFirstName(result.getString(FIRST_NAME));
						resultUserProfileObjectFromDataBase.setLastName(result.getString(LAST_NAME));
						resultUserProfileObjectFromDataBase.setEmail(result.getString(EMAIL));
						resultUserProfileObjectFromDataBase.setPassportSeria(result.getString(PASSPORT_SERIA));
						resultUserProfileObjectFromDataBase.setBankAccount(new BankAccount());
						resultUserProfileObjectFromDataBase.getBankAccount().setId(result.getInt(ID_BANK_ACCOUNT));

						userProfileObjectFromDataBase = resultUserProfileObjectFromDataBase;

					} while (result.next());

				}

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

		return userProfileObjectFromDataBase;
	}

	/**
	 * Adds a new {@code UserProfile} object to to a database.
	 */
	@Override
	public void addNewUserProfile(User user) throws DaoException {

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_ADD_NEW_USER_PROFILE));

			if (user.getUserProfile() instanceof UserProfileClient) {

				preparedStatement.setString(1, user.getUserProfile().getFirstName());
				preparedStatement.setString(2, user.getUserProfile().getLastName());
				preparedStatement.setString(3, user.getUserProfile().getEmail());
				preparedStatement.setString(4, user.getUserProfile().getPassportSeria());
				preparedStatement.setInt(5, user.getId());
				preparedStatement.setInt(6, ((UserProfileClient) user.getUserProfile()).getBankAccount().getId());

			} else if (user.getUserProfile() instanceof UserProfileAdmin) {

				// Refactor check the null at the admin

				preparedStatement.setString(1, user.getUserProfile().getFirstName());
				preparedStatement.setString(2, user.getUserProfile().getLastName());
				preparedStatement.setString(3, user.getUserProfile().getEmail());
				preparedStatement.setString(4, user.getUserProfile().getPassportSeria());
				preparedStatement.setInt(5, user.getId());
				preparedStatement.setNull(6, java.sql.Types.INTEGER);
			}

			preparedStatement.setInt(QUERY_POSITION_ID_USER, user.getId());

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
