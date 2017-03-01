package by.zyablov.bank.dao.interfaces;

import java.util.List;

import by.zyablov.bank.beans.Book;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorCreditCard} defines methods to work with
 * {@code CreditCard} objects from a datasource.
 * 
 * @author Дмитрий
 * 
 * @see Book
 */
public interface DaoBehaviorCreditCard {

	/**
	 * Return's a list of {@code CreditCard} objects, that are linked to the
	 * concrete {@code BankAccount} object from a datasource.
	 * 
	 * @param bankAccountId
	 *            A unique ID of an {@code BankAccount} object
	 * 
	 * @return A list of {@code CreditCard} objects
	 * 
	 * @throws DaoException
	 */
	List<Book> getListOfCreditCard(int bankAccountId) throws DaoException;

	/**
	 * Adds a {@code CreditCard} object to a datasource.
	 * 
	 * @param book
	 *            An {@code CreditCard} object to add
	 * 
	 * @param bankAccountId
	 *            A unique ID of an {@code BankAccount} object
	 * 
	 * @throws DaoException
	 */
	void addNewCreditCard(Book book, int bankAccountId) throws DaoException;

}
