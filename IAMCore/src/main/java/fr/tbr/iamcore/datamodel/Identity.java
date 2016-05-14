package fr.tbr.iamcore.datamodel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * @author Tom
 *
 */

@Entity
@Table(name="IDENTITIES", uniqueConstraints = {@UniqueConstraint(columnNames=("IDENTITIES_EMAIL"))})
public class Identity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDENTITIES_ID")
	private int id;

	@Column(name="IDENTITIES_FIRSTNAME")
	private String firstName;

	@Column(name="IDENTITIES_LASTNAME")
	private String lastName;

	@Column(name="IDENTITIES_EMAIL")
	private String email;

	@Column(name="IDENTITIES_BIRTHDATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	/**
	 * This is the default constructor
	 */
	public Identity(){

	}
	/**
	 * This is a constructor for Identity Object
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param birthDate
	 */
	public Identity(String firstName, String lastName, String email , Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDate=birthDate;
	}
	/**
	 * This is a constructor for Identity Object but without the birthdate
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Identity(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	 * Overriding the toString function to return the object in a String format
	 * @return String
	 */
	@Override
	public String toString() {
		return "Identity [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", birthDate=" + birthDate + "]\n";
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
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
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * Return the ID of the object
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Set the ID of the object
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
