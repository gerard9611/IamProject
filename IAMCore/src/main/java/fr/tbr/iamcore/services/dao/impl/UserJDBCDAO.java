package fr.tbr.iamcore.services.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.tbr.iamcore.datamodel.User;
import fr.tbr.iamcore.services.dao.UserDAOInterface;


@Repository
@Transactional
public class UserJDBCDAO implements UserDAOInterface {

	/*
	 * The Autowired should be required so that Spring
	 * can use the session to connect with hibernate to the DB
	 */
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	/**
	 * This function is used to write the user to DB
	 * @param User
	 * @return boolean (success or fail)
	 */
	@Override
	public boolean write(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(user);
			return true;
		}
		catch (HibernateException e) {
			session.clear();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This function is used to authenticate the user
	 * @param user
	 * @return boolean (success, fail)
	 */
	@Override
	public boolean authenticate(User user) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class); 
		Criterion rest1= Restrictions.and(Restrictions.eq("username",user.getUsername()), 
				Restrictions.eq("password",user.getPassword()));

		criteria.add(rest1);
		User userFromDb =(User) criteria.uniqueResult();
		if(userFromDb != null)
		{
			user.setId(userFromDb.getId());
			return true;
		}
		else
		{
			return false;
		}
	}
}
