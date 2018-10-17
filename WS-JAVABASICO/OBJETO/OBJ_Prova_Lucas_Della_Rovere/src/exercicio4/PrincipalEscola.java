package exercicio4;

public class PrincipalEscola {

	public static void main(String[] args) {
		Professor prof = new Professor("Logica");

		Aluno aln1 = new Aluno("Lucas", "1111");
		Aluno aln2 = new Aluno("Bianca", "2222");
		Aluno aln3 = new Aluno("Joao", "3333");
		Aluno aln4 = new Aluno("Jose", "4444");
		Aluno aln5 = new Aluno("Maria", "5555");

		SalaDeAula s = new SalaDeAula(prof);

		try {
			s.adicionarAluno(aln1);
			System.out.println("Aluno " + aln1.getNome() + ", numero da chamada: " + s.getChamada() + ", adicionado com sucesso!");
			s.adicionarAluno(aln2); 
			System.out.println("Aluno " + aln2.getNome() + ", numero da chamada: " + s.getChamada() + ", adicionado com sucesso!");
			s.adicionarAluno(aln3);
			System.out.println("Aluno " + aln3.getNome() + ", numero da chamada: " + s.getChamada() + ", adicionado com sucesso!");
			s.adicionarAluno(aln4);
			System.out.println("Aluno " + aln4.getNome() + ", numero da chamada: " + s.getChamada() + ", adicionado com sucesso!");
			s.adicionarAluno(aln5);
			System.out.println("Aluno " + aln5.getNome() + ", numero da chamada: " + s.getChamada() + ", adicionado com sucesso!");
		} catch (LimiteDeAlunosPorSalaException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.print("Calculando media do aluno: " + aln1.getNome());
		prof.avaliar(aln1, 10, 5);
		System.out.print("Calculando media do aluno: " + aln2.getNome());
		prof.avaliar(aln2, 6, 7);
		System.out.print("Calculando media do aluno: " + aln3.getNome());
		prof.avaliar(aln3, 3, 2);
		System.out.print("Calculando media do aluno: " + aln4.getNome());
		prof.avaliar(aln5, 8, 9);
		System.out.print("Calculando media do aluno: " + aln5.getNome());
		prof.avaliar(aln5, 1, 1);
	}

}
