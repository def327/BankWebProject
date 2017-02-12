package by.zyablov.bank.dao;

import java.util.List;

import by.zyablov.bank.beans.CreditCard;
import by.zyablov.bank.dao.interfaces.DaoBehaviorCreditCard;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Class {@code DaoCreditCard} provides methods to work with {@code CreditCard}
 * object at the database.
 * 
 * @author Дмитрий
 * 
 * @see CreditCard
 *
 */
public class DaoCreditCard extends DaoAbstract implements DaoBehaviorCreditCard {

	/**
	 * Return's a list of {@code CreditCard} objects by its unique ID of the
	 * {@code BankAccount} object.
	 */
	@Override
	public List<CreditCard> getCreditCard(CreditCard creditCard) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Adds a new {@code CreditCard} object to a database.
	 */
	@Override
	public void addNewCreditCard(CreditCard creditCard) throws DaoException {
		// TODO Auto-generated method stub

	}

}
