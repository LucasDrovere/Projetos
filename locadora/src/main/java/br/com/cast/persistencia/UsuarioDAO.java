package br.com.cast.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.entidade.Usuario;



public class UsuarioDAO {
	private EntityManager em;

	public UsuarioDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}


	public Usuario buscarUser(String usuario, String senha) {

		Query query = em
				.createQuery("from " + Usuario.class.getName() + " where usuario = (:usuario) " + " and senha = (:senha)");

		query.setParameter("usuario", usuario);
		query.setParameter("senha", senha);

		try {
		Usuario	user = (Usuario) query.getSingleResult();
		return user;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public void inserir(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}

