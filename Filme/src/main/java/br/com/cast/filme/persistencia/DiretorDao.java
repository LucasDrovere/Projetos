package br.com.cast.filme.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.filme.entidade.Diretor;

public class DiretorDao {

	EntityManager em;

	public DiretorDao() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme");
		em=emf.createEntityManager();

	}

	public void inserir(Diretor diretor) {
		try {
			em.getTransaction().begin();
			em.persist(diretor);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<Diretor> buscarTodos() {

		Query query = em.createQuery("FROM " + Diretor.class.getName());
		return query.getResultList();
	}

	public void excluir(Diretor diretor) {
		try {
			em.getTransaction().begin();
			em.remove(diretor);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public Diretor buscarPorId(Integer id) {
		return em.find(Diretor.class, id);
	}

	public void alterar(Diretor diretor) {
		try {
			em.getTransaction().begin();
			em.merge(diretor);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}


