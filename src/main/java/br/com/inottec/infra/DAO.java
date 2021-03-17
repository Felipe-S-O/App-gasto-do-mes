package br.com.inottec.infra;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import br.com.inottec.modelo.RestricaoEntidade;
import br.com.inottec.modelo.HibernateUtil;

//clase generica e criando uma restrição com entidade
public class DAO<E extends RestricaoEntidade> {

	// criando um logger
	private Logger logger = Logger.getLogger(DAO.class);

	public DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void incluirEntidade(E entidade) {
		// criando conexão com o banco
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// abrindo conexão com o banco
		session.beginTransaction();

		// gravando usuario no banco
		session.save(entidade);
		session.getTransaction().commit();

		// adicionando logger de informação que imprime na tela
		logger.info("Entidade cadastrado no  com suceço");
	}
}
