package com.amandal97.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amandal97.hibernate.model.User;
import com.amandal97.hibernate.util.HibernateUtil;

public class UserDao {
	
	public void saveUser(User user) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			// Start the transaction
			transaction = session.beginTransaction();
			
			// save user object
			session.save(user);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
	}
	
	public void updateUser(User user) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			// Start the transaction
			transaction = session.beginTransaction();
			
			// update user object
			session.saveOrUpdate(user);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
	}
	
	public User getUserById(int id) {
		Transaction transaction = null;
		User user = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			// Start the transaction
			transaction = session.beginTransaction();
			
			// get the user
			user = session.get(User.class, id); 
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
		return user;
	}
	
	public List<User> getAllUsers() {
		Transaction transaction = null;
		List<User> users = new ArrayList<>();
		try {
			String queryString = "FROM User";
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
			// Start the transaction
			transaction = session.beginTransaction();
			
			// get users
			users = session.createQuery(queryString).getResultList();
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
		return users;
	}
	
	public void deleteUser(int id) {
		Transaction transaction = null;
		User user = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			// Start the transaction
			transaction = session.beginTransaction();
			
			// get the user
			user = session.get(User.class, id); 
			// delete the user
			session.delete(user);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
	}

}
