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
	
//	private Map<String, String> properties = new HashMap<String, String>();
//    private Map<String, Callable<Object>> callables = new HashMap<String, Callable<Object>>();
//
//    
//    public String getProperty(String key) {
//        return properties.get(key);
//    }
//
//    public void setProperty(String key, String value) {
//        properties.put(key, value);
//    }
//
//    public Object call(String key) {
//        Callable<Object> callable = callables.get(key);
//        try {
//			return callable.call();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        return null;
//    }

//    public void define(String key, Callable<Object> callable) {
//        callables.put(key, callable);
//    }
    
    
    
	public Identity(){
		
	}
	
	public Identity(String firstName, String lastName, String email , Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDate=birthDate;
	}
	public Identity(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
