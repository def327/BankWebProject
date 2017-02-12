package by.zyablov.bank.dao;

import by.zyablov.bank.beans.User;
import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUserProfile;
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
	public UserProfile getUserProfile(User user) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Adds a new {@code UserProfile} object to to a database.
	 */
	@Override
	public void addNewUserProfile(UserProfile userProfile) throws DaoException {
		// TODO Auto-generated method stub

	}



}
