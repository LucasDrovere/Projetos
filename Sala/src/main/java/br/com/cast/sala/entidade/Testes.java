package br.com.cast.sala.entidade;

import br.com.cast.sala.persistencia.AlunoDao;

public class Testes {

	public static void main(String[] args) {
		
		Aluno a = new Aluno();
		
		a.setNome("Agenor");
		Professor p = new Professor();
		p.setNome("Teste");
		p.setMateria("Geografia");
		a.setProfessor(p);
		
		AlunoDao dao = new AlunoDao();
		
		try{
			dao.inserir(a);
		}catch(Exception e){
			new RuntimeException();
		}
		
		

	}

}
