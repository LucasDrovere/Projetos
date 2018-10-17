package br.com.cast.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cast.entidade.Post;

public class PostDao {
	
	private EntityManager em;
	
	public PostDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public List<Post> buscarTodos() {
		StringBuilder qlString = new StringBuilder();
		qlString.append("select distinct p ")
				.append("from ").append(Post.class.getName()).append(" p ")
				.append(" join fetch p.imagens ");
		return em.createQuery(qlString.toString(), Post.class)
				 .getResultList();
		
		
	}
	
	public void inserir(Post post) {
		try {
			em.getTransaction().begin();
			em.persist(post);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public Post buscarPorId(Integer id) {
		return em.find(Post.class, id);
	}

	public void fechar() {
		em.close();
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
}
