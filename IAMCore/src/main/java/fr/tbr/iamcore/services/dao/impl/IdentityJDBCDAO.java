package fr.tbr.iamcore.services.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.services.dao.IdentityDAOInterface;


@Repository
@Transactional
public class IdentityJDBCDAO implements IdentityDAOInterface {
	/*
	 * The Autowired should be required so that Spring
	 * can use the session to connect with hibernate to the DB
	 */
	@Autowired(required = true)
	private SessionFactory sessionFactory;


	/**
	 * This is the search function to search for an identity by all the parameters
	 * @param searchText
	 * @return List of Identities
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Identity> search(String searchText) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Identity.class); 
		Criterion rest1 = null;
		if(isInt(searchText))
		{
			rest1= Restrictions.eq("id",Integer.parseInt(searchText));
		}
		else
		{
			String tmp = "%"+searchText+"%";
			rest1= Restrictions.or(Restrictions.like("firstName",tmp), 
					Restrictions.like("lastName",tmp),
					Restrictions.like("email",tmp));
			//Restrictions.eq("id",Integer.parseInt(searchText)));
		}						
		criteria.add(rest1);
		List<Identity> identities = (List<Identity>)criteria.list();
		return identities;
	}

	/**
	 * This function is to check if a string is an integer
	 * @param s
	 * @return boolean
	 */
	static boolean isInt(String s)
	{
		try
		{ 
			int i = Integer.parseInt(s); 
			return true;
		}
		catch(NumberFormatException er)
		{ 
			return false;
		}
	}

	/**
	 * This funtion us used to write an identity to the database
	 * @param identity
	 * @return void
	 */
	@Override
	public boolean write(Identity identity) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(identity);
			return true;
		}
		catch (HibernateException e) {
			//session.getTransaction().rollback();
			session.clear();
			e.printStackTrace();
			return false;
		} 

	}

	/**
	 * This function was used to update an identity
	 * it is not used anymore in the project
	 * @param identity
	 * @return void
	 */
	@Override
	public void update(Identity identity) {
		Session session = sessionFactory.getCurrentSession();
		try
		{
			session.update(identity);
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} 

	}

	/**
	 * This function is used to delete an identity from the database
	 * @param identity
	 * @return boolean (true if deleted, false if failed)
	 */
	@Override
	public boolean delete(Identity identity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try
		{
			session.delete(identity);
			return true;
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} 

	}

	/**
	 * This function is used to get all the identities from the database
	 * @param 
	 * @return List of identities
	 */
	public List<Identity> readAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Identity> identities= new ArrayList<Identity>();
		try
		{
			identities  = (List<Identity>) session.createCriteria(Identity.class).list();
		}
		catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} 
		return identities;
	}
}
