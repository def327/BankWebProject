package by.zyablov.bank.beans;

/**
 * Clas {@code UserProfileClient} is used to store information about user of a
 * bank system, which has an client type rights to manage a bank system.
 * <p>
 * A client type user has own bank account with personal data, all these are
 * storaged in a {@code BankAccount} object.
 * 
 * 
 * @author Дмитрий
 * 
 * @see UserProfile
 * @see BanlAccount
 *
 */
public class UserProfileClient extends UserProfile {

	private static final long serialVersionUID = 3739354623753957319L;

	/**
	 * Storages a personal bank data information of the client.
	 */
	private BankAccount bankAccount;

	/**
	 * Constructs a default <code>UserProfileClient</code>.
	 */
	public UserProfileClient() {
	}

	/**
	 * @return the bankAccount
	 */
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	/**
	 * @param bankAccount
	 *            the bankAccount to set
	 */
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

}
