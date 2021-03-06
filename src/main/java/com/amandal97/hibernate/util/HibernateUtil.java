package com.amandal97.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.amandal97.hibernate.model.User;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
//				Configuration configuration = new Configuration();
				
				// Hibernate setting equivalent to hibernate.cfh.xml properties
//				Properties settings = new Properties();
//				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/kingfisher");
//				settings.put(Environment.USER, "root");
//				settings.put(Environment.PASS, "root");
//				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//
//				settings.put(Environment.SHOW_SQL, "true");
//
//				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//
//				configuration.setProperties(settings);
//				
//				configuration.addAnnotatedClass(User.class);
//				
//				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//									.applySettings(configuration.getProperties()).build();
//				
//				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				sessionFactory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(User.class)
						.buildSessionFactory();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
