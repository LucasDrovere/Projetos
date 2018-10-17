package br.com.cast.sala.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.sala.entidade.Aluno;

public class AlunoDao {

	
	private EntityManager em;
	
	public AlunoDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoSala");
		em = emf.createEntityManager();
	}
	
	public void inserir(Aluno aluno){
		
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> buscarTodos(){
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("select a ").append("from ").append(Aluno.class.getName()).append(" a ")
				.append("left join fetch a.professor ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		
	
	}

}
