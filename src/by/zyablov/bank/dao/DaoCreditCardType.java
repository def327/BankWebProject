package by.zyablov.bank.dao;

import by.zyablov.bank.beans.CreditCardType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorCreditCardType;
import by.zyablov.bank.exceptions.DaoException;

/**
 * 
 * Class {@code DaoCreditCardType} provides methods to work with
 * {@code CreditCardType} object at the database.
 * 
 * @author Дмитрий
 *
 */
public class DaoCreditCardType extends DaoAbstract implements DaoBehaviorCreditCardType {

	/**
	 * Return's a {@code CreditCard} object from a database by its unique ID.
	 */
	@Override
	public CreditCardType getCreditCardType(CreditCardType creditCardType) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
