package by.zyablov.bank.dao.interfaces;

import by.zyablov.bank.beans.AuthorityType;
import by.zyablov.bank.exceptions.DaoException;

/**
 * Interface {@code DaoBehaviorAuthorityType} defines methods to work with
 * {@code AuthorityType} objects from a datasource.
 * 
 * @author Дмитрий
 * @see AuthorityType
 */
public interface DaoBehaviorAuthorityType {

	/**
	 * Return's an {@code AuthorityType} object from a datasource.
	 * 
	 * @param authorityTypeId
	 *            A unique ID of an {@code AuthorityType} object to get
	 * 
	 * @return An {@code AuthorityType} object from a datasource
	 * 
	 * @throws DaoException
	 */
	AuthorityType getAuthorityTypeById(int authorityTypeId) throws DaoException;

}
