
package by.zyablov.bank.dao;

import by.zyablov.bank.beans.User;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUser;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoUser} provides methods to work with {@code User} objects.
 * 
 * @author Дмитрий
 * 
 * @see User
 */
public class DaoUser extends DaoAbstract implements DaoBehaviorUser {

	/**
	 * Return's an {@code User} object by unique login.
	 */
	@Override
	public User getUserByLogin(User user) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Adds a new {@code User} object to a database.
	 */
	@Override
	public void addNewUser(User user) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * Updates fields of {@code User} object at the database.
	 */
	@Override
	public void updateUser(User user) throws DaoException {
		// TODO Auto-generated method stub
	}

}
