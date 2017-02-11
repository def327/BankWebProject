package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.User;
import by.zyablov.bank.exceptions.DaoException;

/**
 * 
 * 
 * @author Дмитрий
 *
 */
public interface DaoBehaviorUserProfile {

	User getUser(User user) throws DaoException;

	void addNewUser(User user) throws DaoException;

	void updateUser(User user) throws DaoException;

}
