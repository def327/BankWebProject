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
	 * Constructs an <code>BankAccountState</code> object based on a working
	 * state status tittle.
	 * 
	 * @param stateTypeTittle
	 *            A title of a bank account working state status.
	 */
	public BankAccountState(String stateTypeTittle) {
		this.stateTypeTittle = stateTypeTittle;
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
