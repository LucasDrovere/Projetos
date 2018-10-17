package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfprova.entidade.Autor;

public class AutorDAO {

	private EntityManager em;

	public AutorDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}

	public List<Autor> buscarTodos() {
		Query query = em.createQuery("FROM " + Autor.class.getName());
		return query.getResultList();
	}


	public Autor buscarPorId(Integer id) {
		return em.find(Autor.class, id);
	}

}
