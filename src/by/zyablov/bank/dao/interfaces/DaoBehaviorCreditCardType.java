package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.CreditCardType;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorCreditCardType} defines methods to work with
 * {@code CreditCardType} objects from a datasource.
 * 
 * @author Дмитрий
 * @see CreditCardType
 */
public interface DaoBehaviorCreditCardType {

	/**
	 * Get an {@code CreditCardType} object from a datasource.
	 * 
	 * @param creditCardType
	 *            An {@code CreditCardType} object to get
	 *            
	 * @return An {@code CreditCardType} object from a datasource
	 * 
	 * @throws DaoException
	 */
	CreditCardType getCreditCardType(CreditCardType creditCardType) throws DaoException;

}
