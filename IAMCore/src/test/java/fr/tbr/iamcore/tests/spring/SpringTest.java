package fr.tbr.iamcore.tests.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import fr.tbr.iamcore.services.dao.IdentityDAOInterface;
import fr.tbr.iamcore.services.dao.impl.IdentityJDBCDAO;

@RunWith(SpringJUnit4ClassRunner.class) //This is to tell Junit to run with spring
@ContextConfiguration(locations={"application-context.xml"}) // to tell spring to load the required context
public class SpringTest {
	@Autowired
	IdentityDAOInterface dao;
	
	@Test
	public void springSetup(){
		Assert.notNull(dao);
	}

	@Test
	public void daoUsage(){
		System.out.println(dao.readAll());
	}
}
