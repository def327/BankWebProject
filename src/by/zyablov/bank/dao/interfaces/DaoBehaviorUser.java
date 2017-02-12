
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
	 * Return's a {@code User} object from a datasource.
	 * 
	 * 
	 * @param user
	 *            An {@code User} object to get
	 * 
	 * @return An {@code User} object from a datasource
	 * 
	 * @throws DaoException
	 */
	User getUserByLogin(String userLogin) throws DaoException;

	/**
	 * Add an {@code User} object to a datasource.
	 * 
	 * @param user
	 *            An {@code User} object to add
	 * 
	 * @throws DaoException
	 */
	void addNewUserClient(User user) throws DaoException;


}
