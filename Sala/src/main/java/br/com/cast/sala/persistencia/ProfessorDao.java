package br.com.cast.sala.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cast.sala.entidade.Professor;

public class ProfessorDao {

	EntityManager em;
	
	public ProfessorDao() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoSala");
		em = emf.createEntityManager();
		
	}
	
	public Professor buscaPorId (Integer id) {
		
		return em.find(Professor.class,id);
		
	}
	
}
