package br.com.cast.filme.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.filme.entidade.Filme;

public class FilmeDao {

	EntityManager em;

	public FilmeDao() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme");
		em = emf.createEntityManager();

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

	@SuppressWarnings("unchecked")
	public List<Filme> buscarTodos() {

		StringBuilder jpql = new StringBuilder();
		jpql.append("select f ").append(" from ").append("" + Filme.class.getName()).append(" f ")
				.append(" left join fetch f.diretor ").append(" left join fetch f.genero ");

		Query query = em.createQuery(jpql.toString());

		return query.getResultList();
	}

	public void excluir(Filme filme) {
		try {
			em.getTransaction().begin();
			em.remove(filme);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
	
	public Filme buscarPorId(Integer id) {
		return em.find(Filme.class, id);
	}
	
	public void alterar(Filme filme) {
		try {
			em.getTransaction().begin();
			em.merge(filme);
			em.getTransaction().commit();
			
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
	}

}
