package exercicio4;

public class Aluno extends Pessoa implements Avaliavel{
	
	public String matricula;
	
	public Aluno(String nome, String matricula) {
		super(nome);
		this.matricula = matricula;
	}

	@Override
	public double calcularNota(double nota1, double nota2) {
		return nota1 + nota2 /2;
	}
}
