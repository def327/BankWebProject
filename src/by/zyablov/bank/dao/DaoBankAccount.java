package by.zyablov.bank.dao;

import by.zyablov.bank.beans.BankAccount;
import by.zyablov.bank.dao.interfaces.DaoBehaviorBankAccount;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoBankAccount} provides methods to work with
 * {@code BankAccount} object at the database.
 * 
 * @author Дмитрий
 *
 * @see BankAccount
 */
public class DaoBankAccount extends DaoAbstract implements DaoBehaviorBankAccount {

	/**
	 * Returns a {@code BankAccount} object by from a database by its unique ID.
	 */
	@Override
	public BankAccount getBankAccountById(BankAccount bankAccount) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Adds a new {@code BankAccount} object to a database.
	 */
	@Override
	public void addNewBankAccount(BankAccount bankAccount) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * Updates a current balance of a {@code BankAccount} object at the database.
	 */
	@Override
	public void updateBankAccountCurrentBalance(BankAccount bankAccount) throws DaoException {
		// TODO Auto-generated method stub

	}

}
