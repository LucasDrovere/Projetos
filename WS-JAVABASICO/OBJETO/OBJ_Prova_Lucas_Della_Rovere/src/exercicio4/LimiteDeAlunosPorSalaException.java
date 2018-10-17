package exercicio4;

public class LimiteDeAlunosPorSalaException extends Exception{

	public LimiteDeAlunosPorSalaException() {
		super("Limite de alunos na sala atingido");
	}
}
