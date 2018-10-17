package forum.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import forum.entidade.Usuario;

public class UsuarioDao {
	
	private EntityManager em;
	
	public UsuarioDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeUsuario");
		em = emf.createEntityManager();
	}
	
	public void inserir(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public Usuario verificaLogin(String usuario, String senha) {
		Query query = em.createQuery("from " + Usuario.class.getName() + " where usuario = (:usuario) and senha = (:senha)");
		query.setParameter("usuario", usuario);
		query.setParameter("senha", senha);
		
		try {
			
			return (Usuario) query.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/*public void alterar(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		} catch (NoResultException e) {
			em.getTransaction().rollback();
		}
	}*/
	
	/*public Usuario buscarPorId(Integer id) {
		Usuario us = em.find(Usuario.class, id);
		return us;
	}*/
	
}
