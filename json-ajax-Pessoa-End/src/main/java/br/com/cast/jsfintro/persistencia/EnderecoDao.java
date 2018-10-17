package br.com.cast.jsfintro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfintro.dto.EnderecoDTO;
import br.com.cast.jsfintro.entidade.Endereco;

public class EnderecoDao {
	private EntityManager em;

	public EnderecoDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}

	public List<EnderecoDTO> buscarTodosComPojo() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select new br.com.cast.jsfintro.dto.EnderecoDTO( ").append(" e.cep, e.logradouro, e.numero, e.complemento, e.bairro, e.cidade, e.uf ")
				.append(") ").append("from ").append(Endereco.class.getName()).append(" e ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}

	public Endereco buscarPorCep(String cep) {
		return em.find(Endereco.class, cep);
	}

	public void inserir(Endereco endereco) {
		em.getTransaction().begin();
		try {
			em.persist(endereco);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void remover(String cep) {
		
		Endereco end = buscarPorCep(cep);
		try {
			em.getTransaction().begin();
			em.remove(end);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void alterar(Endereco endereco) {
		try {
			em.getTransaction().begin();
			em.merge(endereco);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
