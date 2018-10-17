package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfprova.entidade.Categoria;


public class CategoriaDAO {

private EntityManager em;
	
	public CategoriaDAO() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}

	public List<Categoria> buscarTodos() {

		Query query = em.createQuery("FROM " + Categoria.class.getName());
		return query.getResultList();
	}

	public Categoria buscarPorId(Integer id) {
		return em.find(Categoria.class, id);
	}
}
