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

	/**
	 * Storages a personal bank data information of the client.
	 */
	private BankAccount bankAccount;

	/**
	 * Constructs a default <code>UserProfileClient</code>.
	 */
	public UserProfileClient() {
		super();
	}

	/**
	 * 
	 * Constructs an <code>UserProfileClient</code> object based on first name,
	 * last name, email, passport seria of user and it's personal bank account.
	 * 
	 * @param firstName
	 *            A user's name
	 * 
	 * @param lastName
	 *            A user's surname
	 * 
	 * @param email
	 *            A user's email
	 * 
	 * @param passportSeria
	 *            A user's unique passport seria
	 * 
	 * @param bankAccount
	 *            A personal bank information of the client
	 */
	public UserProfileClient(String firstName, String lastName, String email, String passportSeria,
			BankAccount bankAccount) {
		super(firstName, lastName, email, passportSeria);
		this.bankAccount = bankAccount;
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
