package by.zyablov.bank.beans;

/**
 * Clas {@code UserProfile} is used to store information about user of a bank
 * system.
 * 
 * @author Дмитрий
 *
 * @see User
 * @see Entity
 *
 */
public abstract class UserProfile extends Entity {

	private static final long serialVersionUID = 1843129991218926585L;

	/**
	 * A user's name.
	 */
	private String firstName;

	/**
	 * A user's surname.
	 */
	private String lastName;

	/**
	 * A user's email.
	 */
	private String email;

	/**
	 * A user's unique passport seria.
	 */
	private String passportSeria;

	/**
	 * Constructs a default <code>UserProfile</code>.
	 */
	public UserProfile() {
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the passportSeria
	 */
	public String getPassportSeria() {
		return passportSeria;
	}

	/**
	 * @param passportSeria
	 *            the passportSeria to set
	 */
	public void setPassportSeria(String passportSeria) {
		this.passportSeria = passportSeria;
	}

}
