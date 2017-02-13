package by.zyablov.bank.dao.interfaces;

import java.util.List;

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
	 * Return's a list of {@code CreditCard} objects from a datasource.
	 * 
	 * @param creditCard
	 *            An {@code CreditCard} object to get
	 * 
	 * @return A list of {@code CreditCard} objects from a datasource
	 * 
	 * @throws DaoException
	 */
	List<CreditCard> getListOfCreditCard(int bankAccountId) throws DaoException;

	/**
	 * Adds a {@code CreditCard} object to a datasource.
	 * 
	 * @param creditCard
	 *            An {@code CreditCard} object to add
	 * 
	 * @throws DaoException
	 */
	void addNewCreditCard(CreditCard creditCard, int bankAccountId) throws DaoException;

}
