package br.com.cast.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.entidade.Filme;

public class FilmeDAO {

private EntityManager em;
	
	public FilmeDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	
	public List<Filme> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select f ").append("from ").append(Filme.class.getName()).append(" f ")
				.append("left join fetch f.genero ").append("left join fetch f.diretor ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
	public void inserir(Filme filme) {
		try {
			em.getTransaction().begin();
			em.persist(filme);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public void remover(Integer id) {
		Filme filme = buscarPorId(id);
		
		try {
			em.getTransaction().begin();
			em.remove(filme);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void alterar(Filme filme) {
		try {
			em.getTransaction().begin();
			em.merge(filme);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public Filme buscarPorId(Integer id) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT f ").append("FROM ").append(Filme.class.getName()).append(" f ")
				.append(" INNER JOIN FETCH f.genero g ").append(" INNER JOIN FETCH f.diretor d ")
				.append(" WHERE f.id = :idFilme ");

		
		
		Query query = em.createQuery(hql.toString());
		query.setParameter("idFilme", id);

		try {
			return (Filme) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}
}
