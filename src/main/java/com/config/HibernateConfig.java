package com.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	
	static Configuration cf = new Configuration();
	
	static public SessionFactory getSessionFactory() {
		cf.configure();                     // Read the Configuration File 
		SessionFactory sessionFactory = cf.buildSessionFactory();   // Build Session Factory for Database Operation 		
		return sessionFactory;
	}
}
