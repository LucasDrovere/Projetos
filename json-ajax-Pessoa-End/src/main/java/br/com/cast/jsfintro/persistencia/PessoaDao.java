package br.com.cast.jsfintro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfintro.entidade.Pessoa;

public class PessoaDao {

	private EntityManager em;
	
	public PessoaDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public List<Pessoa> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select p ").append("from ").append(Pessoa.class.getName()).append(" p ")
				.append("left join fetch p.endereco ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}

	public void inserir(Pessoa pessoa) {
		em.getTransaction().begin();
		try {
			em.persist(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void remover(Pessoa pessoa) {
		try {
			em.getTransaction().begin();
			em.remove(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void alterar(Pessoa pessoa) {
		try {
			em.getTransaction().begin();
			em.merge(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Pessoa buscarPorCpf(String cpf) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT p ").append("FROM ").append(Pessoa.class.getName()).append(" p ")
				.append(" INNER JOIN FETCH p.endereco e ").append(" WHERE p.cpf = :cpfPessoa ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("cpfPessoa", cpf);

		try {
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public void excluir(Pessoa pessoa) {
		try {
			em.getTransaction().begin();
			em.remove(pessoa);
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
	}
}
