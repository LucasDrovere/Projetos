package br.com.cast.filme.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.filme.entidade.Genero;

public class GeneroDao {
	EntityManager em;

	public GeneroDao() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme");
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

	@SuppressWarnings("unchecked")
	public List<Genero> buscarTodos() {

		Query query = em.createQuery("FROM " + Genero.class.getName());
		return query.getResultList();
	}

	public void excluir(Genero genero) {
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

	public void alterar(Genero genero) {
		try {
			em.getTransaction().begin();
			em.merge(genero);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

}
