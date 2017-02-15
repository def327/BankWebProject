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
	 * @param userProfileId
	 *            A unique ID of an {@code UserProfile} object 
	 * 
	 * @return An {@code BankAccount} object from a datasource
	 * 
	 * @throws DaoException
	 */
	BankAccount getBankAccountById(int userProfileId) throws DaoException;

	/**
	 * Adds an {@code BankAccount} object to a datasource.
	 * 
	 * @param userProfileId
	 *            A unique ID of an {@code UserProfile} object
	 * 
	 * @param bankAccountMoneyBalance
	 *            A money balance for a {@code BankAccount} object
	 * 
	 * @param bankAccountStateId
	 *            A working state ID of a {@code BankAccount} object
	 * 
	 * @throws DaoException
	 */
	void addNewBankAccount(int userProfileId, int bankAccountMoneyBalance, int bankAccountStateId) throws DaoException;

	/**
	 * Updates an {@code BankAccount} object current money balance at the
	 * datasource.
	 * 
	 * @param bankAccountId
	 *            A unique ID of an {@code BankAccount} object to update
	 * 
	 * @param newBalance
	 *            A value of a new balance for an {@code BankAccount} object at
	 *            the datasource.
	 * 
	 * @throws DaoException
	 */
	void updateBankAccountCurrentBalance(int bankAccountId, int newBalance) throws DaoException;

	/**
	 * Updates an {@code BankAccount} object current working state at the
	 * datasource.
	 * 
	 * @param bankAccountId
	 *            A unique ID of an {@code BankAccount} object to update
	 * 
	 * @param bankAccountStateId
	 *            A unique ID of an {@code BankAccountState} object
	 * 
	 * @throws DaoException
	 */
	void updateBankAccountStateId(int bankAccountId, int bankAccountStateId) throws DaoException;

}

