package br.com.cast.bancodefilmes.principal;

import java.util.List;
import java.util.Scanner;

import br.com.cast.bancodefilmes.modelo.Aluno;
import br.com.cast.bancodefilmes.modelo.Professor;
import br.com.cast.bancodefilmes.persistencia.AlunoDAO;
import br.com.cast.bancodefilmes.persistencia.ProfessorDAO;

public class PrincipalEscola {

	public static void main(String[] args) {

		AlunoDAO daoAlunos = new AlunoDAO();
		ProfessorDAO daoProfessores = new ProfessorDAO();
		List<Aluno> alunos = daoAlunos.buscarTodos();
		List<Professor> professores = daoProfessores.buscarTodos();

		System.out.println("---Exercicio Escola com banco---");
		System.out.println();

		Scanner ler = new Scanner(System.in);
		System.out.println("Deseja criar novos professores? ");
		String op = ler.nextLine();

		while (op.equals("s")) {

			// CRIA DOIS PROFESSORES E INSERE//
			Professor profUm = new Professor();
			profUm.setNome("Casao");
			profUm.setMateria("JAVA");
			daoProfessores.inserir(profUm);

			Professor profDois = new Professor();
			profDois.setNome("Eric");
			profDois.setMateria("SQL");
			daoProfessores.inserir(profDois);
			// FIM CRIA PROFESSOR//
		}
		
		listarProfessores(professores);
		System.out.println("----------------------------------");
		listarAlunos(alunos);

		
		Aluno alnTeste = new Aluno();
		alnTeste.setNome("tester");
		//alnTeste.setProfessor(daoProfessores.buscarPorId(2));
		daoAlunos.inserir(alnTeste);
		listarAlunos(alunos);
		
		
		System.out.println();
		System.out.println("Professor pesquisado por ID: " + daoProfessores.buscarPorId(1));

		System.out.println("Deseja criar novos alunos? ");
		op = ler.nextLine();

		while (op.equals("s")) {
			// CRIA ALUNOS E INSERE//
			Aluno alnDois = new Aluno();
			alnDois.setNome("Bianca");
			alnDois.setProfessor(daoProfessores.buscarPorId(3));
			daoAlunos.inserir(alnDois);

			Aluno alnTres = new Aluno();
			alnTres.setNome("Pedro");
			alnTres.setProfessor(daoProfessores.buscarPorId(4));
			daoAlunos.inserir(alnTres);

			Aluno alnQuatro = new Aluno();
			alnQuatro.setNome("Paulo");
			alnQuatro.setProfessor(daoProfessores.buscarPorId(5));
			daoAlunos.inserir(alnQuatro);

			Aluno alnCinco = new Aluno();
			alnCinco.setNome("Joao");
			alnCinco.setProfessor(daoProfessores.buscarPorId(6));
			daoAlunos.inserir(alnCinco);
			// FIM INSERE ALUNOS//
		}
		
		//ALTERAR
		//daoAlunos.alterar(daoAlunos.buscarPorId(1), 9);
		//daoProfessores.alterar(daoProfessores.buscarPorId(2), 3);

		System.out.println();

		listarAlunos(daoAlunos.buscarTodos());

		System.out.println();
		// System.out.println("Aluno pesquisado por ID: " + daoAlunos.buscarPorId(2));
		
		daoAlunos.excluir(4);
		//daoProfessores.excluir(1);
		
	}

	public static void listarAlunos(List<Aluno> alunos) {
		System.out.println("Lista de alunos: ");
		for (Aluno a : alunos) {
			System.out.println(a);
		}
	}

	public static void listarProfessores(List<Professor> professores) {
		System.out.println("Lista de professores: ");
		for (Professor p : professores) {
			System.out.println(p);
		}
	}
}
