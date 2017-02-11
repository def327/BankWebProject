package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.CreditCard;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorCreditCard} defines methods to work with
 * {@code CreditCard} objects from a datasource.
 * 
 * @author Дмитрий
 * 
 * @see CreditCard
 */
public interface DaoBehaviorCreditCard {

	/**
	 * Get an {@code CreditCard} object from a datasource.
	 * 
	 * @param creditCard
	 *            An {@code CreditCard} object to get
	 * 
	 * @return An {@code CreditCard} object from a datasource
	 * 
	 * @throws DaoException
	 */
	CreditCard getCreditCard(CreditCard creditCard) throws DaoException;

	/**
	 * Add an {@code CreditCard} object to a datasource.
	 * 
	 * @param creditCard
	 *            An {@code CreditCard} object to add
	 * 
	 * @throws DaoException
	 */
	void addNewCreditCard(CreditCard creditCard) throws DaoException;

}
