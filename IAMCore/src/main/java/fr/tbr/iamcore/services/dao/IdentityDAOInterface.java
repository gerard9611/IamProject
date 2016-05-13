package fr.tbr.iamcore.services.dao;

import java.util.List;

import fr.tbr.iamcore.datamodel.Identity;

public interface IdentityDAOInterface {

	public List<Identity> readAll();

	public List<Identity> search(String searchText);
	
	public boolean write(Identity identity);
	
	public void update(Identity identity);
	
	public boolean delete(Identity identity);

}
