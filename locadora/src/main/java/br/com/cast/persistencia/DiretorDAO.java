package br.com.cast.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.entidade.Diretor;

public class DiretorDAO {

	private EntityManager em;

	public DiretorDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}

	public List<Diretor> buscarTodos() {
		Query query = em.createQuery("FROM " + Diretor.class.getName());
		return query.getResultList();
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

	public void excluir(Integer id) {
			Diretor diretor = buscarPorId(id);
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
