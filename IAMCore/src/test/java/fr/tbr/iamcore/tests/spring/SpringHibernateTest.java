package fr.tbr.iamcore.tests.spring;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import fr.tbr.iamcore.datamodel.Identity;


@RunWith(SpringJUnit4ClassRunner.class) //This is to tell Junit to run with spring
@ContextConfiguration(locations={"application-context.xml"}) // to tell spring to load the required context
public class SpringHibernateTest {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Test
	public void springSetup(){
		Assert.notNull(ds);
	}

	@Test
	public void dataSourceUsage() throws SQLException{
		Connection connection = ds.getConnection();
		System.out.println(connection.getSchema());
		connection.close();
		
	}
	
	
	@Test
	public void sessionFactoryUsage(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();;
		try {
			date = sdf.parse("22-03-2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Identity identity = new Identity("Thomas","Broussard","thomas.broussard@gmail.com",date);
		session.saveOrUpdate(identity);
		tx.commit();
	}
	
	
	@Test
	public void hibernateSearch(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Identity> identities  = session.createCriteria(Identity.class).list();
		
		System.out.println(identities);
		
	}
	
	@Test public void hibernateWrite()
	{
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        //Add new Employee object
        Identity identity = new Identity();
        identity.setEmail("test@test.com");
        identity.setFirstName("sdsd");
        identity.setLastName("testing");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();;
		try {
			date = sdf.parse("22-03-2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        identity.setBirthDate(date); 
        //Save the employee in database
        session.save(identity);
 
        //Commit the transaction
        session.getTransaction().commit();
	}
}
