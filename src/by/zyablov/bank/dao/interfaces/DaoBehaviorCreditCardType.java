package by.zyablov.bank.dao.interfaces;

import java.util.List;

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
	 * Return's a {@code CreditCardType} object from a datasource.
	 * 
	 * @param creditCardTypeId
	 *            A unique ID of an {@code CreditCardType} object to get
	 * 
	 * @return A {@code CreditCardType} object from a datasource
	 * 
	 * @throws DaoException
	 */
	CreditCardType getCreditCardType(int creditCardTypeId) throws DaoException;

	/**
	 * Return's a list of {@code CreditCardType} objects, that exist at the
	 * datasource.
	 * 
	 * @return A list of {@code CreditCardType} objects
	 * 
	 * @throws DaoException
	 */
	List<CreditCardType> getListOfCreditCardTypes() throws DaoException;

}
