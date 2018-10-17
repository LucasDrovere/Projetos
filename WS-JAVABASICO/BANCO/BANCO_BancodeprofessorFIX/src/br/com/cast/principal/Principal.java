package br.com.cast.principal;

import java.util.List;

import br.com.cast.modelo.Aluno;
import br.com.cast.modelo.Professor;
import br.com.cast.persistencia.AlunoDao;
import br.com.cast.persistencia.ProfessorDao;

public class Principal {

	public static void main(String[] args) {
		
		ProfessorDao professorDao = new ProfessorDao();
		AlunoDao alunoDao = new AlunoDao();
		
		Professor professor1 = new Professor();
		professor1.setNome("Fernando");
		professor1.setMateria("Beleza");
		
		Professor professor2 = new Professor();
		professor2.setNome("Matheus");
		professor2.setMateria("Java");
		
		//professorDao.inserir(professor1);
		
		
		for (int i = 1; i <= 5; i++) {
			Aluno aluno = new Aluno();
			aluno.setNome("Aluno " + i);
			aluno.setProfessor(professorDao.buscarPorId(i));
			//alunoDao.inserir(aluno);
		}
		
		professorDao.excluir(3);
		
	}

}
