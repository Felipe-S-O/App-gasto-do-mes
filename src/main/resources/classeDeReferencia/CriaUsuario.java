package br.com.inottec.modelo;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class CriaUsuario {

	public static Logger logger =  Logger.getLogger(CriaUsuario.class);
	
	public static void main(String[] args) {

		//criando conexão com o banco
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//abrindo conexão com o banco
		session.beginTransaction();

		//criando usuario e adicionando os atributos
		EntityUsuario usuario = new EntityUsuario("Marizate", "125");		

		//gravando usuario no banco
		session.save(usuario);
		session.getTransaction().commit();
		
		//finalizando conexão com o banco
		HibernateUtil.getSessionFactory().close();
		
		//adicionando logger de informação que imprime na tela 
		logger.info("Usuario cadastrado com suceço");
	}

}
