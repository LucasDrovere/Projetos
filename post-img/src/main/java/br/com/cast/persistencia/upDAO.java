package br.com.cast.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cast.entidade.Arq;


public class upDAO {

	private EntityManager em;

	public upDAO() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public void inserir(Arq f) {
		try {
			em.getTransaction().begin();
			em.persist(f);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}
