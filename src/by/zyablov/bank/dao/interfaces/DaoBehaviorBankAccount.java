package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.BankAccount;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorBankAccount} defines methods to work with
 * {@code BankAccount} objects from a datasource.
 * 
 * @author Дмитрий
 * @see BankAccount
 *
 */
public interface DaoBehaviorBankAccount {

	/**
	 * Return's an {@code BankAccount} object from a datasource.
	 * 
	 * @param bankAccount
	 *            An {@code BankAccount} object to get
	 * 
	 * @return An {@code BankAccount} object from a datasource
	 * 
	 * @throws DaoException
	 */
	BankAccount getBankAccountById(BankAccount bankAccount) throws DaoException;

	/**
	 * Adds an {@code BankAccount} object to a datasource.
	 * 
	 * @param bankAccount
	 *            An {@code BankAccount} object to add
	 * @throws DaoException
	 */
	void addNewBankAccount(BankAccount bankAccount) throws DaoException;

	/**
	 * Updates an {@code BankAccount} object at the datasource.
	 * 
	 * @param bankAccount
	 *            An {@code BankAccount} object to update
	 * 
	 * @throws DaoException
	 */
	void updateBankAccountCurrentBalance(BankAccount bankAccount) throws DaoException;

}
