
package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.User;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorUser} defines methods to work with {@code User}
 * objects from a datasource.
 * 
 * 
 * @author Дмитрий
 * @see User
 *
 */
public interface DaoBehaviorUser {

	/**
	 * Get an {@code User} object from a datasource.
	 * 
	 * 
	 * @param user
	 *            An {@code User} object to get
	 * 
	 * @return An {@code User} object from a datasource
	 * 
	 * @throws DaoException
	 */
	User getUser(User user) throws DaoException;

	/**
	 * Add an {@code User} object to a datasource.
	 * 
	 * @param user
	 *            An {@code User} object to add
	 * 
	 * @throws DaoException
	 */
	void addNewUser(User user) throws DaoException;

	/**
	 * Update an {@code User} object at the datasource.
	 * 
	 * @param userProfile
	 *            An {@code User} object to update
	 * 
	 * @throws DaoException
	 */
	void updateUser(User user) throws DaoException;

}
