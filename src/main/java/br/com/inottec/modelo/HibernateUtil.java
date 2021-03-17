package br.com.inottec.modelo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		
		try {
		   // Crie a SessionFactory de hibernate.cfg.xml
		   return new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) {
		   // Certifique-se de registrar a exceção, pois ela pode ser engolida
		   System.err.println("A criação inicial da SessionFactory falhou." + ex);
		   throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
		
	}		

}
