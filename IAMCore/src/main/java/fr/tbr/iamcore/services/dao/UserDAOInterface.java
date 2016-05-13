package fr.tbr.iamcore.services.dao;

import java.util.List;
import fr.tbr.iamcore.datamodel.User;

public interface UserDAOInterface {
	
	public boolean write(User user);
	
	public boolean authenticate(User user);
	

}
