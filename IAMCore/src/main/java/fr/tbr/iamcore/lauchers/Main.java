/**
 * 
 */
package fr.tbr.iamcore.lauchers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.services.dao.IdentityDAOInterface;

/**
 * @author Tom
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println("Welcome to the IAM system");
		
		
	
		Identity identity = new Identity("thomas", "broussard", "tbr@tbr.com");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date birthDate = formatter.parse("2015/05/05");
		identity.setBirthDate(birthDate);
		
	}

}
