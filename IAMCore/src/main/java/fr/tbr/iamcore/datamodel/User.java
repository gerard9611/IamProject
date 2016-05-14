/**
 * 
 */
package fr.tbr.iamcore.datamodel;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * @author Tom
 *
 */

@Entity
@Table(name="USERS", uniqueConstraints = {@UniqueConstraint(columnNames=("USER_USERNAME"))})
public class User {

	private static User instance = null;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int id;

	@Column(name="USER_USERNAME")
	private String username;

	@Column(name="USER_PASSWORD")
	private String password;

	@JoinColumn(name="USERIDENTITY_ID")
	@ManyToOne(cascade = {CascadeType.ALL})
	Identity userIdentity;
	/**
	 * This is the default constructor
	 */
	protected User() {
		// Exists only to defeat instantiation.
	}
	public static User getInstance() {
		if(instance == null) {
			instance = new User();
		}
		return instance;
	}

	/**
	 * This is a constructor of the object User
	 * @param username
	 * @param password
	 * @param userIdentity
	 */
	public User(String username, String password, Identity userIdentity ) {
		super();
		this.username = username;
		this.password = password;
		this.userIdentity = userIdentity;
	}
	/**
	 * This is to get the ID of the user
	 * @return int
	 */
	public int getId() {
		return id;
	}
	/**
	 * This is to set the ID of the user
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the lastName
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the birthDate
	 */
	public Identity getUserIdentitiy() {
		return userIdentity;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setUserIdentity(Identity userIdentity) {
		this.userIdentity = userIdentity;
	}
}
