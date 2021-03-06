package by.zyablov.bank.beans;

/**
 * Class {@code AuthorityType} represents role of the user rights at the bank
 * system and it's type information data about user in a {@code UserProfile}
 * object.
 * 
 * @author Дмитрий
 * 
 * @see UserProfile
 * @see Entity
 *
 */
public class AuthorityType extends Entity {

	/**
	 * An authority type title.
	 */
	private String authorityTypeTitle;

	/**
	 * Constructs a <code>AuthorityType</code> based on authority type title.
	 * 
	 * @param authorityTypeTitle
	 *            A title for authority type
	 */
	public AuthorityType(String authorityTypeTitle) {
		this.authorityTypeTitle = authorityTypeTitle;
	}

	/**
	 * Constructs a default <code>AuthorityType</code>.
	 */
	public AuthorityType() {
	}

	/**
	 * @return the authorityTypeTitle
	 */
	public String getAuthorityTypeTitle() {
		return authorityTypeTitle;
	}

	/**
	 * @param authorityTypeTitle the authorityTypeTitle to set
	 */
	public void setAuthorityTypeTitle(String authorityTypeTitle) {
		this.authorityTypeTitle = authorityTypeTitle;
	}
	

}
