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
	 * A position of an unique user id in prepared SQL request.
	 */
	private static final int QUERY_POSITION_ID_USER = 1;

	/**
	 * Return's a {@code UserProfile} objects from database by its unuqie ID of
	 * the {@code User} object.
	 */
	@Override
	public UserProfile getUserProfile(int userId) throws DaoException {

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
				if (result.getInt(7) == 0) {

					UserProfileAdmin resultUserProfileObjectFromDataBase = new UserProfileAdmin();

					do {

						resultUserProfileObjectFromDataBase.setId(result.getInt(1));
						resultUserProfileObjectFromDataBase.setFirstName(result.getString(2));
						resultUserProfileObjectFromDataBase.setLastName(result.getString(3));
						resultUserProfileObjectFromDataBase.setEmail(result.getString(4));
						resultUserProfileObjectFromDataBase.setPassportSeria(result.getString(5));

						userProfileObjectFromDataBase = resultUserProfileObjectFromDataBase;

					} while (result.next());

				} else {

					UserProfileClient resultUserProfileObjectFromDataBase = new UserProfileClient();

					do {

						resultUserProfileObjectFromDataBase.setId(result.getInt(1));
						resultUserProfileObjectFromDataBase.setFirstName(result.getString(2));
						resultUserProfileObjectFromDataBase.setLastName(result.getString(3));
						resultUserProfileObjectFromDataBase.setEmail(result.getString(4));
						resultUserProfileObjectFromDataBase.setPassportSeria(result.getString(5));
						resultUserProfileObjectFromDataBase.setBankAccount(new BankAccount());
						resultUserProfileObjectFromDataBase.getBankAccount().setId(result.getInt(7));

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
