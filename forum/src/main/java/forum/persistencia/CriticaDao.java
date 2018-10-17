package forum.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import forum.entidade.Critica;
import forum.entidade.Usuario;

public class CriticaDao {
	
	private EntityManager em;
	
	public CriticaDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeUsuario");
		em = emf.createEntityManager();
	}
	
	public void remover(Critica critica) {
		try {
			em.getTransaction().begin();
			em.remove(critica);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public Critica buscarPorId(Integer id) {
		
		return em.find(Critica.class, id);
	}
	
	public List<Critica> buscarCriticasUsuario(Usuario us, Integer offset){
		Query query = em.createQuery("from " + Critica.class.getName() + " where usuario = (:us)");
		query.setParameter("us", us);
		return query.setMaxResults(5).setFirstResult(offset).getResultList();
	}
	
	public List<Critica> filtrarCriticasUsuario(Usuario us, String titulo, String descricao){
		Query query = em.createQuery("from " + Critica.class.getName() + " where usuario = (:us) and titulo = (:titulo) and descricao = (:descricao)");
		query.setParameter("us", us);
		query.setParameter("titulo", titulo);
		query.setParameter("descricao", descricao);
		return query.getResultList();
	}
	
	public void addCritica(Critica c) {
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public void alterar(Critica c) {
		try {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
		} catch (NoResultException e) {
			em.getTransaction().rollback();
		}
	}
	
	public Long tamanhoTable(Usuario us) {
		Query query = em.createQuery("select count(*) from " + Critica.class.getName() + " where usuario = (:us)");
		query.setParameter("us", us);
		return (Long) query.getSingleResult();
	}

}
