package br.com.cast.castapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.castapi.model.Pessoa;

@Repository
public class PessoaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Pessoa> buscarTodas() {
		return entityManager.createQuery(
				  "SELECT p "
				+ "FROM Pessoa p "
				+ "join fetch p.endereco")
			.getResultList();
	}

	public void inserir(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}

}
