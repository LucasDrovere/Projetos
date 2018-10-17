package br.com.cast.jsfintro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfintro.dto.ProfessorDTO;
import br.com.cast.jsfintro.entidade.Aluno;
import br.com.cast.jsfintro.entidade.Professor;

public class AlunoDao {

	private EntityManager em;

	public AlunoDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public List<Aluno> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select a ").append("from ").append(Aluno.class.getName()).append(" a ")
				.append("left join fetch a.professor ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}

	public void inserir(Aluno aluno) {
		em.getTransaction().begin();
		try {
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void remover(Integer id) {

		Aluno aluno = buscarPorId(id);

		try {
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void alterar(Aluno aluno) {
		try {
			em.getTransaction().begin();
			em.merge(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Aluno buscarPorId(Integer id) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT a ").append("FROM ").append(Aluno.class.getName()).append(" a ")
				.append(" INNER JOIN FETCH a.professor p ").append(" WHERE a.id = :idAluno ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("idAluno", id);

		try {
			return (Aluno) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public void excluir(Aluno aluno) {
		try {
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
	}

}
