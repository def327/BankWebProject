package by.zyablov.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public UserProfile getUserProfile(int userId, int authorityTypeId) throws DaoException {

		/**
		 * A position of an unique ID of the {@code User} object in prepared SQL
		 * request.
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
		 * This value indicates that it's a profile of the client user.
		 */
		final int CLIENT_USER_PROFILE = 1;

		/**
		 * This value indicates that it's a profile of the admin user.
		 */
		final int ADMIN_USER_PROFILE = 2;

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

				switch (authorityTypeId) {

				case CLIENT_USER_PROFILE: {

					UserProfileClient resultUserProfileObjectFromDataBase = new UserProfileClient();

					userProfileObjectFromDataBase = initUserProfile(ID_USER_PROFILE, FIRST_NAME, LAST_NAME, EMAIL,
							PASSPORT_SERIA, result, resultUserProfileObjectFromDataBase);

					break;
				}

				case ADMIN_USER_PROFILE: {

					UserProfileAdmin resultUserProfileObjectFromDataBase = new UserProfileAdmin();

					userProfileObjectFromDataBase = initUserProfile(ID_USER_PROFILE, FIRST_NAME, LAST_NAME, EMAIL,
							PASSPORT_SERIA, result, resultUserProfileObjectFromDataBase);

					break;
				}

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
	 * Initializes a {@code UserProfile} object data fields from database.
	 * 
	 * @param indexPositionId
	 *            An index postion in a result set from the database of the
	 *            unique ID for {@code UserProfile} object.
	 * 
	 * @param indexPositionFirstName
	 *            An index postion in a result set from the database of the
	 *            first name for {@code UserProfile} object.
	 * 
	 * @param indexPositionLastName
	 *            An index postion in a result set from the database of the last
	 *            name for {@code UserProfile} object.
	 * 
	 * @param indexPositionEmail
	 *            An index postion in a result set from the database of the
	 *            email for {@code UserProfile} object.
	 * 
	 * @param indexPositionPassportSeria
	 *            An index postion in a result set from the database of the
	 *            passport seria for {@code UserProfile} object.
	 * 
	 * @param requestResult
	 *            A {@code ResultSet} object, which is received after the SQL
	 *            request execution
	 * 
	 * @param noInitializedUserProfile
	 *            An {@code UserProfile} object to initialize
	 * 
	 * @return An {@code UserProfile} object
	 * 
	 * @throws SQLException
	 */
	private UserProfile initUserProfile(final int indexPositionId, final int indexPositionFirstName,
			final int indexPositionLastName, final int indexPositionEmail, final int indexPositionPassportSeria,
			ResultSet requestResult, UserProfile noInitializedUserProfile) throws SQLException {

		UserProfile userProfileObjectFromDataBase;

		do {

			noInitializedUserProfile.setId(requestResult.getInt(indexPositionId));
			noInitializedUserProfile.setFirstName(requestResult.getString(indexPositionFirstName));
			noInitializedUserProfile.setLastName(requestResult.getString(indexPositionLastName));
			noInitializedUserProfile.setEmail(requestResult.getString(indexPositionEmail));
			noInitializedUserProfile.setPassportSeria(requestResult.getString(indexPositionPassportSeria));

			userProfileObjectFromDataBase = noInitializedUserProfile;

		} while (requestResult.next());

		return userProfileObjectFromDataBase;
	}

	/**
	 * Adds a new {@code UserProfile} object to to a database.
	 */
	@Override
	public void addNewUserProfile(int userId, UserProfile userProfile) throws DaoException {

		/**
		 * A position of a first name for the {@code UserProfile} object in
		 * prepared SQL request.
		 */
		final int QUERY_POSITION_FIRST_NAME = 1;

		/**
		 * A position of a last name for the {@code UserProfile} object in
		 * prepared SQL request.
		 */
		final int QUERY_POSITION_LAST_NAME = 2;

		/**
		 * A position of an email for the {@code UserProfile} object in prepared
		 * SQL request.
		 */
		final int QUERY_POSITION_EMAIL = 3;

		/**
		 * A position of a passport seria for the {@code UserProfile} object in
		 * prepared SQL request.
		 */
		final int QUERY_POSITION_PASSPORT_SERIA = 4;

		/**
		 * A position of an unique ID of the {@code User} object in prepared SQL
		 * request.
		 */
		final int QUERY_POSITION_USER_ID = 5;

		Connection connectionToDataBase = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connectionToDataBase = super.dataSource.getConnection();

			preparedStatement = connectionToDataBase
					.prepareStatement(super.managerSQL.getPreparedSqlRequest(ManagerSQL.SQL_ADD_NEW_USER_PROFILE));

			preparedStatement.setString(QUERY_POSITION_FIRST_NAME, userProfile.getFirstName());
			preparedStatement.setString(QUERY_POSITION_LAST_NAME, userProfile.getLastName());
			preparedStatement.setString(QUERY_POSITION_EMAIL, userProfile.getEmail());
			preparedStatement.setString(QUERY_POSITION_PASSPORT_SERIA, userProfile.getPassportSeria());
			preparedStatement.setInt(QUERY_POSITION_USER_ID, userId);

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
