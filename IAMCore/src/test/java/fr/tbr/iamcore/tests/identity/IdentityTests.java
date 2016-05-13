/**
 * 
 */
package fr.tbr.iamcore.tests.identity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import fr.tbr.iamcore.datamodel.Identity;
/**
 * @author Tom
 *
 */
public class IdentityTests {

	
	public static void main(String[] args){

		
		
		
	}

	private static void searchTests() {
		Identity thomas = new Identity("thomas", "broussard","tbr@tbr.com");
		Identity quentin = new Identity("quentin", "decayeux","qdc@qdc.com");
		
	}

	private static void olderWriteMethod(Identity identity) {
		File file = createFile("/identities/identities.txt");
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("Begin");
		write(identity, writer);
		
		writer.flush();
		writer.close();
	}

	private static void write(Identity identity, PrintWriter writer) {
		writer.println(identity.getFirstName());
		writer.println(identity.getLastName());
		writer.println(identity.getEmail());
		writer.println(identity.getBirthDate());

	}

	private static File createFile(String path) {
		File file = new File(path);

		if (!file.exists()){
			try {
				File parent = file.getParentFile();
				if (!parent.exists()){
					parent.mkdirs();
				}
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Something gone wrong in the file creation, see the following stack trace");
				e.printStackTrace();
			}
		}
		
		return file;
	}
}
