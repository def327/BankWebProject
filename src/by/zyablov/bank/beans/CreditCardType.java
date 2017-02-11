package by.zyablov.bank.beans;

/**
 * Class {@code CreditCardType} storages information about credit card type.
 * 
 * @author Дмитрий
 * 
 * @see CreditCard
 * @see Entity
 */
public class CreditCardType extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1368947361985575049L;
	/**
	 * An credit card type title.
	 */
	private String cardTypeTitle;

	/**
	 * Constructs a default <code>CreditCardType</code>.
	 */
	public CreditCardType() {
	}

	/**
	 * Constructs a <code>CreditCardType</code> based on a credit card type
	 * title.
	 * 
	 * @param cardTypeTitle
	 *            A title for a credit card type
	 */
	public CreditCardType(String cardTypeTitle) {
		this.cardTypeTitle = cardTypeTitle;
	}

	/**
	 * @return the cardTypeTitle
	 */
	public String getCardTypeTitle() {
		return cardTypeTitle;
	}

	/**
	 * @param cardTypeTitle
	 *            the cardTypeTitle to set
	 */
	public void setCardTypeTitle(String cardTypeTitle) {
		this.cardTypeTitle = cardTypeTitle;
	}

}
