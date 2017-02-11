
package by.zyablov.bank.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * Clas {@code BankAccount} storages a personal bank information of the client:
 * data about credit cards, bank account working state.
 * 
 * 
 * @author Дмитрий
 * @see Entity
 */
public class BankAccount extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9055818037370851914L;

	/**
	 * A list of {@code CreditCard} objects with credit cards information data.
	 */
	private List<CreditCard> listOfCreditCards;

	/**
	 * A status type of banck account state.
	 */
	private BankAccountState bankAccountState;

	/**
	 * Constructs a default <code>BankAccount</code>.
	 */
	public BankAccount() {
		listOfCreditCards = new LinkedList<>();
	}

	/**
	 * Constructs an <code>BankAccount</code> object based on list of
	 * {@code CreditCard} objects and a working status state of the bank
	 * account.
	 * 
	 * 
	 * @param listOfCreditCards
	 *            A list of {@code CreditCard} objects
	 * 
	 * @param bankAccountState
	 *            A a working status state of the bank account
	 */
	public BankAccount(List<CreditCard> listOfCreditCards, BankAccountState bankAccountState) {
		this.listOfCreditCards = listOfCreditCards;
		this.bankAccountState = bankAccountState;
	}

	/**
	 * @return the listOfCreditCards
	 */
	public List<CreditCard> getListOfCreditCards() {
		return listOfCreditCards;
	}

	/**
	 * @param listOfCreditCards
	 *            the listOfCreditCards to set
	 */
	public void setListOfCreditCards(List<CreditCard> listOfCreditCards) {
		this.listOfCreditCards = listOfCreditCards;
	}

	/**
	 * @return the bankAccountState
	 */
	public BankAccountState getBankAccountState() {
		return bankAccountState;
	}

	/**
	 * @param bankAccountState
	 *            the bankAccountState to set
	 */
	public void setBankAccountState(BankAccountState bankAccountState) {
		this.bankAccountState = bankAccountState;
	}

}
