package by.zyablov.bank.beans;

import java.io.Serializable;

/**
 * Class {@code Entity} is a storable object in a database.
 * 
 * @author Дмитрий
 *
 */
public abstract class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4530667728349210633L;
	
	private int id;

	/**
	 * Constructs a default <code>Entity</code>
	 */
	public Entity() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	

}
