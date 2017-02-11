package by.zyablov.bank.beans;

/**
 * Class {@code User} is used to store authority information about user for a
 * bank system.
 * 
 * @author Дмитрий
 * 
 * @see Entity
 *
 */
public class User extends Entity {

	/**
	 * A unique login for a user to authorize in a bank.
	 */
	private String login;

	/**
	 * A sercret password to verife user in a bank.
	 */
	private String password;

	/**
	 * Indicates the user rights and type of {@code UserProfile} object.
	 */
	private AuthorityType authorityType;

	/**
	 * A unique user's data for a bank system.
	 * 
	 * @see UserProfile
	 */
	private UserProfile userProfile;

	/**
	 * 
	 * Constructs a <code>User</code> based on login, password for
	 * authorization, type of authority role and {@code UserProfile} object.
	 * 
	 * @param login
	 *            An unique login for a user to authorize
	 * 
	 * @param password
	 *            A sercret password to verife user
	 * 
	 * @param authorityType
	 *            A type of user's authority role
	 * 
	 * @param userProfile
	 *            A unique user's data
	 */
	public User(String login, String password, AuthorityType authorityType, UserProfile userProfile) {
		this.login = login;
		this.password = password;
		this.authorityType = authorityType;
		this.userProfile = userProfile;
	}

	/**
	 * Constructs a default <code>User</code>.
	 */
	public User() {
		super();
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the authorityType
	 */
	public AuthorityType getAuthorityType() {
		return authorityType;
	}

	/**
	 * @param authorityType
	 *            the authorityType to set
	 */
	public void setAuthorityType(AuthorityType authorityType) {
		this.authorityType = authorityType;
	}

	/**
	 * @return the userProfile
	 */
	public UserProfile getUserProfile() {
		return userProfile;
	}

	/**
	 * @param userProfile
	 *            the userProfile to set
	 */
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
