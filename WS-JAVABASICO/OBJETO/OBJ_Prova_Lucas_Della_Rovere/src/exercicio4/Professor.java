package exercicio4;

public class Professor {

	private String materia;

	public Professor(String materia) {
		this.materia = materia;
	}

	public boolean avaliar(Avaliavel avaliavel, double nota1, double nota2) {
		double mediaNota = avaliavel.calcularNota(nota1, nota2);
		boolean aprovado = mediaNota > 6;
		if (aprovado) {
			System.out.println("\t\tAprovado, media maior ou igual a 6");
		}
		if(!aprovado)
		System.out.println("\t\tReprovado");
		return aprovado;
	}
}
