package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorUser} defines methods to work with
 * {@code UserProfile} objects from a datasource.
 * 
 * @author Дмитрий
 * 
 * @see UserProfile
 *
 */
public interface DaoBehaviorUserProfile {

	/**
	 * Return's an {@code UserProfile} object from a datasource.
	 * 
	 * @param userId
	 *            An unique ID of the {@code User} object to get
	 * 
	 * @return An {@code UserProfile} object from a datasource
	 * 
	 * @throws DaoException
	 */
	UserProfile getUserProfile(int userId) throws DaoException;

	/**
	 * Adds an {@code UserProfile} object to a datasource.
	 * 
	 * @param userId
	 *            An unique ID of an {@code User} object
	 * 
	 * @param userProfile
	 *            An {@code UserProfile} object to add
	 * 
	 * @throws DaoException
	 */
	void addNewUserProfile(int userId, UserProfile userProfile) throws DaoException;

}
