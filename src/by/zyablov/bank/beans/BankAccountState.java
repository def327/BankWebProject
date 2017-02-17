package by.zyablov.bank.beans;

/**
 * Class {@code BankAccountState} storages a working state status of a
 * {@code BankAccount} object.
 * 
 * @author Дмитрий
 *
 * @see BankAccount
 * @see Entity
 */
public class BankAccountState extends Entity {


	private static final long serialVersionUID = 3465635915905101167L;
	/**
	 * A working state status title of a {@code BankAccount} object.
	 */
	private String stateTypeTittle;

	/**
	 * Constructs a default <code>BankAccountState</code>.
	 */
	public BankAccountState() {
		super();
	}

	/**
	 * @return the stateTypeTittle
	 */
	public String getStateTypeTittle() {
		return stateTypeTittle;
	}

	/**
	 * @param stateTypeTittle
	 *            the stateTypeTittle to set
	 */
	public void setStateTypeTittle(String stateTypeTittle) {
		this.stateTypeTittle = stateTypeTittle;
	}

}
