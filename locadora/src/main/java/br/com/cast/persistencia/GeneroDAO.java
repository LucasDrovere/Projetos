package br.com.cast.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.entidade.Genero;


public class GeneroDAO {

private EntityManager em;
	
	public GeneroDAO() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public void inserir(Genero genero) {
		try {

			em.getTransaction().begin();
			em.persist(genero);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<Genero> buscarTodos() {

		Query query = em.createQuery("FROM " + Genero.class.getName());
		return query.getResultList();
	}

	public void remover(Integer id) {
		Genero genero = buscarPorId(id);
		
		try {
			em.getTransaction().begin();
			em.remove(genero);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Genero buscarPorId(Integer id) {
		return em.find(Genero.class, id);
	}
}
