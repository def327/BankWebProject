package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.User;
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
	 *            An unique ID of an {@code UserProfile} object to get
	 * 
	 * @return An {@code UserProfile} object from a datasource
	 * 
	 * @throws DaoException
	 */
	UserProfile getUserProfile(int userId) throws DaoException;

	/**
	 * Adds an {@code UserProfile} object to a datasource.
	 * 
	 * @param user
	 *            An {@code User} object, that contains this {@code UserProfile}
	 *            object.
	 * 
	 * @throws DaoException
	 */
	void addNewUserProfile(User user) throws DaoException;

}
