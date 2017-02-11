package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorUser} declares methods to work with
 * {@code UserProfile} objects from a datasource.
 * 
 * @author Дмитрий
 * 
 * @see UserProfile
 *
 */
public interface DaoBehaviorUserProfile {

	/**
	 * Get an {@code UserProfile} object from a datasource.
	 * 
	 * @param userProfile
	 *            An {@code UserProfile} object to get
	 * 
	 * @return An {@code UserProfile} object from a datasource
	 * 
	 * @throws DaoException
	 */
	UserProfile getUserProfile(UserProfile userProfile) throws DaoException;

	/**
	 * Add an {@code UserProfile} object to a datasource.
	 * 
	 * @param userProfile
	 *            An {@code UserProfile} object to add
	 * 
	 * @throws DaoException
	 */
	void addNewUserProfile(UserProfile userProfile) throws DaoException;

	/**
	 * Update an {@code UserProfile} object at the datasource.
	 * 
	 * @param userProfile
	 *            An {@code UserProfile} object to update
	 * 
	 * @throws DaoException
	 */
	void updateUserProfile(UserProfile userProfile) throws DaoException;

}
