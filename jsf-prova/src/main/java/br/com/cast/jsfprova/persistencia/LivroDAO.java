package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfprova.entidade.Livro;


public class LivroDAO {
	private EntityManager em;

	public LivroDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}

	public Livro buscarLivro(String titulo) {
		Query query = em
				.createQuery("from " + Livro.class.getName() + " where titulo = (:titulo)");

		query.setParameter("titulo", titulo);

		try {
		Livro l = (Livro) query.getSingleResult();
		return l;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public List<Livro> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select l ").append("from ").append(Livro.class.getName()).append(" l ")
				.append("left join fetch l.autor ").append("left join fetch l.categoria ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}

	public void inserir(Livro livro) {
		try {
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void remover(Integer id) {
		Livro livro = buscarPorId(id);

		try {
			em.getTransaction().begin();
			em.remove(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void alterar(Livro livro) {
		try {
			em.getTransaction().begin();
			em.merge(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Livro buscarPorId(Integer id) {
		return em.find(Livro.class, id);
	}
	
	public Livro buscarPorIds(Integer id) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT l ").append("FROM ").append(Livro.class.getName()).append(" l ")
				.append(" INNER JOIN FETCH l.autor a ").append(" INNER JOIN FETCH l.categoria c ")
				.append(" WHERE l.id = :idLivro ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("idLivro", id);

		try {
			return (Livro) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}
}
