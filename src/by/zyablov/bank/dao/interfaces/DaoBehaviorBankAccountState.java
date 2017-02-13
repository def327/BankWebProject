package by.zyablov.bank.dao.interfaces;

import java.util.List;

import by.zyablov.bank.beans.BankAccountState;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorBankAccountState} defines methods to work with
 * {@code BankAccountState} objects from a datasource.
 * 
 * @author Дмитрий
 * 
 * @see BankAccountState
 *
 */
public interface DaoBehaviorBankAccountState {

	/**
	 * Return's an {@code BankAccountState} object from a datasource.
	 * 
	 * @param bankAccountStateId
	 *            A unique ID of an {@code BankAccountState} object to get
	 * 
	 * @return An {@code BankAccountState} object from a datasource
	 * 
	 * @throws DaoException
	 */
	BankAccountState getBankAccountState(int bankAccountStateId) throws DaoException;

	/**
	 * Return's a list of {@code BankAccountState} objects, that exist at the
	 * datasource.
	 * 
	 * @return A list of {@code BankAccountState} objects
	 * 
	 * @throws DaoException
	 */
	List<BankAccountState> getListOfBankAccountStates() throws DaoException;

}
