package by.zyablov.bank.beans;

/**
 * Class {@code CreditCard} storages information about credit card and is tied
 * to a {@code BankAccount} object.
 * 
 * 
 * @author Дмитрий
 * 
 * @see BankAccount
 * @see Entity
 */
public class CreditCard extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2866230038578315409L;

	/**
	 * A unique number, which consists of a unique combination of characters and
	 * digitsю
	 */
	private String uniqueCardNumber;

	/**
	 * A type of credit card.
	 */
	private CreditCardType cardtype;

	/**
	 * Constructs a default <code>CreditCard</code>.
	 */
	public CreditCard() {
	}

	/**
	 * Constructs a <code>CreditCard</code> based on the unique card number and
	 * the type of the card.
	 * 
	 * 
	 * @param uniqueCardNumber
	 *            A unique card number
	 * 
	 * @param cardtype
	 *            A type of a credit card
	 */
	public CreditCard(String uniqueCardNumber, CreditCardType cardtype) {
		this.uniqueCardNumber = uniqueCardNumber;
		this.cardtype = cardtype;
	}

	/**
	 * @return the uniqueCardNumber
	 */
	public String getUniqueCardNumber() {
		return uniqueCardNumber;
	}

	/**
	 * @param uniqueCardNumber
	 *            the uniqueCardNumber to set
	 */
	public void setUniqueCardNumber(String uniqueCardNumber) {
		this.uniqueCardNumber = uniqueCardNumber;
	}

	/**
	 * @return the cardtype
	 */
	public CreditCardType getCardtype() {
		return cardtype;
	}

	/**
	 * @param cardtype
	 *            the cardtype to set
	 */
	public void setCardtype(CreditCardType cardtype) {
		this.cardtype = cardtype;
	}

}
